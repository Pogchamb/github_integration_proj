package pa.chan.github_integration_proj.features.detail.data

import pa.chan.github_integration_proj.features.auth.data.PrefDataSource
import pa.chan.github_integration_proj.features.auth.data.userExceptions.ConnectionException
import pa.chan.github_integration_proj.features.detail.data.dto.LicenseDto
import pa.chan.github_integration_proj.features.detail.data.dto.LicenseInfoDto
import pa.chan.github_integration_proj.features.detail.data.dto.ReadmeDto
import pa.chan.github_integration_proj.features.detail.data.extension.toEntity
import pa.chan.github_integration_proj.features.detail.data.extension.toModel
import pa.chan.github_integration_proj.features.detail.domain.DetailRepository
import pa.chan.github_integration_proj.features.detail.domain.model.RepositoryModel
import pa.chan.github_integration_proj.features.repos.data.ReposLocalDataSource
import retrofit2.HttpException
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailRemoteDataSource: DetailRemoteDataSource,
    private val detailLocalDatasource: DetailLocalDatasource,
    private val reposLocalDataSource: ReposLocalDataSource,
    private val prefDataSource: PrefDataSource
) : DetailRepository {

    override suspend fun getRepository(repo: String): RepositoryModel {
        return try {
            val owner = prefDataSource.getUserName()
            val repoDetail = detailRemoteDataSource.getRepoDetail(owner, repo)

            val license = try {
                detailRemoteDataSource.getLicense(owner, repo)
            } catch (e: HttpException) {
                LicenseDto(license = LicenseInfoDto())
            }

            val readme = try {
                detailRemoteDataSource.getReadme(owner, repo)
            } catch (e: HttpException) {
                ReadmeDto()
            }

//            with(detailLocalDatasource) {
//                this.insertRepoDetail(repoDetail.toEntity())
//                this.insertLicense(license.toEntity())
//                this.insertReadme(readme.toEntity())
//            }

            RepositoryModel(license.toModel(), readme.toModel(), repoDetail.toModel())
        } catch (e: Exception) {
            throw ConnectionException
        }


    }

    override suspend fun logout() {
        with(detailLocalDatasource) {
            this.deleteRepoDetail()
            this.deleteLicense()
            this.deleteReadme()
        }
        reposLocalDataSource.clearAll()
    }
}