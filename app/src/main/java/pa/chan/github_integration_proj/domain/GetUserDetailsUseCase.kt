package pa.chan.github_integration_proj.domain

import pa.chan.github_integration_proj.domain.model.GitUserDetailsModel

class GetUserDetailsUseCase(
    private val gitRepository: GitRepository
) {
    suspend operator fun invoke(token: String): GitUserDetailsModel {
        return gitRepository.getUserDetails(token)
    }
}