package pa.chan.github_integration_proj.features.detail.domain

import pa.chan.github_integration_proj.features.detail.domain.model.RepositoryModel

interface DetailRepository {
    suspend fun getRepository(repo: String, id: Long?): RepositoryModel
    suspend fun getHistory(id: Long?): RepositoryModel
}