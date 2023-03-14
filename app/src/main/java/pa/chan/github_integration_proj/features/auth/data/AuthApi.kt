package pa.chan.github_integration_proj.features.auth.data

import pa.chan.github_integration_proj.features.auth.data.dto.AuthUserDetailsDto
import retrofit2.http.GET
import retrofit2.http.Header


interface AuthApi {
    @GET("/user")
    suspend fun getUserDetails(@Header("Authorization: Bearer OAUTH-TOKEN") accessToken: String): AuthUserDetailsDto
}


