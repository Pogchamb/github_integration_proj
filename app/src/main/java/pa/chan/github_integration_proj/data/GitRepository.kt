package pa.chan.github_integration_proj.data

import pa.chan.github_integration_proj.data.dto.GitProjReposDto
import pa.chan.github_integration_proj.data.dto.GitUserInfoDto
import pa.chan.github_integration_proj.domain.GitRepository


class GitRepositoryImpl(
    private val gitRemoteDataSource: GitRemoteDataSource
): GitRepository {

    override fun getUserDetails(token: String): GitUserInfoDto {

        return gitRemoteDataSource.getUserDetails(token)
    }

    override fun getRepos(token: String): List<GitProjReposDto> {
        val url = getUserDetails(token).reposUrl?.substringAfter("users")
        return gitRemoteDataSource.getRepos(url.orEmpty())
    }
}