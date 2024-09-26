package com.example.appeventos.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "users.db";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_USERS = "users";
	private static final String COLUMN_EMAIL = "email";
	private static final String COLUMN_PASSWORD = "password";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String createTable = "CREATE TABLE " + TABLE_USERS + " (" +
				COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
				COLUMN_PASSWORD + " TEXT)";
		db.execSQL(createTable);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
		onCreate(db);
	}

	public void insertUser(String email, String password) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUMN_EMAIL, email);
		values.put(COLUMN_PASSWORD, password);
		db.insert(TABLE_USERS, null, values);
		db.close();
	}
}


