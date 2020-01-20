package com.alimasanov.beeapp.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val table1 = "CREATE TABLE $TABLE1_NAME(" +
                "$COL_ID    INTEGER PRIMARY KEY," +
                "$COL_DATE  TEXT," +
                "$COL_LARVAL_AGE TEXT," +
                "$COL_LARVAL_AGE_INDEX INTEGER," +
                "$COL_NOTE  TEXT," +
                "$COL_TIMESTAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP)"

        val table2 = "CREATE TABLE $TABLE2_NAME(" +
                "$COL_ID    INTEGER PRIMARY KEY," +
                "$COL_TABLE1_ID INTEGER," +
                "$COL_STAGE TEXT, " +
                "$COL_DONE INTEGER," +
                "$COL_DATE_ASSIGNED TEXT," +
                "$COL_DATE_DONE TEXT)"
        db!!.execSQL(table1)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE1_NAME")
        db.execSQL("DROP TABLE IF EXISTS $TABLE2_NAME")
        onCreate(db)
    }

    companion object{
        const val DB_NAME = "BeeAppDB"
        const val DB_VERSION = 1

        const val TABLE2_NAME = "table2"
        const val COL_TABLE1_ID = "COL_TABLE_ID"
        const val COL_STAGE = "COL_STAGE"
        const val COL_DONE = "COL_DONE"
        const val COL_DATE_DONE = "DONE_DATE"
        const val COL_DATE_ASSIGNED = "ASSIGNED_DATE"

        const val TABLE1_NAME = "table1"
        const val COL_ID = "ROW_ID"
        const val COL_DATE = "MASONRY_DATE"
        const val COL_LARVAL_AGE = "LARVAL_AGE"
        const val COL_LARVAL_AGE_INDEX = "LARVAL_AGE_INDEX"
        const val COL_NOTE = "NOTE"
        const val COL_TIMESTAMP = "TIMESTAMP"
    }
}