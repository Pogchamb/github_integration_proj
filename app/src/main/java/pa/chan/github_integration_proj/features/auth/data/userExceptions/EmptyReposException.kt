package pa.chan.github_integration_proj.features.auth.data.userExceptions

import pa.chan.githubintagrationproj.R

object EmptyReposException:Throwable(), UserError {
    override val errorMessage: Int
        get() = R.string.EmptyRepos
    override val errorName: Int
        get() = R.string.empty
    override val errorImg: Int
        get() = R.drawable.empty_svg
}