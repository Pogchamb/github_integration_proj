package pa.chan.github_integration_proj.features.detail.data.entity

import androidx.room.PrimaryKey

data class ReadmeEntity(
    @PrimaryKey
    val id: Int?,
    val type: String,
    val encoding: String,
    val size: Int,
    val name: String,
    val path: String,
    val content: String,
    val sha: String,
    val url: String,
    val gitUrl: String,
    val htmlUrl: String,
    val downloadUrl: String,
    val links: LinksEntity
)

data class LinksEntity(
    val git: String,
    val self: String,
    val html: String
)

