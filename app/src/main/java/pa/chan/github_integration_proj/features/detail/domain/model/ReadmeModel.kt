package pa.chan.github_integration_proj.features.detail.domain.model

data class ReadmeModel(
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
    val links: LinksModel
)

data class LinksModel(
    val git: String,
    val self: String,
    val html: String
)