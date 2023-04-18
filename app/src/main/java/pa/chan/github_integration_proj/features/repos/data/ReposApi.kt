package pa.chan.github_integration_proj.features.repos.data

import pa.chan.github_integration_proj.features.repos.data.dto.ReposDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ReposApi {
    @GET("/{reposPath}")
    suspend fun getUserRepos(@Path(value = "reposPath") reposPath: String): List<ReposDTO>
}