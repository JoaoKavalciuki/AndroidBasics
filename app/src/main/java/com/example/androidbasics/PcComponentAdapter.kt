package com.example.androidbasics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidbasics.models.PcComponent
import kotlinx.android.synthetic.main.pc_component.view.*

class PcComponentAdapter(private val onItemClicked: (PcComponent) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //ViewHolder representa o layout (pc_component.xml) no Adapter

    private var items: List<PcComponent> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PcComponentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pc_component, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is PcComponentViewHolder -> {
                holder.bind(items[position], onItemClicked)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

     fun setDataSet(pcComponents: List<PcComponent>){
        items = pcComponents
    }

    class PcComponentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val componentName = itemView.tvComponentName
        private val componentCategory = itemView.tvCategory
        private val componentFactory = itemView.tvFactory
        private val componentPrice = itemView.tvPrice
        private val componentImage = itemView.ivComponent

        fun bind(component: PcComponent, onItemClicked: (PcComponent) -> Unit){
            componentName.text = component.name
            componentCategory.text = component.category
            componentFactory.text = component.factory
            componentPrice.text = "R$${String.format("%.2f", component.price)}"

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(component.imageUrl)
                .into(componentImage)

            itemView.setOnClickListener {
                onItemClicked(component)
            }
        }
    }
}