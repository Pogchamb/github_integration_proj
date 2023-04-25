package pa.chan.github_integration_proj.features.repos.domain

import pa.chan.github_integration_proj.features.repos.domain.model.ReposModel
import javax.inject.Inject

class GetReposUseCase @Inject constructor(private val reposRepository: ReposRepository) {

    suspend operator fun invoke(userName: String): List<ReposModel> {
        return reposRepository.getUserRepos(userName)
    }
}