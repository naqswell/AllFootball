package com.naqswell.allfootball.screens.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naqswell.allfootball.data.entities.fixtures.StartingLineups
import com.naqswell.allfootball.databinding.DetailRvItemBinding

class DetailAdapter(
    private var players: ArrayList<StartingLineups>,
) : RecyclerView.Adapter<DetailAdapter.DetailHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = DetailRvItemBinding.inflate(inflater, parent, false)
        return DetailHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DetailHolder, position: Int) {
        holder.onBind(players[position])
        holder.itemView.setOnClickListener { view ->
        }
    }

    override fun getItemCount() = players.size


    inner class DetailHolder(
        private val binding: DetailRvItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var player: StartingLineups

        fun onBind(player: StartingLineups) {
            this.player = player
            with(binding) {
                txtPlayerName.text = player.player
                txtPlayerNumber.text = player.playerNumber
                txtPlayerType.text = player.playerPosition
            }
        }
    }
}