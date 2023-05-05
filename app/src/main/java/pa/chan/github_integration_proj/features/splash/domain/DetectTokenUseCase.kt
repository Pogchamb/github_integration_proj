package pa.chan.github_integration_proj.features.splash.domain

import pa.chan.github_integration_proj.features.auth.data.PrefDataSource
import javax.inject.Inject

class DetectTokenUseCase @Inject constructor(
    private val prefDataSource: PrefDataSource
) {

    operator fun invoke(): Boolean {
        return prefDataSource.getUserToken().isNullOrBlank()
    }

}