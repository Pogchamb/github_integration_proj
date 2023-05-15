package pa.chan.github_integration_proj.features.detail.domain.model

data class RepoDetailModel(
    val id: String,
    val name: String,
    val fullName: String,
    val private: Boolean,
    val htmlUrl: String,
    val starsCount: String,
    val watchersCount: String,
    val language: String,
    val forksCount: String,
)
