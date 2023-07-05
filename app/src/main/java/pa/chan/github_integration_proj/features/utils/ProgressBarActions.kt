package pa.chan.github_integration_proj.features.utils

import android.view.View
import pa.chan.githubintagrationproj.databinding.FragmentAuthBinding
import pa.chan.githubintagrationproj.databinding.FragmentDetailBinding
import pa.chan.githubintagrationproj.databinding.FragmentReposBinding

class ProgressBarActions {

    fun startAction(fragmentReposBinding: FragmentReposBinding) {
        with(fragmentReposBinding) {
            this.progressBar.visibility= View.VISIBLE
            this.reposRecyclerView.visibility = View.GONE
            this.ErrorField.visibility = View.GONE
            this.errorBtn.visibility = View.GONE
        }

    }

    fun startAction(fragmentDetailBinding: FragmentDetailBinding) {
        with(fragmentDetailBinding) {
            this.progressBar.visibility= View.VISIBLE
            this.licenseLayout.visibility = View.GONE
            this.linkLayout.visibility = View.GONE
            this.statsLayout.visibility = View.GONE
            this.errorLayout.visibility = View.GONE
            this.readmeTextView.visibility = View.GONE
        }
    }

    fun startAction(fragmentAuthBinding: FragmentAuthBinding) {
        with(fragmentAuthBinding) {
            this.authButton.progressBar.visibility = View.VISIBLE
            this.authButton.btnText.visibility = View.GONE
        }

    }

    fun succeedFinishAction(fragmentDetailBinding: FragmentDetailBinding) {
        with(fragmentDetailBinding) {
            this.progressBar.visibility= View.GONE
            this.licenseLayout.visibility = View.VISIBLE
            this.linkLayout.visibility = View.VISIBLE
            this.statsLayout.visibility = View.VISIBLE
            this.errorLayout.visibility = View.GONE
            this.readmeTextView.visibility = View.VISIBLE
        }
    }

    fun succeedFinishAction(fragmentReposBinding: FragmentReposBinding) {
        with(fragmentReposBinding) {
            this.progressBar.visibility= View.GONE
            this.reposRecyclerView.visibility = View.VISIBLE
            this.ErrorField.visibility = View.GONE
            this.errorBtn.visibility = View.GONE
        }
    }

    fun finishAction(fragmentAuthBinding: FragmentAuthBinding) {
        with(fragmentAuthBinding) {
            this.authButton.progressBar.visibility = View.GONE
            this.authButton.btnText.visibility = View.VISIBLE
        }
    }

    fun failedFinishAction(fragmentDetailBinding: FragmentDetailBinding) {
        with(fragmentDetailBinding) {
            this.progressBar.visibility= View.GONE
            this.licenseLayout.visibility = View.GONE
            this.linkLayout.visibility = View.GONE
            this.statsLayout.visibility = View.GONE
            this.errorLayout.visibility = View.VISIBLE
            this.readmeTextView.visibility = View.GONE
        }
    }

    fun failedFinishAction(fragmentReposBinding: FragmentReposBinding) {
        with(fragmentReposBinding) {
            this.progressBar.visibility= View.GONE
            this.reposRecyclerView.visibility = View.GONE
            this.ErrorField.visibility = View.VISIBLE
            this.errorBtn.visibility = View.VISIBLE
        }
    }

}