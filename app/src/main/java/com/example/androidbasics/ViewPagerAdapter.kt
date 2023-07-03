package com.example.androidbasics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidbasics.model.Book
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(val books: List<Book>): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        when(holder){
            is ViewPagerViewHolder ->  {
                holder.bind(books[position])
            }
        }
    }

    override fun getItemCount(): Int {
       return books.size
    }
    class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val bookName =  itemView.tvBookName
        private val bookOwner = itemView.tvBookOwner
        private val bookPrice = itemView.tvBookPrice
        private val bookImage = itemView.ivImageBook

        fun bind(bookData: Book){
            bookName.text = bookData.name
            bookOwner.text = bookData.owner
            bookPrice.text = "R$${String.format("%.2f", bookData.price)}"

            val requestOptionns = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptionns)
                .load(bookData.image)
                .into(bookImage)

        }
    }
}