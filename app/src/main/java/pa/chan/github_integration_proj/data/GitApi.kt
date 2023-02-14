package pa.chan.github_integration_proj.data

import pa.chan.github_integration_proj.data.dto.GitProjReposDto
import pa.chan.github_integration_proj.data.dto.GitUserInfoDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface GitApi
{
    @GET("/user")
    fun getUserDetails(@Header("Authorization: Bearer OAUTH-TOKEN") accessToken : String): GitUserInfoDto



    @GET("/{url}")
    fun getRepos(@Path(value = "url") url: String) : List<GitProjReposDto>

}