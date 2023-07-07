package pa.chan.github_integration_proj.features.auth.data

import pa.chan.github_integration_proj.features.auth.data.extension.toModel
import pa.chan.github_integration_proj.features.auth.data.userExceptions.ConnectionException
import pa.chan.github_integration_proj.features.auth.data.userExceptions.InvalidCredentialsException
import pa.chan.github_integration_proj.features.auth.domain.AuthRepository
import pa.chan.github_integration_proj.features.auth.domain.model.UserModel
import pa.chan.github_integration_proj.features.detail.data.DetailLocalDatasource
import pa.chan.github_integration_proj.features.repos.data.ReposLocalDataSource
import retrofit2.HttpException
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val prefDataSource: PrefDataSource,
    private val reposLocalDataSource: ReposLocalDataSource,
    private val detailLocalDatasource: DetailLocalDatasource
) : AuthRepository {
    override suspend fun getUserDetails(token: String): UserModel {
        try {
            return if (prefDataSource.getUserToken().isNullOrEmpty()) {
                val user = authRemoteDataSource.getUserDetails(token)
                prefDataSource.setUserToken(token)
                prefDataSource.setUserName(user.login.toString())
                user.toModel()
            } else {
                authRemoteDataSource.getUserDetails(
                    prefDataSource.getUserToken().orEmpty()
                ).toModel()
            }
        } catch (e: HttpException) {
            throw InvalidCredentialsException
        } catch (e: Exception) {
            throw ConnectionException
        }

    }

    override suspend fun logout() {
        prefDataSource.clearAll()
        reposLocalDataSource.clearAll()
        detailLocalDatasource.deleteRepository()
    }


}