package pa.chan.github_integration_proj.features.repos.data.extension

import pa.chan.github_integration_proj.features.repos.data.dto.ReposDTO
import pa.chan.github_integration_proj.features.repos.data.entity.ReposEntity
import pa.chan.github_integration_proj.features.repos.domain.model.ReposModel

fun ReposDTO.toModel(): ReposModel = ReposModel(
    id = this.id,
    nodeId = this.nodeId,
    name = this.name,
    fullName = this.fullName,
    private = this.private,
    language = this.language
)

fun ReposDTO.toEntity(): ReposEntity = ReposEntity(
    id = this.id,
    nodeId = this.nodeId,
    name = this.name,
    fullName = this.fullName,
    private = this.private,
    language = this.language
)

fun ReposEntity.toModel(): ReposModel = ReposModel(
    id = this.id,
    nodeId = this.nodeId,
    name = this.name,
    fullName = this.fullName,
    private = this.private,
    language = this.language
)