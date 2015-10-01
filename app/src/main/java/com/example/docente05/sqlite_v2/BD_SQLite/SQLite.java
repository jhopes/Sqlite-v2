package com.example.docente05.sqlite_v2.BD_SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by docente05 on 01/10/2015.
 */
public class SQLite extends SQLiteOpenHelper{
    String name_table[]={"cliente","producto"};
    String sql_table0="CREATE TABLE "+name_table[0]+" (id_cliente INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nombres TEXT, apellidos TEXT, direccion TEXT, dni TEXT, email TEXT)";
    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql_table0);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+name_table[0]);
        this.onCreate(db);
    }
}
