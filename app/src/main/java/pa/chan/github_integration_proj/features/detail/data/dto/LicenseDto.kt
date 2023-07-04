package pa.chan.github_integration_proj.features.detail.data.dto

data class LicenseDto(
    val name: String? = "no license",
    val license: LicenseInfoDto?
)

data class LicenseInfoDto(
    val key: String? = "-/-",
    val name: String? = "no license",
)