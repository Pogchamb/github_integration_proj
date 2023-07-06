package pa.chan.github_integration_proj.features.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.github_integration_proj.features.auth.data.userExceptions.ConnectionException
import pa.chan.github_integration_proj.features.auth.data.userExceptions.UserError
import pa.chan.github_integration_proj.features.detail.domain.GetRepoUseCase
import pa.chan.github_integration_proj.features.detail.domain.LogOutUseCase
import pa.chan.github_integration_proj.features.detail.domain.model.RepositoryModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getRepoUseCase: GetRepoUseCase,
    private val logOutUseCase: LogOutUseCase
) : ViewModel() {

    private val _detailLiveData: MutableLiveData<RepositoryModel> = MutableLiveData()
    val detailLiveData: LiveData<RepositoryModel>
        get() = _detailLiveData

    private val _errorLiveData: MutableLiveData<UserError> = MutableLiveData()
    val errorLiveData: LiveData<UserError>
        get() = _errorLiveData

    private val _logoutLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val logoutLiveData: LiveData<Boolean>
        get() = _logoutLiveData

    fun fetchRepoDetail(repo: String) {
        viewModelScope.launch {
            try {
                val repoDetail = getRepoUseCase(repo)
                _detailLiveData.postValue(repoDetail)
            } catch (e: ConnectionException) {
                _errorLiveData.postValue(e)
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            logOutUseCase()
            _logoutLiveData.postValue(true)
        }
    }
}