package pa.chan.github_integration_proj.features.repos.data

import androidx.room.Database
import androidx.room.RoomDatabase
import pa.chan.github_integration_proj.features.repos.data.entity.ReposEntity


@Database(entities = [ReposEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun reposDao(): ReposDao
}