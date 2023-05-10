package pa.chan.github_integration_proj.features.detail.domain

import pa.chan.github_integration_proj.features.detail.domain.model.RepositoryModel

interface DetailRepository {
    suspend fun getRepository(owner: String, repo: String): RepositoryModel

    suspend fun logout()

}