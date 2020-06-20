package com.example.quotesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(
    private val context: Context,
    private val categories: List<CategoryData>,
    private val onItemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)

        return MyViewHolder(view, onItemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categories[position])
    }

    //Tis Class will be used for either create or Views
    inner class MyViewHolder(itemView: View, val onItemClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val ivCategoryImage: ImageView = itemView.findViewById(R.id.ivCategoryImage)
        private val tvCategoryName: TextView = itemView.findViewById(R.id.tvCategoryName)
        fun bindData(category: CategoryData) {
            ivCategoryImage.setImageResource(category.resourceId)
            tvCategoryName.text = category.name

            itemView.setOnClickListener {
                onItemClick(category.id)
            }


            /*
            itemView.setOnClickListener {
                Toast.makeText(context,"You Clicked On ${category.name}", Toast.LENGTH_SHORT).show()
                // val intent = Intent(context,QuoteDetailsActivity::class.java)
                context.startActivity(Intent(context,QuoteDetailsActivity::class.java))
            }

             */
        }
    }


}