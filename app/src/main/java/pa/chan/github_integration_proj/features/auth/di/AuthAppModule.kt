package pa.chan.github_integration_proj.features.auth.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pa.chan.github_integration_proj.features.auth.data.AuthApi
import pa.chan.github_integration_proj.features.auth.data.AuthRepositoryImpl
import pa.chan.github_integration_proj.features.auth.domain.AuthRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthAppModule {
    companion object {
        @Provides
        @Singleton
        fun provideAuthApi(retrofit: Retrofit): AuthApi =
            retrofit.create(AuthApi::class.java)

        @Provides
        @Singleton
        fun provideMasterKeyAlias(@ApplicationContext context: Context): MasterKey {
            return MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
        }

        @Provides
        @Singleton
        fun provideEncryptedSharedPreferences(
            @ApplicationContext context: Context,
            key: MasterKey
        ): SharedPreferences {
            return EncryptedSharedPreferences.create(
                context,
                "UserToken",
                key,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        }

    }

    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}