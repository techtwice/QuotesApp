package com.example.quotesapp

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_quote_details.*

class QuoteDetailsActivity : AppCompatActivity() {

    private var quoteCategoryId = 0
    private var db: SQLiteDatabase? = null
    private var cursor: Cursor? = null
    private var quotesAdapter: QuotesAdapter? = null

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

        val listOfQuotes = mutableListOf<String>()

        while (cursor!!.moveToNext()) {
            val quote = cursor!!.getString(0)
            listOfQuotes.add(quote)
        }

        // Create an Adapter Object
        quotesAdapter = QuotesAdapter(this, listOfQuotes) { quote ->

            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, quote)
            shareIntent.type = "text/plain"
            startActivity(shareIntent)


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