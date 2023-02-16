package pa.chan.github_integration_proj.features.auth.data

import pa.chan.github_integration_proj.features.auth.data.extension.toModel
import pa.chan.github_integration_proj.features.auth.domain.AuthRepository
import pa.chan.github_integration_proj.features.auth.domain.model.UserModel


class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun getUserDetails(token: String): UserModel {
        return authRemoteDataSource.getUserDetails(token).toModel()
    }
}