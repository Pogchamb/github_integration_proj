package pa.chan.github_integration_proj.features.auth.data

import pa.chan.github_integration_proj.features.auth.data.dto.AuthUserDetailsDto

class AuthRemoteDataSource(
    private val authApi: AuthApi
) {
    suspend fun getUserDetails(token: String): AuthUserDetailsDto {
        return authApi.getUserDetails(token)
    }
}