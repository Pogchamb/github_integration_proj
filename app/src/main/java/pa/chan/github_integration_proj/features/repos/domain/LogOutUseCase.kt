package pa.chan.github_integration_proj.features.repos.domain

import pa.chan.github_integration_proj.features.auth.domain.AuthRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke() {
        return authRepository.logout()
    }
}