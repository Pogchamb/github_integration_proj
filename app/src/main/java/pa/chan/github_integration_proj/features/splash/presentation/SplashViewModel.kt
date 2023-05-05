package pa.chan.github_integration_proj.features.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pa.chan.github_integration_proj.features.splash.domain.DetectTokenUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val detectTokenUseCase: DetectTokenUseCase
) : ViewModel()  {

    private val _detectionTokenLiveData: MutableLiveData<TransitionAction> = MutableLiveData()
    val detectionTokenLiveData: LiveData<TransitionAction>
        get() = _detectionTokenLiveData


    fun selectAction() {
        if (detectTokenUseCase()) {
            _detectionTokenLiveData.postValue(TransitionAction.GoToLogin)
        } else {
            _detectionTokenLiveData.postValue(TransitionAction.GoToRepos)
        }
    }

}