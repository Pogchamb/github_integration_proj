package pa.chan.github_integration_proj.features.detail.domain

import pa.chan.github_integration_proj.features.detail.domain.model.RepositoryModel
import javax.inject.Inject

class GetRepoUseCase @Inject constructor(private val detailRepository: DetailRepository) {

    suspend operator fun invoke(repo: String, id: Long?): RepositoryModel {
        return detailRepository.getRepository(repo, id)
    }

}