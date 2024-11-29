package com.example.rockneco2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rockneco2.R
import com.example.rockneco2.model.Reward

class RewardAdapter(private val rewards: List<Reward>) :
    RecyclerView.Adapter<RewardAdapter.RewardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reward, parent, false)
        return RewardViewHolder(view)
    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        val reward = rewards[position]
        holder.bind(reward)
    }

    override fun getItemCount(): Int = rewards.size

    class RewardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvRewardName: TextView = itemView.findViewById(R.id.tvRewardName)
        private val tvRewardPoints: TextView = itemView.findViewById(R.id.tvRewardPoints)

        fun bind(reward: Reward) {
            tvRewardName.text = reward.name
            tvRewardPoints.text = "${reward.points} puntos"
        }
    }
}
