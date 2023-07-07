package pa.chan.github_integration_proj.features.repos.data.dto

import com.google.gson.annotations.SerializedName

data class ReposDTO(
    val id: Long,
    @SerializedName("node_id") val nodeId: String?,
    val name: String?,
    @SerializedName("full_name") val fullName: String?,
    val private: Boolean?,
    val language: String?,
)