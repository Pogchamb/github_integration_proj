package pa.chan.github_integration_proj.data

import pa.chan.github_integration_proj.data.dto.GitProjReposDto
import pa.chan.github_integration_proj.data.dto.GitUserDetailsDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface GitApi {
    @GET("/user")
    suspend fun getUserDetails(@Header("Authorization: Bearer OAUTH-TOKEN") accessToken: String): GitUserDetailsDto


    @GET("/{url}")
    suspend fun getRepos(@Path(value = "url") url: String): List<GitProjReposDto>

}