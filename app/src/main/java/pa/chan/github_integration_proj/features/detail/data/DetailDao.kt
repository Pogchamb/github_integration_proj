package pa.chan.github_integration_proj.features.detail.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pa.chan.github_integration_proj.features.detail.data.entity.LicenseEntity
import pa.chan.github_integration_proj.features.detail.data.entity.ReadmeEntity
import pa.chan.github_integration_proj.features.detail.data.entity.RepoDetailEntity

@Dao
interface DetailDao {

    @Query("SELECT * FROM licenseEntity")
    suspend fun getLicence(): List<LicenseEntity>

    @Query("SELECT * FROM readmeEntity")
    suspend fun getReadme(): List<ReadmeEntity>

    @Query("SELECT * FROM repodetailEntity")
    suspend fun getRepoDetail(): List<RepoDetailEntity>

    @Insert
    suspend fun insertLicense(licenseEntity: LicenseEntity)

    @Insert
    suspend fun insertReadme(readmeEntity: ReadmeEntity)

    @Insert
    suspend fun insertRepoDetail(repoDetailEntity: RepoDetailEntity)

    @Query("DELETE FROM licenseEntity")
    suspend fun deleteLicense()

    @Query("DELETE FROM readmeEntity")
    suspend fun deleteReadme()

    @Query("DELETE FROM repodetailEntity")
    suspend fun deleteRepoDetail()
}