package pa.chan.github_integration_proj.features.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.githubintagrationproj.R


@AndroidEntryPoint
class AuthFragment : Fragment() {
    private lateinit var tokenInputLayout: TextInputLayout
    private lateinit var tokenEditText: TextInputEditText
    private lateinit var authButton: MaterialButton
    private val viewModel: AuthViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        authButton = view.findViewById(R.id.authButton)
        tokenEditText = view.findViewById(R.id.tokenEditText)
        tokenInputLayout = view.findViewById(R.id.tokenInputLayout)

        viewModel.errorLiveData.observe(viewLifecycleOwner) { customError: CustomError ->
            when (customError) {
                CustomError.CUSTOM_HTTP_EXCEPTION -> {
                    tokenInputLayout.isErrorEnabled = true
                    tokenInputLayout.error = getString(R.string.CUSTOM_HTTP_EXCEPTION)

                }
                CustomError.CUSTOM_UNKNOWN_HOST_EXCEPTION -> {}
            }

            val snackBar =
                Snackbar.make(view, customError.message, Snackbar.LENGTH_INDEFINITE)
                    .setAction(getString(R.string.errorBtn)) {}

            snackBar.show()
        }

        tokenEditText.addTextChangedListener {
            if (tokenInputLayout.isErrorEnabled) {
                tokenInputLayout.isErrorEnabled = false
            }

            if (tokenEditText.text.isNullOrEmpty()) {
                tokenInputLayout.isErrorEnabled = true
                tokenInputLayout.error = getString(R.string.emptyStr)
            }
        }

        authButton.setOnClickListener {
            val token: String = tokenEditText.text.toString()

            when {
                token.isEmpty() -> {
                    tokenInputLayout.isErrorEnabled = true
                    tokenInputLayout.error = getString(R.string.emptyStr)
                }
                else -> {
                    viewModel.fetchUser(token)
                }
            }
        }
    }
}