package pa.chan.github_integration_proj.features.repos.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pa.chan.github_integration_proj.features.core.AppDatabase
import pa.chan.github_integration_proj.features.repos.data.ReposApi
import pa.chan.github_integration_proj.features.repos.data.ReposRepositoryImpl
import pa.chan.github_integration_proj.features.repos.domain.ReposRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ReposModule {

    companion object {
        @Provides
        @Singleton
        fun provideReposApi(retrofit: Retrofit): ReposApi =
            retrofit.create(ReposApi::class.java)


        @Provides
        @Singleton
        fun provideReposDao(appDatabase: AppDatabase) = appDatabase.reposDao()

    }

    @Binds
    abstract fun bindReposRepository(reposRepositoryImpl: ReposRepositoryImpl): ReposRepository
}