package pa.chan.github_integration_proj.features.auth.data

import pa.chan.github_integration_proj.features.auth.data.extension.toModel
import pa.chan.github_integration_proj.features.auth.domain.AuthRepository
import pa.chan.github_integration_proj.features.auth.domain.model.UserModel
import retrofit2.HttpException
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authPrefDataSource: AuthPrefDataSource
) : AuthRepository {
    override suspend fun getUserDetails(username: String, token: String): UserModel {
        return try {
            if (authPrefDataSource.getUserToken().isNullOrEmpty()) {
                val user = authRemoteDataSource.getUserDetails(username, token)
                authPrefDataSource.setUserToken(token)
                authPrefDataSource.setUserName(username)
                user.toModel()
            } else {
                authRemoteDataSource.getUserDetails(
                    authPrefDataSource.getUserName().orEmpty(),
                    authPrefDataSource.getUserToken().orEmpty()
                ).toModel()
            }
        } catch (e: HttpException) {
            throw e
        }
    }
}