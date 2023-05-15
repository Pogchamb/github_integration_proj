package pa.chan.github_integration_proj.features.detail.domain

import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {

    suspend operator fun invoke() {
        return detailRepository.logout()
    }

}