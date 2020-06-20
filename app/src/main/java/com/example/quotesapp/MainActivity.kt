package com.example.quotesapp

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var db: SQLiteDatabase? = null
    var cursor: Cursor? = null
    var categoriesAdapter: CategoriesAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Read all Quotes Categories from Database
        val myQuotesDatabaseHelper = QuotesSQLiteOpenHelper(this)
        db = myQuotesDatabaseHelper.readableDatabase
        cursor = db!!.query(
            "quote_categories",
            arrayOf("_id", "image_resource_id", "name"),
            null,
            null,
            null,
            null,
            null
        )

        var listOfCategories = mutableListOf<CategoryData>()

        while (cursor!!.moveToNext()) {
            val categoryId = cursor!!.getInt(0)
            val categoryResourceId = cursor!!.getInt(1)
            val categoryName = cursor!!.getString(2)

            val categoryData: CategoryData =
                CategoryData(categoryId, categoryResourceId, categoryName)

            listOfCategories.add(categoryData)
        }

        categoriesAdapter = CategoriesAdapter(this, listOfCategories) { categoryId ->
            val intent = Intent(this, QuoteDetailsActivity::class.java)
            intent.putExtra("QUOTE_CATEGORY_ID", categoryId)
            startActivity(intent)
        }


        // Using the Grid Layout Manager
        val categoriesGridLayoutManager = GridLayoutManager(this, 2)
        rvQuotesCategories.adapter = categoriesAdapter
        rvQuotesCategories.layoutManager = categoriesGridLayoutManager


        /*

        // Using the Layout Manager Verticle
        val categoriesLayoutManager = LinearLayoutManager(this)
        rvQuotesCategories.adapter = categoriesAdapter
        rvQuotesCategories.layoutManager = categoriesLayoutManager



        // Using the Layout Manager Horizental
        val categoriesHorizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvQuotesCategories.adapter = categoriesAdapter
        rvQuotesCategories.layoutManager = categoriesHorizontalLayoutManager

        // Using the Layout Manager Horizental Reverse True
        val categoriesHorizontalReverseLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        rvQuotesCategories.adapter = categoriesAdapter
        rvQuotesCategories.layoutManager = categoriesHorizontalReverseLayoutManager




         */
    }

    override fun onDestroy() {
        super.onDestroy()
        db!!.close()
        cursor!!.close()
    }
}