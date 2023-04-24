package pa.chan.github_integration_proj.features.repos.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ReposEntity(
    @PrimaryKey var id: String = "",
    var nodeId: String = "",
    var name: String? = "",
    var fullName: String? = "",
    var private: Boolean = false,
    var language: String? = "",
)

