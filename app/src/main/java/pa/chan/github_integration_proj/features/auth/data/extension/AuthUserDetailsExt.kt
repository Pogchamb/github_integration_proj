package pa.chan.github_integration_proj.features.auth.data.extension

import pa.chan.github_integration_proj.features.auth.data.dto.AuthUserDetailsDto
import pa.chan.github_integration_proj.features.auth.domain.model.UserModel


fun AuthUserDetailsDto.toModel(): UserModel = UserModel(
    login = this.login,
    id = this.id,
    avatarUrl = this.avatarUrl,
    reposUrl = this.reposUrl
)