package pa.chan.github_integration_proj.features.detail.data

import pa.chan.github_integration_proj.features.detail.data.dto.LicenseDto
import pa.chan.github_integration_proj.features.detail.data.dto.ReadmeDto
import pa.chan.github_integration_proj.features.detail.data.dto.RepoDetailDto
import retrofit2.http.GET
import retrofit2.http.Path


interface DetailApi {

    @GET(value = "/repos/{owner}/{repo}/contents/README.md")
    suspend fun getReadme(
        @Path(value = "owner") owner: String,
        @Path(value = "repo") repo: String
    ): ReadmeDto

    @GET(value = "/repos/{owner}/{repo}/license")
    suspend fun getLicense(
        @Path(value = "owner") owner: String,
        @Path(value = "repo") repo: String
    ): LicenseDto

    @GET(value = "/repos/{owner}/{repo}")
    suspend fun getRepoDetail(
        @Path(value = "owner") owner: String,
        @Path(value = "repo") repo: String
    ): RepoDetailDto
}