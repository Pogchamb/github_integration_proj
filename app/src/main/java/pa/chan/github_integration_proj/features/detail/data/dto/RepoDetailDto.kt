package pa.chan.github_integration_proj.features.detail.data.dto

import com.google.gson.annotations.SerializedName

data class RepoDetailDto(
    val id: String,
    val name: String,
    @SerializedName("full_name") val fullName: String,
    val private: Boolean,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("stargazers_count") val starsCount: String,
    @SerializedName("watchers_count") val watchersCount: String,
    val language: String,
    @SerializedName("forks_count") val forksCount: String,
)
