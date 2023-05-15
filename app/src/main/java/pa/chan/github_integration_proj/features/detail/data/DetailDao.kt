package pa.chan.github_integration_proj.features.detail.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pa.chan.github_integration_proj.features.detail.data.entity.LicenseEntity
import pa.chan.github_integration_proj.features.detail.data.entity.ReadmeEntity
import pa.chan.github_integration_proj.features.detail.data.entity.RepoDetailEntity

@Dao
interface DetailDao {

    @Query("SELECT * FROM licenseentity WHERE repoName=:repoName")
    suspend fun getLicence(repoName: String): List<LicenseEntity>

    @Query("SELECT * FROM readmeentity WHERE repoName=:repoName")
    suspend fun getReadme(repoName: String): List<ReadmeEntity>

    @Query("SELECT * FROM repodetailentity WHERE repoName=:repoName")
    suspend fun getRepoDetail(repoName: String): List<RepoDetailEntity>

    @Insert
    suspend fun insertLicense(licenseEntity: LicenseEntity)

    @Insert
    suspend fun insertReadme(readmeEntity: ReadmeEntity)

    @Insert
    suspend fun insertRepoDetail(repoDetailEntity: RepoDetailEntity)

    @Query("DELETE FROM licenseentity")
    suspend fun deleteLicense()

    @Query("DELETE FROM readmeentity")
    suspend fun deleteReadme()

    @Query("DELETE FROM repodetailentity")
    suspend fun deleteRepoDetail()
}