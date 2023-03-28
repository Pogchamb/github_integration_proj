package pa.chan.github_integration_proj.features.auth.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.githubintagrationproj.R


@AndroidEntryPoint
class AuthFragment : Fragment() {
    private lateinit var tokenInputLayout: TextInputLayout
    private lateinit var tokenEditText: TextInputEditText
    private lateinit var usernameInputLayout: TextInputLayout
    private lateinit var usernameEditText: TextInputEditText
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
        usernameEditText = view.findViewById(R.id.usernameEditText)
        usernameInputLayout = view.findViewById(R.id.usernameInputLayout)
        tokenEditText = view.findViewById(R.id.tokenEditText)
        tokenInputLayout = view.findViewById(R.id.tokenInputLayout)



        authButton.setOnClickListener {
            val token: String = tokenEditText.text.toString()
            val username: String = usernameEditText.text.toString()
            viewModel.fetchUser(username, token)
        }

    }
}