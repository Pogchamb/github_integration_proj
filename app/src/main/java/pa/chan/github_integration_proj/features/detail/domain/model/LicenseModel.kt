package pa.chan.github_integration_proj.features.detail.domain.model


data class LicenseModel(
    val name: String?,
    val license: LicenseInfoModel?
)

data class LicenseInfoModel(
    val key: String?,
    val name: String?,
)