package pa.chan.github_integration_proj.features.repos.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pa.chan.github_integration_proj.features.repos.domain.model.ReposModel
import pa.chan.githubintagrationproj.databinding.RepositoryItemBinding

class ReposAdapter(private val reposModelList: List<ReposModel>) :
    RecyclerView.Adapter<ReposViewHolder>() {
    var onRepoClick: ((String, Long) -> Unit) = { repo, id -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val itemBinding =
            RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReposViewHolder(itemBinding, onRepoClick)
    }

    override fun getItemCount(): Int = reposModelList.size

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        val reposItem = reposModelList[position]
        holder.bind(reposItem)
    }
}