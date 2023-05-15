package pa.chan.github_integration_proj.features.detail.domain

import pa.chan.github_integration_proj.features.detail.domain.model.RepositoryModel
import javax.inject.Inject

class GetRepoUseCase @Inject constructor(private val detailRepository: DetailRepository) {

    suspend operator fun invoke(owner: String, repo: String): RepositoryModel {
        return detailRepository.getRepository(owner, repo)
    }
}