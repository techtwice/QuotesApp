package com.example.quotesapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(
    val context: Context,
    val categories: List<CategoryData>,
    val onItemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        val myViewHolder = MyViewHolder(view, onItemClick)

        return myViewHolder
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder!!.bindData(categories[position], context)
    }

    //Tis Class will be used for either create or Views
    inner class MyViewHolder(itemView: View, val onItemClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        val categoryImage = itemView!!.findViewById<ImageView>(R.id.ivCategoryImage)
        val categoryName = itemView!!.findViewById<TextView>(R.id.tvCategoryName)
        fun bindData(category: CategoryData, context: Context) {
            categoryImage.setImageResource(category.resourceId)
            categoryName.text = category.name

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