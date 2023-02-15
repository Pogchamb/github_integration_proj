package pa.chan.github_integration_proj.data

import pa.chan.github_integration_proj.data.dto.GitProjReposDto
import pa.chan.github_integration_proj.data.extension.toModel
import pa.chan.github_integration_proj.domain.GitRepository
import pa.chan.github_integration_proj.domain.model.GitUserDetailsModel


class GitRepositoryImpl(
    private val gitRemoteDataSource: GitRemoteDataSource
) : GitRepository {

    override suspend fun getUserDetails(token: String): GitUserDetailsModel {
        return gitRemoteDataSource.getUserDetails(token).toModel()
    }

    override suspend fun getRepos(token: String): List<GitProjReposDto> {
        val url = getUserDetails(token).reposUrl?.substringAfter("users")
        return gitRemoteDataSource.getRepos(url.orEmpty())
    }
}