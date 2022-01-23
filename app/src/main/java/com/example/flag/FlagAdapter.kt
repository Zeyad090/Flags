package com.example.flag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flag.databinding.FlagViewItemBinding


class FlagAdapter: androidx.recyclerview.widget.ListAdapter<Flag,FlagAdapter.FlagViewHolder>(DiffCallback){

    class FlagViewHolder(private val binding :FlagViewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(falgPhoto: Flag) {
            binding.flagModel = falgPhoto
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagViewHolder {
return FlagViewHolder(FlagViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FlagViewHolder, position: Int) {
        val flagPhoto = getItem(position)
        println(flagPhoto.flag)
        holder.bind(flagPhoto)    }

    companion object DiffCallback: DiffUtil.ItemCallback<Flag>(){
        override fun areItemsTheSame(oldItem: Flag, newItem: Flag): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Flag, newItem: Flag): Boolean {
            return oldItem.flag == newItem.flag
        }

    }
}