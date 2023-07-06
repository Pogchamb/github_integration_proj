package pa.chan.github_integration_proj.features.repos.presentation

import androidx.recyclerview.widget.RecyclerView
import pa.chan.github_integration_proj.features.repos.domain.model.ReposModel
import pa.chan.githubintagrationproj.databinding.RepositoryItemBinding

class ReposViewHolder(
    private val repositoryItemBinding: RepositoryItemBinding,
    private val onRepoClick: (String) -> Unit
) : RecyclerView.ViewHolder(repositoryItemBinding.root) {


    fun bind(reposModel: ReposModel) {
        repositoryItemBinding.repoName.text = reposModel.name
        repositoryItemBinding.language.text = reposModel.language

        reposModel.name.let { repo ->
            repositoryItemBinding.root
                .setOnClickListener {
                    onRepoClick.invoke(repo.toString())
                }
        }
    }
}