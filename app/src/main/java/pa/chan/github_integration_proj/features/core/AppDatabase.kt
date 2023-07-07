package pa.chan.github_integration_proj.features.core

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pa.chan.github_integration_proj.features.detail.data.DetailDao
import pa.chan.github_integration_proj.features.detail.data.converters.EntityConverter
import pa.chan.github_integration_proj.features.detail.data.entity.RepositoryEntity
import pa.chan.github_integration_proj.features.repos.data.ReposDao
import pa.chan.github_integration_proj.features.repos.data.entity.ReposEntity

@Database(
    entities = [ReposEntity::class, RepositoryEntity::class],
    version = 1
)
@TypeConverters(EntityConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun reposDao(): ReposDao
    abstract fun detailDao(): DetailDao
}