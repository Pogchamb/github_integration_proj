package pa.chan.github_integration_proj.features.repos.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pa.chan.github_integration_proj.features.core.AppDatabase
import pa.chan.github_integration_proj.features.repos.data.ReposRepositoryImpl
import pa.chan.github_integration_proj.features.repos.domain.ReposRepository


@Module
@InstallIn(SingletonComponent::class)
abstract class ReposModule {

    companion object {
        @Provides
        fun provideReposDao(appDatabase: AppDatabase) = appDatabase.reposDao()

    }

    @Binds
    abstract fun bindReposRepository(reposRepositoryImpl: ReposRepositoryImpl): ReposRepository
}