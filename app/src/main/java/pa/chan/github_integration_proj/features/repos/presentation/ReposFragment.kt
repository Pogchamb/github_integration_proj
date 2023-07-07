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
import pa.chan.github_integration_proj.features.utils.failedFinishAction
import pa.chan.github_integration_proj.features.utils.startAction
import pa.chan.github_integration_proj.features.utils.succeedFinishAction

import pa.chan.githubintagrationproj.databinding.FragmentReposBinding
import pa.chan.githubintagrationproj.databinding.ToolbarBinding

@AndroidEntryPoint
class ReposFragment : Fragment() {

    private val viewModel: ReposViewModel by viewModels()

    private var _binding: FragmentReposBinding? = null
    private val binding get() = _binding

    private var _toolbarBinding: ToolbarBinding? = null
    private val toolbarBinding get() = _toolbarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReposBinding.inflate(inflater, container, false)
        _toolbarBinding = binding?.toolbar
        val view = binding?.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _toolbarBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.startAction()
        toolbarBinding?.backBtn?.visibility = View.GONE

        binding?.reposRecyclerView?.layoutManager = LinearLayoutManager(requireContext())

        viewModel.reposLiveData.observe(viewLifecycleOwner) {
            binding?.succeedFinishAction()
            binding?.reposRecyclerView?.adapter = ReposAdapter(it).apply {
                this.onRepoClick = { repo, id ->
                    findNavController().navigate(
                        ReposFragmentDirections.actionReposFragmentToDetailFragment(
                            repo,
                            id
                        )
                    )
                }
            }
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            binding?.ErrorImg?.setImageResource(it.errorImg)
            binding?.ErrorName?.text = getString(it.errorName)
            binding?.ErrorMessage?.text = getString(it.errorMessage)
            binding?.failedFinishAction()

        }

        viewModel.logoutLiveData.observe(viewLifecycleOwner) {
            if (it == true) {
                val action = ReposFragmentDirections.actionReposFragmentToAuthFragment()
                findNavController().navigate(action)
            }
        }

        binding?.errorBtn?.setOnClickListener {
            binding?.startAction()
            viewModel.fetchRepos()
        }


        toolbarBinding?.logOut?.setOnClickListener {
            viewModel.logOut()
        }


        viewModel.fetchRepos()

    }

}
