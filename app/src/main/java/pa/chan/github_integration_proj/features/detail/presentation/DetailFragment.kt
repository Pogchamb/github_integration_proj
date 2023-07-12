package pa.chan.github_integration_proj.features.detail.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Base64.decode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.crescentflare.simplemarkdownparser.conversion.SimpleMarkdownConverter
import dagger.hilt.android.AndroidEntryPoint
import io.noties.markwon.Markwon
import okio.ByteString.Companion.decodeBase64
import pa.chan.github_integration_proj.features.utils.failedFinishAction
import pa.chan.github_integration_proj.features.utils.startAction
import pa.chan.github_integration_proj.features.utils.succeedFinishAction
import pa.chan.githubintagrationproj.R
import pa.chan.githubintagrationproj.databinding.FragmentDetailBinding
import pa.chan.githubintagrationproj.databinding.ToolbarBinding
import android.util.Base64

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
        viewModel.fetchRepoDetail(args.repo, args.id)

        _toolbarBinding?.headerRepo?.text = args.repo

        viewModel.detailLiveData.observe(viewLifecycleOwner) {
            binding?.linkText?.text = it.repoDetailModel?.htmlUrl
            binding?.licenseText?.text = it.licenseModel?.name ?: getString(R.string.no_license)
            binding?.licenseName?.text = it.licenseModel?.license?.key ?: "-/-"
            binding?.starText?.text = it.repoDetailModel?.starsCount
            binding?.forksText?.text = it.repoDetailModel?.forksCount
            binding?.watchersText?.text = it.repoDetailModel?.watchersCount
            val readmeText = it.readmeModel?.content ?: getString(R.string.no_readme)
            val text = decode(readmeText, Base64.DEFAULT).toString(Charsets.UTF_8)
            val markwon = Markwon.create(requireContext())
            val node = markwon.parse(text)
            val markdown = markwon.render(node)
            binding?.readmeTextView?.let { it1 -> markwon.setParsedMarkdown(it1, markdown) }


            binding?.succeedFinishAction()

            binding?.linkText?.setOnClickListener { _ ->
                val webpage = Uri.parse(it.repoDetailModel?.htmlUrl)
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
            binding?.startAction()
            viewModel.fetchRepoDetail(args.repo, args.id)
        }

        toolbarBinding?.logOut?.setOnClickListener {
            viewModel.logout()
        }

    }
}