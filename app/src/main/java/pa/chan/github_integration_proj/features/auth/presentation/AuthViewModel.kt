package pa.chan.github_integration_proj.features.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pa.chan.github_integration_proj.features.auth.domain.AuthenticationUseCase
import pa.chan.github_integration_proj.features.auth.domain.model.UserModel
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authenticationUseCase: AuthenticationUseCase
) : ViewModel() {

    private val _userLiveData: MutableLiveData<UserModel?> = MutableLiveData()
    val userLiveData: LiveData<UserModel?>
        get() = _userLiveData

    private val _errorLiveData: MutableLiveData<CustomError> = MutableLiveData()
    val errorLiveData: LiveData<CustomError>
        get() = _errorLiveData

    fun fetchUser(token: String) {
        viewModelScope.launch {
            try {
                _userLiveData.postValue(authenticationUseCase(token))
            } catch (e: HttpException) {
                when(e.code()) {
                    401 -> _errorLiveData.postValue(CustomError.CUSTOM_HTTP_EXCEPTION)
                }
            } catch (e: UnknownHostException) {
                _errorLiveData.postValue(CustomError.CUSTOM_UNKNOWN_HOST_EXCEPTION)
            }
        }
    }

}