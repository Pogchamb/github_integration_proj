package pa.chan.github_integration_proj.features.utils

import android.view.View
import pa.chan.githubintagrationproj.databinding.FragmentAuthBinding
import pa.chan.githubintagrationproj.databinding.FragmentDetailBinding
import pa.chan.githubintagrationproj.databinding.FragmentReposBinding


fun FragmentReposBinding.startAction() {
    this.progressBar.visibility = View.VISIBLE
    this.reposRecyclerView.visibility = View.GONE
    this.ErrorField.visibility = View.GONE
    this.errorBtn.visibility = View.GONE
}

fun FragmentReposBinding.succeedFinishAction() {
    this.progressBar.visibility = View.GONE
    this.reposRecyclerView.visibility = View.VISIBLE
    this.ErrorField.visibility = View.GONE
    this.errorBtn.visibility = View.GONE
}

fun FragmentReposBinding.failedFinishAction() {
    this.progressBar.visibility = View.GONE
    this.reposRecyclerView.visibility = View.GONE
    this.ErrorField.visibility = View.VISIBLE
    this.errorBtn.visibility = View.VISIBLE
}

fun FragmentDetailBinding.startAction() {
    this.progressBar.visibility = View.VISIBLE
    this.licenseLayout.visibility = View.GONE
    this.linkLayout.visibility = View.GONE
    this.statsLayout.visibility = View.GONE
    this.errorLayout.visibility = View.GONE
    this.readmeTextView.visibility = View.GONE
    this.scrollReadme.visibility = View.GONE
}

fun FragmentDetailBinding.succeedFinishAction() {
    this.progressBar.visibility = View.GONE
    this.licenseLayout.visibility = View.VISIBLE
    this.linkLayout.visibility = View.VISIBLE
    this.statsLayout.visibility = View.VISIBLE
    this.errorLayout.visibility = View.GONE
    this.readmeTextView.visibility = View.VISIBLE
    this.scrollReadme.visibility = View.VISIBLE
}

fun FragmentDetailBinding.failedFinishAction() {
    this.progressBar.visibility = View.GONE
    this.licenseLayout.visibility = View.GONE
    this.linkLayout.visibility = View.GONE
    this.statsLayout.visibility = View.GONE
    this.errorLayout.visibility = View.VISIBLE
    this.readmeTextView.visibility = View.GONE
    this.scrollReadme.visibility = View.GONE
}

fun FragmentAuthBinding.startAction() {
    this.authButton.progressBar.visibility = View.VISIBLE
    this.authButton.btnText.visibility = View.GONE
}

fun FragmentAuthBinding.finishAction() {
    this.authButton.progressBar.visibility = View.GONE
    this.authButton.btnText.visibility = View.VISIBLE
}




