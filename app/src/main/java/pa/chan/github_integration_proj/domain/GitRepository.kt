package pa.chan.github_integration_proj.domain

import pa.chan.github_integration_proj.data.dto.GitProjReposDto
import pa.chan.github_integration_proj.domain.model.GitUserDetailsModel

interface GitRepository {
    suspend fun getUserDetails(token: String): GitUserDetailsModel
    suspend fun getRepos(token: String): List<GitProjReposDto>
}