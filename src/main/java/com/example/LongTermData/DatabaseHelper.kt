package com.example.LongTermData

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    //1. Tạo database và bảng cùng với 3 field
    companion object {
        private const val DATABASE_NAME = "UserDB.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "users"
        private const val COL_ID = "id"
        private const val COL_NAME = "name"
        private const val COL_EMAIL = "email"
    }

    //2. Tạo bảng
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_NAME TEXT," +
                "$COL_EMAIL TEXT)"
        db?.execSQL(createTable)
    }
    //3. Update daata
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertUser(name: String, email: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COL_NAME, name)
        values.put(COL_EMAIL, email)
        val result = db.insert(TABLE_NAME, null, values)
        return result != -1L
    }

    //4. Lấy dữ liệu
    fun getAllUsers(): String {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val sb = StringBuilder()
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID))
            val name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME))
            val email = cursor.getString(cursor.getColumnIndexOrThrow(COL_EMAIL))
            sb.append("$id - $name - $email\n")
        }
        cursor.close()
        return if (sb.isEmpty()) "Database rỗng" else sb.toString()
    }

    //5. Xóa dữ liệu
    fun deleteAllUsers() {
        val db = writableDatabase
        db.delete(TABLE_NAME, null, null)
    }
}