package pa.chan.github_integration_proj.features.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.github_integration_proj.features.auth.data.userExceptions.ConnectionException
import pa.chan.github_integration_proj.features.auth.data.userExceptions.InvalidCredentialsException
import pa.chan.github_integration_proj.features.auth.data.userExceptions.UserError
import pa.chan.github_integration_proj.features.auth.domain.AuthenticationUseCase
import pa.chan.github_integration_proj.features.auth.domain.model.UserModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authenticationUseCase: AuthenticationUseCase
) : ViewModel() {

    private val _userLiveData: MutableLiveData<UserModel?> = MutableLiveData()
    val userLiveData: LiveData<UserModel?>
        get() = _userLiveData

    private val _errorLiveData: MutableLiveData<UserError> = MutableLiveData()
    val errorLiveData: LiveData<UserError>
        get() = _errorLiveData

    fun fetchUser(token: String) {
        viewModelScope.launch {
            try {
                _userLiveData.postValue(authenticationUseCase(token))
            } catch (e: InvalidCredentialsException) {
                _errorLiveData.postValue(e)
            } catch (e: ConnectionException) {
                _errorLiveData.postValue(e)
            }
        }
    }

}