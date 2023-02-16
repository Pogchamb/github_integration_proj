package pa.chan.github_integration_proj.features.auth.domain

import pa.chan.github_integration_proj.features.auth.domain.model.UserModel

class AuthenticationUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(token: String): UserModel {
        return authRepository.getUserDetails(token)
    }
}