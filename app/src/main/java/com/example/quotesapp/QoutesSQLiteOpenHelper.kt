package com.example.quotesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class QoutesSQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context, "QoutesDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(
            "CREATE TABLE qoute_categories (" +
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

    }

    fun insertQouteCategory(db: SQLiteDatabase?, id: Int, resourceId: Int, name: String) {
        val contentValues = ContentValues()
        contentValues.put("_id", id)
        contentValues.put("image_resource_id", resourceId)
        contentValues.put("name", name)

        db!!.insert("qoute_categories", null, contentValues)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}