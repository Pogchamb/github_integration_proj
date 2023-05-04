package pa.chan.github_integration_proj.features.splash.presentation

sealed interface TransitionAction {
    object GoToLogin : TransitionAction
    object GoToRepos : TransitionAction
}