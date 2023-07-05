package pa.chan.github_integration_proj.features.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.github_integration_proj.features.auth.data.userExceptions.InvalidCredentialsException
import pa.chan.github_integration_proj.features.utils.ProgressBarActions
import pa.chan.githubintagrationproj.R
import pa.chan.githubintagrationproj.databinding.FragmentAuthBinding


@AndroidEntryPoint
class AuthFragment : Fragment() {
    private val viewModel: AuthViewModel by viewModels()

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val authBtn = binding?.authButton
        val tokenEditText = binding?.tokenEditText
        val tokenInputLayout = binding?.tokenInputLayout

        viewModel.errorLiveData.observe(viewLifecycleOwner) {

            if (it is InvalidCredentialsException) {
                tokenInputLayout?.isErrorEnabled = true
                tokenInputLayout?.error = getString(it.errorMessage)
            }

            val snackBar =
                Snackbar.make(view, getString(it.errorMessage), Snackbar.LENGTH_SHORT)

            snackBar.show()
        }

        viewModel.userLiveData.observe(viewLifecycleOwner) {
            val action = AuthFragmentDirections.actionAuthFragmentToReposFragment()
            binding?.let { bind -> ProgressBarActions().startAction(bind) }
            findNavController().navigate(action)
        }

        tokenEditText?.addTextChangedListener {
            if (tokenInputLayout?.isErrorEnabled == true) {
                tokenInputLayout.isErrorEnabled = false
            }

            if (tokenEditText.text.isNullOrEmpty()) {
                tokenInputLayout?.isErrorEnabled = true
                tokenInputLayout?.error = getString(R.string.emptyStr)
            }
        }

        authBtn?.progressBtn?.setOnClickListener { _ ->
            val token: String = tokenEditText?.text.toString()

            binding?.let { ProgressBarActions().finishAction(it) }

            when {
                token.isEmpty() -> {
                    tokenInputLayout?.isErrorEnabled = true
                    tokenInputLayout?.error = getString(R.string.emptyStr)
                }
                else -> {
                    viewModel.fetchUser(token)
                }
            }
        }


    }
}