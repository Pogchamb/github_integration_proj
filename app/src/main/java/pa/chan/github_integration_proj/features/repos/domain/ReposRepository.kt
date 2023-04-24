package pa.chan.github_integration_proj.features.repos.domain

import pa.chan.github_integration_proj.features.repos.domain.model.ReposModel


interface ReposRepository {
    suspend fun getUserRepos(userName: String): List<ReposModel>
}