package pa.chan.github_integration_proj.features.repos.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.github_integration_proj.features.auth.data.userExceptions.ConnectionException
import pa.chan.github_integration_proj.features.auth.data.userExceptions.EmptyReposException
import pa.chan.github_integration_proj.features.auth.data.userExceptions.UserError
import pa.chan.github_integration_proj.features.repos.domain.GetReposUseCase
import pa.chan.github_integration_proj.features.repos.domain.LogOutUseCase
import pa.chan.github_integration_proj.features.repos.domain.model.ReposModel
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase,
    private val logOutUseCase: LogOutUseCase
) : ViewModel() {

    private val _reposLiveData: MutableLiveData<List<ReposModel>> = MutableLiveData()
    val reposLiveData: LiveData<List<ReposModel>>
        get() = _reposLiveData

    private val _errorLiveData: MutableLiveData<UserError> = MutableLiveData()
    val errorLiveData: LiveData<UserError>
        get() = _errorLiveData

    private val _logoutLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val logoutLiveData: LiveData<Boolean>
        get() = _logoutLiveData

    fun fetchRepos() {

        viewModelScope.launch {
            try {
                val repos = getReposUseCase()
                if (repos.isEmpty()) {
                    _errorLiveData.postValue(EmptyReposException)
                } else {
                    _reposLiveData.postValue(repos)
                }
            } catch (e: EmptyReposException) {
                _errorLiveData.postValue(e)
            } catch (e: ConnectionException) {
                _errorLiveData.postValue(e)
            }
        }

    }

    fun logOut() {
        viewModelScope.launch {
            logOutUseCase()
            _logoutLiveData.postValue(true)
        }
    }

}