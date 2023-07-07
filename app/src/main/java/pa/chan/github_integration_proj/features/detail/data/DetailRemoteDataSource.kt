package pa.chan.github_integration_proj.features.detail.data

import pa.chan.github_integration_proj.features.detail.data.dto.LicenseDto
import pa.chan.github_integration_proj.features.detail.data.dto.ReadmeDto
import pa.chan.github_integration_proj.features.detail.data.dto.RepoDetailDto
import javax.inject.Inject


class DetailRemoteDataSource @Inject constructor(
    private val detailApi: DetailApi
) {

    suspend fun getReadme(owner: String, repo: String): ReadmeDto {
        return detailApi.getReadme(owner, repo)
    }

    suspend fun getLicense(owner: String, repo: String): LicenseDto {
        return detailApi.getLicense(owner, repo)
    }

    suspend fun getRepoDetail(owner: String, repo: String): RepoDetailDto {
        return detailApi.getRepoDetail(owner, repo)
    }

}