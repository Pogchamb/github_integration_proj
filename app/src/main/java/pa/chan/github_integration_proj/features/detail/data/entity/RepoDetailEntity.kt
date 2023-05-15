package pa.chan.github_integration_proj.features.detail.data.entity

import androidx.room.PrimaryKey

data class RepoDetailEntity(
    @PrimaryKey
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
