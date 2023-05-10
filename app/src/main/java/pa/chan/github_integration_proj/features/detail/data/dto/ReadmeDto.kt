package pa.chan.github_integration_proj.features.detail.data.dto

import com.google.gson.annotations.SerializedName

data class ReadmeDto(
    val id: String,
    val type: String,
    val encoding: String,
    val size: Int,
    val name: String,
    val path: String,
    val content: String,
    val sha: String,
    val url: String,
    @SerializedName("git_url") val gitUrl: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("download_url") val downloadUrl: String,
    @SerializedName("_links") val links: LinksDto

)


data class LinksDto(
    val git: String,
    val self: String,
    val html: String
)
