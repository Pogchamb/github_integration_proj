package pa.chan.github_integration_proj.features.detail.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.crescentflare.simplemarkdownparser.conversion.SimpleMarkdownConverter
import dagger.hilt.android.AndroidEntryPoint
import okio.ByteString.Companion.decodeBase64
import pa.chan.github_integration_proj.features.utils.failedFinishAction
import pa.chan.github_integration_proj.features.utils.startAction
import pa.chan.github_integration_proj.features.utils.succeedFinishAction
import pa.chan.githubintagrationproj.databinding.FragmentDetailBinding
import pa.chan.githubintagrationproj.databinding.ToolbarBinding

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding

    private var _toolbarBinding: ToolbarBinding? = null
    private val toolbarBinding get() = _toolbarBinding

    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        _toolbarBinding = binding?.toolbar
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        _toolbarBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.startAction()
        viewModel.fetchRepoDetail(args.repo)

        _toolbarBinding?.headerRepo?.text = args.repo

        viewModel.detailLiveData.observe(viewLifecycleOwner) {
            binding?.linkText?.text = it.repoDetailModel.htmlUrl
            binding?.licenseText?.text = it.licenseModel.name
            binding?.licenseName?.text = it.licenseModel.license.key
            binding?.starText?.text = it.repoDetailModel.starsCount
            binding?.forksText?.text = it.repoDetailModel.forksCount
            binding?.watchersText?.text = it.repoDetailModel.watchersCount
            val readmeText = it.readmeModel?.content?.decodeBase64().toString()
            binding?.readmeTextView?.text = SimpleMarkdownConverter.toSpannable(readmeText)


            binding?.succeedFinishAction()

            binding?.linkText?.setOnClickListener { _ ->
                val webpage = Uri.parse(it.repoDetailModel.htmlUrl)
                val intent = Intent(Intent.ACTION_VIEW, webpage)
                startActivity(intent)
            }
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            binding?.ErrorImg?.setImageResource(it.errorImg)
            binding?.ErrorMessage?.text = getString(it.errorMessage)

            binding?.failedFinishAction()
        }

        toolbarBinding?.backBtn?.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToReposFragment()
            findNavController().navigate(action)
        }

        viewModel.logoutLiveData.observe(viewLifecycleOwner) {
            if (it) {
                val action = DetailFragmentDirections.actionDetailFragmentToAuthFragment()
                findNavController().navigate(action)
            }
        }

        binding?.errorBtn?.setOnClickListener {
            viewModel.fetchRepoDetail(args.repo)
        }

        toolbarBinding?.logOut?.setOnClickListener {
            viewModel.logout()
        }


    }
}