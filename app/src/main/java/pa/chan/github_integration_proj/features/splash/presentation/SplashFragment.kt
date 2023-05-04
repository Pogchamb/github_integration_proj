package pa.chan.github_integration_proj.features.splash.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.githubintagrationproj.R

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private val viewModel: SplashViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectAction()

        viewModel.detectionTokenLiveData.observe(viewLifecycleOwner) { action ->
            when (action) {
                TransitionAction.GoToLogin -> findNavController().navigate(R.id.action_splashFragment_to_authFragment)
                TransitionAction.GoToRepos -> findNavController().navigate(R.id.action_splashFragment_to_reposFragment)
            }
        }


    }
}