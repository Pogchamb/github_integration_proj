package pa.chan.github_integration_proj.features.auth.data

import pa.chan.github_integration_proj.features.auth.data.extension.toModel
import pa.chan.github_integration_proj.features.auth.domain.AuthRepository
import pa.chan.github_integration_proj.features.auth.domain.model.UserModel
import retrofit2.HttpException


class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authPrefDataSource: AuthPrefDataSource
) : AuthRepository {
    override suspend fun getUserDetails(token: String): UserModel {
        return try {
            if(authPrefDataSource.getUserToken().isNullOrEmpty()) {
                val user = authRemoteDataSource.getUserDetails(token)
                authPrefDataSource.setUserToken(token)
                user.toModel()
            } else {
                authRemoteDataSource.getUserDetails(authPrefDataSource.getUserToken().orEmpty()).toModel()
            }
        } catch (e: HttpException) {
            throw e
        }
    }
}