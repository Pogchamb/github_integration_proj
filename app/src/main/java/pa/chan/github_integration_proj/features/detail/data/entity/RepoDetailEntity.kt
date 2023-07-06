package pa.chan.github_integration_proj.features.detail.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RepoDetailEntity(
    @PrimaryKey
    var id: String = "",
    var name: String? = "",
    var fullName: String? = "",
    var private: Boolean? = false,
    var htmlUrl: String? = "",
    var starsCount: String? = "",
    var watchersCount: String? = "",
    var forksCount: String? = "",
)
