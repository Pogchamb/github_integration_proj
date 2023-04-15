package pa.chan.github_integration_proj.features.auth.data.userExceptions

import pa.chan.githubintagrationproj.R

object ConnectionException : Throwable(), UserError {
    override val errorMessage: Int
        get() = R.string.Connection_Exception
}