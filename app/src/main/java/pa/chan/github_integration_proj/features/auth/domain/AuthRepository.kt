package pa.chan.github_integration_proj.features.auth.domain

import pa.chan.github_integration_proj.features.auth.domain.model.UserModel

interface AuthRepository {
    suspend fun getUserDetails(username: String, token: String): UserModel
}