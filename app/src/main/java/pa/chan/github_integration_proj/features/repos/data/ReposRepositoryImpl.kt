package pa.chan.github_integration_proj.features.repos.data

import pa.chan.github_integration_proj.features.auth.data.PrefDataSource
import pa.chan.github_integration_proj.features.auth.data.userExceptions.ConnectionException
import pa.chan.github_integration_proj.features.auth.data.userExceptions.EmptyReposException
import pa.chan.github_integration_proj.features.repos.data.extension.toEntity
import pa.chan.github_integration_proj.features.repos.data.extension.toModel
import pa.chan.github_integration_proj.features.repos.domain.ReposRepository
import pa.chan.github_integration_proj.features.repos.domain.model.ReposModel
import javax.inject.Inject

class ReposRepositoryImpl @Inject constructor(
    private val remoteDataSource: ReposRemoteDataSource,
    private val localDataSource: ReposLocalDataSource,
    private val prefDataSource: PrefDataSource
) : ReposRepository {
    override suspend fun getUserRepos(): List<ReposModel> {
        return try {
            remoteDataSource
                .getUserRepos(prefDataSource.getUserName())
                .map {
                    localDataSource.setRepos(it.toEntity())
                    it.toModel()
                }
            if (getUserReposHistory().isEmpty()) throw EmptyReposException
            getUserReposHistory()
        } catch (e: EmptyReposException) {
            throw e
        } catch (e: Exception) {
            throw ConnectionException
        }

    }

    override suspend fun getUserReposHistory(): List<ReposModel> {
        return localDataSource
            .getAll()
            .map {
                it.toModel()
            }
    }

    override suspend fun logOut() {
        localDataSource.clearAll()
        prefDataSource.clearAll()
    }
}