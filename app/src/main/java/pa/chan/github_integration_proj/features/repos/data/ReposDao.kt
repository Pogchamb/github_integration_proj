package pa.chan.github_integration_proj.features.repos.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pa.chan.github_integration_proj.features.repos.data.entity.ReposEntity


@Dao
interface ReposDao {

    @Query("SELECT * FROM reposentity")
    suspend fun getAll(): List<ReposEntity>

    @Insert
    suspend fun insert(reposEntity: ReposEntity)

}