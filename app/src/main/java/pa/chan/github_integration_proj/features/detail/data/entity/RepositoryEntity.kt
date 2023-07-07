package pa.chan.github_integration_proj.features.detail.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RepositoryEntity(
    @PrimaryKey
    var id: Long? = null,
    var repoDetailEntity: RepoDetailEntity?,
    var licenseEntity: LicenseEntity?,
    var readmeEntity: ReadmeEntity?
)
