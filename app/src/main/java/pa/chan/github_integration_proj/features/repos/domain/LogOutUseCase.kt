package pa.chan.github_integration_proj.features.repos.domain

import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val reposRepository: ReposRepository
) {

    suspend operator fun invoke() {
        return reposRepository.logOut()
    }

}