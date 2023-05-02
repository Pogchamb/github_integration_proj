package pa.chan.github_integration_proj.features.repos.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import pa.chan.githubintagrationproj.databinding.FragmentReposBinding

@AndroidEntryPoint
class ReposFragment : Fragment() {

    private val viewModel: ReposViewModel by viewModels()

    private var _binding: FragmentReposBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReposBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.fetchRepos()

        binding?.reposRecyclerView?.layoutManager = LinearLayoutManager(requireContext())

        viewModel.reposLiveData.observe(viewLifecycleOwner) {
            binding?.reposRecyclerView?.visibility = View.VISIBLE
            binding?.errorBtn?.visibility = View.INVISIBLE
            binding?.ErrorField?.visibility = View.INVISIBLE
            binding?.reposRecyclerView?.adapter = ReposAdapter(it)
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {

            binding?.reposRecyclerView?.visibility = View.INVISIBLE
            binding?.errorBtn?.visibility = View.VISIBLE
            binding?.ErrorField?.visibility = View.VISIBLE
            binding?.ErrorImg?.setImageResource(it.errorImg)
            binding?.ErrorName?.text = getString(it.errorName)
            binding?.ErrorMessage?.text = getString(it.errorMessage)

        }

        viewModel.logoutLiveData.observe(viewLifecycleOwner) {
            if (it == true) {
                val action = ReposFragmentDirections.actionReposFragmentToAuthFragment()
                findNavController().navigate(action)
            }
        }

        binding?.errorBtn?.setOnClickListener {
            viewModel.fetchRepos()
        }


        binding?.logOut?.setOnClickListener {
            viewModel.logOut()
        }


    }


}
