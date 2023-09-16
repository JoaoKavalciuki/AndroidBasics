package com.example.androidbasics.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidbasics.R
import com.example.androidbasics.databinding.ResItemLiveBinding
import com.example.androidbasics.models.Live

class MainAdapter(private val onItemClicked: (Live) -> Unit) : RecyclerView.Adapter<MainViewHolder>(){

    private var lives = mutableListOf<Live>()

    fun setLiveList(lives: List<Live>){
        this.lives = lives.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ResItemLiveBinding.inflate(inflator, parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.lives.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val live = lives[position]
        holder.bind(live, onItemClicked)

    }
}

class MainViewHolder(val binding: ResItemLiveBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(live: Live, onItemClicked: (Live) -> Unit){
        binding.tvAuthor.text = live.author
        binding.tvTitle.text  = live.title

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)


        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(live.thumbnailUrl)
            .into(binding.ivThumbnail)

        itemView.setOnClickListener {
            onItemClicked(live)
        }
    }
}