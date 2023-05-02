package pa.chan.github_integration_proj.features.auth.data.userExceptions

import pa.chan.githubintagrationproj.R

object SomethingException: Throwable(), UserError {
    override val errorMessage: Int
        get() = R.string.somethingError
    override val errorName: Int
        get() = R.string.something
    override val errorImg: Int
        get() = R.drawable.sthg_error
}