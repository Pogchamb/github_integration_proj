package pa.chan.github_integration_proj.features.detail.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pa.chan.github_integration_proj.features.detail.data.entity.RepositoryEntity

@Dao
interface DetailDao {

    @Query("SELECT * FROM repositoryEntity WHERE id=:id")
    suspend fun getRepositoryById(id: Long?): RepositoryEntity

    @Query("SELECT * FROM repositoryEntity")
    suspend fun getRepository(): List<RepositoryEntity>

    @Insert
    suspend fun insertRepository(repositoryEntity: RepositoryEntity)

    @Query("DELETE FROM repositoryEntity")
    suspend fun deleteRepository()

}