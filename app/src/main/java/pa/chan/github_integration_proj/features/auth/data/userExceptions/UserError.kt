package pa.chan.github_integration_proj.features.auth.data.userExceptions

sealed interface UserError {
    val errorMessage: Int
    val errorName: Int
    val errorImg: Int
}