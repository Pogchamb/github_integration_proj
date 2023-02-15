package pa.chan.github_integration_proj.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pa.chan.github_integration_proj.domain.GetUserDetailsUseCase
import pa.chan.github_integration_proj.domain.model.GitUserDetailsModel

class UserDetailsViewModel(
    private val getUserDetailsUseCase: GetUserDetailsUseCase
) : ViewModel() {

    private val _userDetailsLiveData: MutableLiveData<GitUserDetailsModel?> = MutableLiveData()
    val userDetailsLiveData: LiveData<GitUserDetailsModel?>
        get() = _userDetailsLiveData

    fun fetchUserDetails(token: String) {

        viewModelScope.launch {
            _userDetailsLiveData.postValue(getUserDetailsUseCase(token))
        }

    }

}