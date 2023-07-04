package pa.chan.github_integration_proj.features.detail.data.extension

import pa.chan.github_integration_proj.features.detail.data.dto.LicenseDto
import pa.chan.github_integration_proj.features.detail.data.dto.ReadmeDto
import pa.chan.github_integration_proj.features.detail.data.dto.RepoDetailDto
import pa.chan.github_integration_proj.features.detail.data.entity.*
import pa.chan.github_integration_proj.features.detail.domain.model.*

//
// Convert Dto to Model

fun LicenseDto.toModel(): LicenseModel = LicenseModel(
    name = this.name,
    license = LicenseInfoModel(
        key = this.license?.key,
        name = this.license?.name
    )
)

fun ReadmeDto.toModel(): ReadmeModel = ReadmeModel(
    content = this.content,
)

fun RepoDetailDto.toModel(): RepoDetailModel = RepoDetailModel(
    name = this.name,
    fullName = this.fullName,
    htmlUrl = this.htmlUrl,
    starsCount = this.starsCount,
    watchersCount = this.watchersCount,
    forksCount = this.forksCount
)

//
// Convert Dto to Entity

fun ReadmeDto.toEntity(): ReadmeEntity = ReadmeEntity(
    id = 1,
    content = this.content,
)

fun RepoDetailDto.toEntity(): RepoDetailEntity = RepoDetailEntity(
    id = this.id,
    name = this.name,
    fullName = this.fullName,
    private = this.private,
    htmlUrl = this.htmlUrl,
    starsCount = this.starsCount,
    watchersCount = this.watchersCount,
    forksCount = this.forksCount
)

fun LicenseDto.toEntity(): LicenseEntity = LicenseEntity(
    id = 1,
    name = this.name,
    license = LicenseInfoEntity(
        key = this.license?.key,
        name = this.license?.name
    )
)

//
//  Convert Entity to Model

fun LicenseEntity.toModel(): LicenseModel = LicenseModel(
    name = this.name.toString(),
    license = LicenseInfoModel(
        key = this.license?.key.toString(),
        name = this.license?.name.toString()
    )
)

fun ReadmeEntity.toModel(): ReadmeModel = ReadmeModel(
    content = this.content.toString(),
)

fun RepoDetailEntity.toModel(): RepoDetailModel = RepoDetailModel(
    name = this.name.toString(),
    fullName = this.fullName.toString(),
    htmlUrl = this.htmlUrl.toString(),
    starsCount = this.starsCount.toString(),
    watchersCount = this.watchersCount.toString(),
    forksCount = this.forksCount.toString()
)
