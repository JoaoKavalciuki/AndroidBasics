package com.example.androidbasics.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidbasics.R
import com.example.androidbasics.databinding.ActivityMainBinding
import com.example.androidbasics.databinding.ResItemLiveBinding
import com.example.androidbasics.models.MobileLanguage

class MainAdapter(private val onItemClicked: (MobileLanguage) -> Unit, private val binding: ActivityMainBinding) : RecyclerView.Adapter<MainViewHolder>(){

    private var mobileLanguages = mutableListOf<MobileLanguage>()

    fun setLanguagesList(mobileLanguages: List<MobileLanguage>){
        this.mobileLanguages = mobileLanguages.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ResItemLiveBinding.inflate(inflator, parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.mobileLanguages.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val mobileLanguage = mobileLanguages[position]
        holder.bind(mobileLanguage, onItemClicked)

    }
}

class MainViewHolder(val binding: ResItemLiveBinding) : RecyclerView.ViewHolder(binding.root){
    private val langImage = binding.ivLanguage
    fun bind(mobileLanguage: MobileLanguage, onItemClicked: (MobileLanguage) -> Unit){
        binding.tvLanguageName.text = mobileLanguage.language
        binding.tvDevName.text  = mobileLanguage.developer
        binding.tvReleaseYear.text = "Ano de lançamento ${mobileLanguage.releaseYear}"


        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)


        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(mobileLanguage.image)
            .into(langImage)

        itemView.setOnClickListener {
            onItemClicked(mobileLanguage)
        }
    }
}