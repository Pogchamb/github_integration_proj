package pa.chan.github_integration_proj.features.detail.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pa.chan.github_integration_proj.features.core.AppDatabase
import pa.chan.github_integration_proj.features.detail.data.DetailApi
import pa.chan.github_integration_proj.features.detail.data.DetailRepositoryImpl
import pa.chan.github_integration_proj.features.detail.domain.DetailRepository
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoDetailModule {

    companion object {

        @Provides
        @Singleton
        fun provideDetailApi(retrofit: Retrofit): DetailApi = retrofit.create(DetailApi::class.java)

        @Provides
        @Singleton
        fun provideDetailDao(appDatabase: AppDatabase) = appDatabase.detailDao()

    }

    @Binds
    abstract fun bindsDetailRepository(detailRepositoryImpl: DetailRepositoryImpl): DetailRepository
}