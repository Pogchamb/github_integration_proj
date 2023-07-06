package pa.chan.github_integration_proj.features.detail.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ReadmeEntity(
    @PrimaryKey
    var id: Int? = 0,
    var content: String? = ""
)



