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
        key = this.license.key,
        name = this.license.name
    )
)

fun ReadmeDto.toModel(): ReadmeModel = ReadmeModel(
    type = this.type,
    encoding = this.encoding,
    size = this.size,
    name = this.name,
    path = this.path,
    content = this.content,
    sha = this.sha,
    url = this.url,
    gitUrl = this.gitUrl,
    htmlUrl = this.htmlUrl,
    downloadUrl = this.downloadUrl,
    links = LinksModel(
        git = this.links.git,
        self = this.links.self,
        html = this.links.html
    )
)

fun RepoDetailDto.toModel(): RepoDetailModel = RepoDetailModel(
    id = this.id,
    name = this.name,
    fullName = this.fullName,
    private = this.private,
    htmlUrl = this.htmlUrl,
    starsCount = this.starsCount,
    watchersCount = this.watchersCount,
    language = this.language,
    forksCount = this.forksCount
)

//
// Convert Dto to Entity

fun ReadmeDto.toEntity(): ReadmeEntity = ReadmeEntity(
    id = null,
    type = this.type,
    encoding = this.encoding,
    size = this.size,
    name = this.name,
    path = this.path,
    content = this.content,
    sha = this.sha,
    url = this.url,
    gitUrl = this.gitUrl,
    htmlUrl = this.htmlUrl,
    downloadUrl = this.downloadUrl,
    links = LinksEntity(
        git = this.links.git,
        self = this.links.self,
        html = this.links.html
    )
)

fun RepoDetailDto.toEntity(): RepoDetailEntity = RepoDetailEntity(
    id = this.id,
    name = this.name,
    fullName = this.fullName,
    private = this.private,
    htmlUrl = this.htmlUrl,
    starsCount = this.starsCount,
    watchersCount = this.watchersCount,
    language = this.language,
    forksCount = this.forksCount
)

fun LicenseDto.toEntity(): LicenseEntity = LicenseEntity(
    id = null,
    name = this.name,
    license = LicenseInfoEntity(
        key = this.license.key,
        name = this.license.name
    )
)

//
//  Convert Entity to Model

fun LicenseEntity.toModel(): LicenseModel = LicenseModel(
    name = this.name,
    license = LicenseInfoModel(
        key = this.license.key,
        name = this.license.name
    )
)

fun ReadmeEntity.toModel(): ReadmeModel = ReadmeModel(
    type = this.type,
    encoding = this.encoding,
    size = this.size,
    name = this.name,
    path = this.path,
    content = this.content,
    sha = this.sha,
    url = this.url,
    gitUrl = this.gitUrl,
    htmlUrl = this.htmlUrl,
    downloadUrl = this.downloadUrl,
    links = LinksModel(
        git = this.links.git,
        self = this.links.self,
        html = this.links.html
    )
)

fun RepoDetailEntity.toModel(): RepoDetailModel = RepoDetailModel(
    id = this.id,
    name = this.name,
    fullName = this.fullName,
    private = this.private,
    htmlUrl = this.htmlUrl,
    starsCount = this.starsCount,
    watchersCount = this.watchersCount,
    language = this.language,
    forksCount = this.forksCount
)
