package pa.chan.github_integration_proj.features.auth.data

import okhttp3.Credentials
import pa.chan.github_integration_proj.features.auth.data.dto.AuthUserDetailsDto
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApi: AuthApi
) {
    suspend fun getUserDetails(username:String, token: String): AuthUserDetailsDto {
        val credentials = Credentials.basic(username, token)
        return authApi.getUserDetails(credentials)
    }
}