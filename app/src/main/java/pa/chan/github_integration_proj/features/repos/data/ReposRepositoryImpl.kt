package pa.chan.github_integration_proj.features.repos.data

import pa.chan.github_integration_proj.features.repos.data.extension.toModel
import pa.chan.github_integration_proj.features.repos.domain.ReposRepository
import pa.chan.github_integration_proj.features.repos.domain.model.ReposModel
import javax.inject.Inject

class ReposRepositoryImpl @Inject constructor(
    private val remoteDataSource: ReposRemoteDataSource,
    private val localDataSource: ReposLocalDataSource
) : ReposRepository {
    override suspend fun getUserRepos(reposPath: String): List<ReposModel> {
        return try {
            remoteDataSource
                .getUserRepos(reposPath)
                .map {
                    it.toModel()
                }
        } catch (e: Exception) {
            localDataSource
                .getAll()
                .map {
                    it.toModel()
                }
        }

    }
}