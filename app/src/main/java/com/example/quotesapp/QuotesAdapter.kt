package com.example.quotesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuotesAdapter(
    private val context: Context,
    private val quotes: List<String>,
    val onItemLongClick: (String) -> Unit
) :
    RecyclerView.Adapter<QuotesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.quote_item, parent, false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return quotes.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindQuote(quotes[position])
    }


    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val tvQuoteItem: TextView = itemView.findViewById(R.id.tvQuoteItem)

        fun bindQuote(quote: String) {
            tvQuoteItem.text = quote

            itemView.setOnLongClickListener {
                onItemLongClick(quote)
                true
            }
        }


    }

}