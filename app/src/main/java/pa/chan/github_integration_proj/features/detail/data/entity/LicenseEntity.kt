package pa.chan.github_integration_proj.features.detail.data.entity

import androidx.room.PrimaryKey

data class LicenseEntity(
    @PrimaryKey
    val id: Int?,
    val name: String,
    val license: LicenseInfoEntity
)

data class LicenseInfoEntity(
    val key: String,
    val name: String,
)

