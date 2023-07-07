package pa.chan.github_integration_proj.features.detail.data.entity

data class LicenseEntity(
    val name: String?,
    val license: LicenseInfoEntity?
)

data class LicenseInfoEntity(
    val key: String?,
    val name: String?,
)

