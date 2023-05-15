package pa.chan.github_integration_proj.features.detail.data

import pa.chan.github_integration_proj.features.auth.data.userExceptions.ConnectionException
import pa.chan.github_integration_proj.features.auth.data.userExceptions.EmptyReposException
import pa.chan.github_integration_proj.features.detail.data.extension.toEntity
import pa.chan.github_integration_proj.features.detail.data.extension.toModel
import pa.chan.github_integration_proj.features.detail.domain.DetailRepository
import pa.chan.github_integration_proj.features.detail.domain.model.RepositoryModel
import pa.chan.github_integration_proj.features.repos.data.ReposLocalDataSource
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailRemoteDataSource: DetailRemoteDataSource,
    private val detailLocalDatasource: DetailLocalDatasource,
    private val reposLocalDataSource: ReposLocalDataSource
) : DetailRepository {

    override suspend fun getRepository(owner: String, repo: String): RepositoryModel {
        return try {
            val readme = detailRemoteDataSource.getReadme(owner, repo)
            val license = detailRemoteDataSource.getLicense(owner, repo)
            val repoDetail = detailRemoteDataSource.getRepoDetail(owner, repo)

            with(detailLocalDatasource) {
                this.insertLicense(license.toEntity())
                this.insertRepoDetail(repoDetail.toEntity())
                this.insertReadme(readme.toEntity())
            }

            RepositoryModel(license.toModel(), readme.toModel(), repoDetail.toModel())
        } catch (e: EmptyReposException) {
            throw e
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