package pa.chan.github_integration_proj.features.detail.domain

import pa.chan.github_integration_proj.features.detail.domain.model.RepositoryModel

interface DetailRepository {
    suspend fun getRepository(repo: String): RepositoryModel

    suspend fun logout()

}