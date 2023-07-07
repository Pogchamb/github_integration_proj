package pa.chan.github_integration_proj.features.detail.data.dto

import com.google.gson.annotations.SerializedName

data class RepoDetailDto(
    val id: Long?,
    val name: String?,
    @SerializedName("full_name") val fullName: String?,
    @SerializedName("html_url") val htmlUrl: String?,
    @SerializedName("stargazers_count") val starsCount: String?,
    @SerializedName("watchers_count") val watchersCount: String?,
    @SerializedName("forks_count") val forksCount: String?,
)
