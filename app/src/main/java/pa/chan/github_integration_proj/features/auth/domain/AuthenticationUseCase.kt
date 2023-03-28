package pa.chan.github_integration_proj.features.auth.domain

import pa.chan.github_integration_proj.features.auth.domain.model.UserModel
import javax.inject.Inject

class AuthenticationUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(username: String, token: String): UserModel {
        return authRepository.getUserDetails(username, token)
    }
}