package pa.chan.github_integration_proj.features.detail.data

import pa.chan.github_integration_proj.features.detail.data.entity.LicenseEntity
import pa.chan.github_integration_proj.features.detail.data.entity.ReadmeEntity
import pa.chan.github_integration_proj.features.detail.data.entity.RepoDetailEntity
import javax.inject.Inject

class DetailLocalDatasource @Inject constructor(
    private val detailDao: DetailDao
) {

    suspend fun getLicense(repoName: String): List<LicenseEntity> {
        return detailDao.getLicence(repoName)
    }

    suspend fun getReadme(repoName: String): List<ReadmeEntity> {
        return detailDao.getReadme(repoName)
    }

    suspend fun getRepoDetail(repoName: String): List<RepoDetailEntity> {
        return detailDao.getRepoDetail(repoName)
    }

    suspend fun insertLicense(licenseEntity: LicenseEntity) {
        detailDao.insertLicense(licenseEntity)
    }

    suspend fun insertReadme(readmeEntity: ReadmeEntity) {
        detailDao.insertReadme(readmeEntity)
    }

    suspend fun insertRepoDetail(repoDetailEntity: RepoDetailEntity) {
        detailDao.insertRepoDetail(repoDetailEntity)
    }

    suspend fun deleteLicense() {
        detailDao.deleteLicense()
    }

    suspend fun deleteReadme() {
        detailDao.deleteReadme()
    }

    suspend fun deleteRepoDetail() {
        detailDao.deleteRepoDetail()
    }

}