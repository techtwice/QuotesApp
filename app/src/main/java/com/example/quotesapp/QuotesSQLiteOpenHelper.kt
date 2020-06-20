package com.example.quotesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class QuotesSQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context, null, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        // Categories Table
        db!!.execSQL(
            "CREATE TABLE quote_categories (" +
                    "_id INTEGER PRIMARY KEY," +
                    "image_resource_id TEXT," +
                    "name TEXT" +
                    ")"
        )

        insertQouteCategory(db, 1, R.drawable.alone, "Alone")
        insertQouteCategory(db, 2, R.drawable.birthday, "Birthday")
        insertQouteCategory(db, 3, R.drawable.childhood, "Childhood")
        insertQouteCategory(db, 4, R.drawable.love, "Love")
        insertQouteCategory(db, 5, R.drawable.marriage, "Marriage")
        insertQouteCategory(db, 6, R.drawable.romantic, "Romantic")
        insertQouteCategory(db, 7, R.drawable.sad, "Sad")
        insertQouteCategory(db, 8, R.drawable.success, "Success")

        // Quotes Table
        db!!.execSQL(
            "CREATE TABLE quotes(" +
                    "quote TEXT," +
                    "category_id INTEGER)"
        )

        insertQuote(db, "A room without books is like a body without a soul.", 1)
        insertQuote(db, "A room without books is like a body without a soul.", 1)
        insertQuote(db, "A room without books is like a body without a soul.", 1)
        insertQuote(db, "A room without books is like a body without a soul.", 1)
        insertQuote(db, "A room without books is like a body without a soul.", 1)
        insertQuote(db, "A room without books is like a body without a soul.", 2)
        insertQuote(db, "A room without books is like a body without a soul.", 2)
        insertQuote(db, "A room without books is like a body without a soul.", 2)
        insertQuote(db, "A room without books is like a body without a soul.", 2)
        insertQuote(db, "A room without books is like a body without a soul.", 2)
        insertQuote(db, "A room without books is like a body without a soul.", 3)
        insertQuote(db, "A room without books is like a body without a soul.", 3)
        insertQuote(db, "A room without books is like a body without a soul.", 3)
        insertQuote(db, "A room without books is like a body without a soul.", 3)
        insertQuote(db, "A room without books is like a body without a soul.", 3)
        insertQuote(db, "A room without books is like a body without a soul.", 3)
        insertQuote(db, "A room without books is like a body without a soul.", 4)
        insertQuote(db, "A room without books is like a body without a soul.", 4)
        insertQuote(db, "A room without books is like a body without a soul.", 4)
        insertQuote(db, "A room without books is like a body without a soul.", 4)
        insertQuote(db, "A room without books is like a body without a soul.", 4)
        insertQuote(db, "A room without books is like a body without a soul.", 4)
        insertQuote(db, "A room without books is like a body without a soul.", 4)
        insertQuote(db, "A room without books is like a body without a soul.", 4)
        insertQuote(db, "A room without books is like a body without a soul.", 5)
        insertQuote(db, "A room without books is like a body without a soul.", 5)
        insertQuote(db, "A room without books is like a body without a soul.", 5)
        insertQuote(db, "A room without books is like a body without a soul.", 5)
        insertQuote(db, "A room without books is like a body without a soul.", 5)
        insertQuote(db, "A room without books is like a body without a soul.", 5)
        insertQuote(db, "A room without books is like a body without a soul.", 5)
        insertQuote(db, "A room without books is like a body without a soul.", 5)
        insertQuote(db, "A room without books is like a body without a soul.", 5)

    }

    fun insertQuote(db: SQLiteDatabase?, quote: String, categoryId: Int) {
        val contentValues = ContentValues()
        contentValues.put("quote", quote)
        contentValues.put("category_id", categoryId)

        db!!.insert("quotes", null, contentValues)
    }


    fun insertQouteCategory(db: SQLiteDatabase?, id: Int, resourceId: Int, name: String) {
        val contentValues = ContentValues()
        contentValues.put("_id", id)
        contentValues.put("image_resource_id", resourceId)
        contentValues.put("name", name)

        db!!.insert("quote_categories", null, contentValues)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}