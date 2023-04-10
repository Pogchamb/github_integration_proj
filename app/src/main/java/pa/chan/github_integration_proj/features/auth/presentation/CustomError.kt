package pa.chan.github_integration_proj.features.auth.presentation

import androidx.annotation.StringRes
import pa.chan.githubintagrationproj.R


enum class CustomError(@StringRes val message: Int) {
    CUSTOM_HTTP_EXCEPTION(R.string.CUSTOM_HTTP_EXCEPTION),
    CUSTOM_UNKNOWN_HOST_EXCEPTION(R.string.CUSTOM_UNKNOWN_HOST_EXCEPTION)
}
