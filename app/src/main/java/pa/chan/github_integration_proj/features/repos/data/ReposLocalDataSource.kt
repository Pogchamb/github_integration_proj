package pa.chan.github_integration_proj.features.repos.data

import pa.chan.github_integration_proj.features.repos.data.entity.ReposEntity
import javax.inject.Inject

class ReposLocalDataSource @Inject constructor(private val reposDao: ReposDao) {
    suspend fun getAll(): List<ReposEntity> {
        return reposDao.getAll()
    }
}