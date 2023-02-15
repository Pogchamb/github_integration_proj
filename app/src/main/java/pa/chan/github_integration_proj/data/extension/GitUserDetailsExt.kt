package pa.chan.github_integration_proj.data.extension

import pa.chan.github_integration_proj.data.dto.GitUserDetailsDto
import pa.chan.github_integration_proj.domain.model.GitUserDetailsModel


fun GitUserDetailsDto.toModel(): GitUserDetailsModel = GitUserDetailsModel(
    login = this.login,
    id = this.id,
    avatarUrl = this.avatarUrl,
    reposUrl = this.reposUrl
)