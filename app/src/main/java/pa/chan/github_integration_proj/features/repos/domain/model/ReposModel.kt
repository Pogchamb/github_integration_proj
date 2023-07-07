package pa.chan.github_integration_proj.features.repos.domain.model

data class ReposModel(
    val id: Long,
    val nodeId: String?,
    val name: String?,
    val fullName: String?,
    val private: Boolean?,
    val language: String?,
)

