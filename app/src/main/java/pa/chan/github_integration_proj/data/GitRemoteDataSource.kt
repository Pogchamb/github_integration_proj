package pa.chan.github_integration_proj.data

import pa.chan.github_integration_proj.data.dto.GitProjReposDto
import pa.chan.github_integration_proj.data.dto.GitUserInfoDto

class GitRemoteDataSource(
    private val gitApi: GitApi
) {

    fun getUserDetails(token: String): GitUserInfoDto {
        return gitApi.getUserDetails(token)
    }

    fun getRepos(url: String) : List<GitProjReposDto>{
        return gitApi.getRepos(url)
    }
}