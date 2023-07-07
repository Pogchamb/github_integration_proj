package pa.chan.github_integration_proj.features.detail.data

import pa.chan.github_integration_proj.features.detail.data.entity.RepositoryEntity
import javax.inject.Inject

class DetailLocalDatasource @Inject constructor(
    private val detailDao: DetailDao
) {
    suspend fun getRepositoryById(id: Long?): RepositoryEntity {
        return detailDao.getRepositoryById(id)
    }

    suspend fun getRepository(): List<RepositoryEntity> {
        return detailDao.getRepository()
    }

    suspend fun insertRepository(repositoryEntity: RepositoryEntity) {
        detailDao.insertRepository(repositoryEntity)
    }

    suspend fun deleteRepository() {
        detailDao.deleteRepository()
    }


}