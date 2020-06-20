package com.example.quotesapp

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_quote_details.*

class QuoteDetailsActivity : AppCompatActivity() {

    var quoteCategoryId = 0
    var db: SQLiteDatabase? = null
    var cursor: Cursor? = null
    var quotesAdapter: QuotesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_details)

        quoteCategoryId = intent.extras?.get("QUOTE_CATEGORY_ID").toString().toInt()

        //     Toast.makeText(this, "You Clicked On ${quoteCategoryId.toString()}", Toast.LENGTH_SHORT).show()

        // Read Data From Database
        val myQuotesDatabaseHelper = QuotesSQLiteOpenHelper(this)
        db = myQuotesDatabaseHelper.readableDatabase

        cursor = db!!.query(
            "" + "quotes", arrayOf("quote"),
            "category_id=?",
            arrayOf(quoteCategoryId.toString()),
            null,
            null,
            null
        )

        var listOfQuotes = mutableListOf<String>()

        while (cursor!!.moveToNext()) {
            val quote = cursor!!.getString(0)
            listOfQuotes.add(quote)
        }

        // Create an Adapter Object

        quotesAdapter = QuotesAdapter(this, listOfQuotes) { quote ->

        }

        // Use A Layout Manager
        val quoteLayoutManager = LinearLayoutManager(this)

        rvQuotesShow.layoutManager = quoteLayoutManager
        rvQuotesShow.adapter = quotesAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
        db!!.close()
        cursor!!.close()
    }
}