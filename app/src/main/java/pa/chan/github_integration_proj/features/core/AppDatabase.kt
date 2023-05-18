package pa.chan.github_integration_proj.features.core

import androidx.room.Database
import androidx.room.RoomDatabase
import pa.chan.github_integration_proj.features.detail.data.DetailDao
import pa.chan.github_integration_proj.features.repos.data.ReposDao
import pa.chan.github_integration_proj.features.repos.data.entity.ReposEntity

@Database(entities = [ReposEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reposDao(): ReposDao
    abstract fun detailDao(): DetailDao
}