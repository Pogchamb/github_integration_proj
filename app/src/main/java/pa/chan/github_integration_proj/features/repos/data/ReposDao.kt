package pa.chan.github_integration_proj.features.repos.data

import androidx.room.Dao
import androidx.room.Query
import pa.chan.github_integration_proj.features.repos.data.entity.ReposEntity


@Dao
interface ReposDao : List<ReposEntity> {

    @Query("SELECT * FROM reposentity")
    suspend fun getAll(): List<ReposEntity>
}