package com.mbobiosio.apifootball

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mbobiosio.apifootball.databinding.ItemMatchBinding
import com.mbobiosio.apifootball.listener.MatchListener
import com.mbobiosio.apifootball.model.Match

/*
* Created by Mbuodile Obiosio on Apr 21, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class MatchAdapter(
    val listener: MatchListener
) : ListAdapter<Match, MatchAdapter.GamesViewHolder>(ItemCallback()) {

    private class ItemCallback : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.matchStatus == newItem.matchStatus
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        return GamesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {

        getItem(position)?.let {
            holder.bind(it, listener)
        }
    }

    class GamesViewHolder(
        private val binding: ItemMatchBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Match,
            clickListener: MatchListener
        ) = with(itemView) {
            binding.match = item
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }
        companion object {
            fun from(parent: ViewGroup): GamesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMatchBinding.inflate(layoutInflater, parent, false)
                return GamesViewHolder(binding)
            }
        }
    }
}