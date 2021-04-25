package com.mbobiosio.apifootball

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mbobiosio.apifootball.model.Match
import com.mbobiosio.apifootball.databinding.ItemGameBinding

class GamesAdapter(
    val listener: (Match) -> Unit
) : ListAdapter<Match, GamesAdapter.GamesViewHolder>(ItemCallback()) {

    private class ItemCallback : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.matchStatus == newItem.matchStatus
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val binding =
            ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {

        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class GamesViewHolder(
        private val binding: ItemGameBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Match) = with(itemView) {
            binding.data = item
            binding.executePendingBindings()

            setOnClickListener {
                listener.invoke(item)
            }
        }
    }
}