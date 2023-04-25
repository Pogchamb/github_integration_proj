package pa.chan.github_integration_proj.features.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pa.chan.github_integration_proj.features.core.AppDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    companion object {
        private const val url = "https://api.github.com"

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "git-Database").build()
        }
    }

}