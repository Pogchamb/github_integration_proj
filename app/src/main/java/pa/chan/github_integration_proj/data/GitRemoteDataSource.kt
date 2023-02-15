package pa.chan.github_integration_proj.data

import pa.chan.github_integration_proj.data.dto.GitProjReposDto
import pa.chan.github_integration_proj.data.dto.GitUserDetailsDto

class GitRemoteDataSource(
    private val gitApi: GitApi
) {

    suspend fun getUserDetails(token: String): GitUserDetailsDto {
        return gitApi.getUserDetails(token)
    }

    suspend fun getRepos(url: String): List<GitProjReposDto> {
        return gitApi.getRepos(url)
    }
}