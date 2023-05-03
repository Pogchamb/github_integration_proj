package pa.chan.github_integration_proj.features.splash.domain

import pa.chan.github_integration_proj.features.auth.data.AuthPrefDataSource
import javax.inject.Inject

class DetectionTokenUseCase @Inject constructor(
    private val prefDataSource: AuthPrefDataSource
) {

    operator fun invoke(): Boolean {
        return prefDataSource.getUserToken().isNullOrBlank()
    }

}