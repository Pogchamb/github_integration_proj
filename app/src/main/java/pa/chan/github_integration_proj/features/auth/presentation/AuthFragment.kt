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
import pa.chan.githubintagrationproj.R


class AuthFragment : Fragment() {
    private lateinit var authInputLayout: TextInputLayout
    private lateinit var authEditText: TextInputEditText
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
        authEditText = view.findViewById(R.id.authEditText)
        authInputLayout = view.findViewById(R.id.authInputLayout)



        authButton.setOnClickListener {
            val token: String = authEditText.text.toString()
            viewModel.fetchUser(token)
        }

    }
}