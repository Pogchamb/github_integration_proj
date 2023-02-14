package pa.chan.github_integration_proj.domain

import pa.chan.github_integration_proj.data.dto.GitProjReposDto
import pa.chan.github_integration_proj.data.dto.GitUserInfoDto

interface GitRepository {
    fun getUserDetails(token: String): GitUserInfoDto
    fun getRepos(token: String): List<GitProjReposDto>
}