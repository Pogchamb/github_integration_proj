package pa.chan.github_integration_proj.features.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pa.chan.github_integration_proj.features.auth.domain.AuthenticationUseCase
import pa.chan.github_integration_proj.features.auth.domain.model.UserModel

class AuthViewModel(
    private val authenticationUseCase: AuthenticationUseCase
) : ViewModel() {

    private val _userLiveData: MutableLiveData<UserModel?> = MutableLiveData()
    val userLiveData: LiveData<UserModel?>
        get() = _userLiveData

    fun fetchUser(token: String) {
        viewModelScope.launch {
            _userLiveData.postValue(authenticationUseCase(token))
        }
    }

}