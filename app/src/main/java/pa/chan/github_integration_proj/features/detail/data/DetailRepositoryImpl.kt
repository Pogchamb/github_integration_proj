package pa.chan.github_integration_proj.features.detail.data

import pa.chan.github_integration_proj.features.auth.data.PrefDataSource
import pa.chan.github_integration_proj.features.auth.data.userExceptions.ConnectionException
import pa.chan.github_integration_proj.features.auth.data.userExceptions.EmptyReposException
import pa.chan.github_integration_proj.features.detail.data.entity.RepositoryEntity
import pa.chan.github_integration_proj.features.detail.data.extension.toEntity
import pa.chan.github_integration_proj.features.detail.data.extension.toModel
import pa.chan.github_integration_proj.features.detail.domain.DetailRepository
import pa.chan.github_integration_proj.features.detail.domain.model.RepositoryModel
import retrofit2.HttpException
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailRemoteDataSource: DetailRemoteDataSource,
    private val detailLocalDatasource: DetailLocalDatasource,
    private val prefDataSource: PrefDataSource
) : DetailRepository {

    override suspend fun getRepository(repo: String, id: Long?): RepositoryModel {
        return try {
            val owner = prefDataSource.getUserName()
            val repoDetail = detailRemoteDataSource.getRepoDetail(owner, repo)

            val license = try {
                detailRemoteDataSource.getLicense(owner, repo)
            } catch (e: HttpException) {
                null
            }

            val readme = try {
                detailRemoteDataSource.getReadme(owner, repo)
            } catch (e: HttpException) {
                null
            }

            val reposEntity = RepositoryEntity(
                repoDetail.id, repoDetail.toEntity(), license?.toEntity(), readme?.toEntity()
            )

            if (!detailLocalDatasource.getRepository().contains(reposEntity)) {
                detailLocalDatasource.insertRepository(reposEntity)
            }
            if (detailLocalDatasource.getRepository().isEmpty()) throw EmptyReposException

            RepositoryModel(license?.toModel(), readme?.toModel(), repoDetail.toModel())
        } catch (e: EmptyReposException) {
            throw e
        } catch (e: Exception) {
            if (detailLocalDatasource.getRepository()
                    .contains(detailLocalDatasource.getRepositoryById(id))
            ) {
                getHistory(id)
            } else {
                throw ConnectionException
            }
        }

    }

    override suspend fun getHistory(id: Long?): RepositoryModel {
        val repoEntity = detailLocalDatasource.getRepositoryById(id)
        return RepositoryModel(
            repoEntity.licenseEntity?.toModel(),
            repoEntity.readmeEntity?.toModel(),
            repoEntity.repoDetailEntity?.toModel()
        )
    }

}