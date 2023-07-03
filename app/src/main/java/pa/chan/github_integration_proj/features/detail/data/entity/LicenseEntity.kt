package pa.chan.github_integration_proj.features.detail.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class LicenseEntity(
    @PrimaryKey
    var id: Int = 0,
    var name: String? = "",
    var license: LicenseInfoEntity? = LicenseInfoEntity("","")
)

data class LicenseInfoEntity(
    var key: String?,
    var name: String?,
)

