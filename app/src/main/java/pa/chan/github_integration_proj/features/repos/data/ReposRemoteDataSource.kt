package pa.chan.github_integration_proj.features.repos.data

import pa.chan.github_integration_proj.features.repos.data.dto.ReposDTO
import javax.inject.Inject

class ReposRemoteDataSource @Inject constructor(
    private val reposApi: ReposApi
) {
    suspend fun getUserRepos(reposPath: String): List<ReposDTO> {
        return reposApi.getUserRepos(reposPath)
    }
}