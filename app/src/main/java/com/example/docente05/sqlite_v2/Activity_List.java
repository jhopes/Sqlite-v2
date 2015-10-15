package com.example.docente05.sqlite_v2;

import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.docente05.sqlite_v2.BD_SQLite.SQLite;


public class Activity_List extends ActionBarActivity {
    SQLite cx;
    ListView listv_client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        cx = new SQLite(this, "BDventa", null, 1);
        listv_client = (ListView) findViewById(R.id.ListvCliente);
        read_client();
    }

    public void read_client(){
        Cursor cu = cx.getReadableDatabase().rawQuery("SELECT nombres||' '||apellidos FROM cliente",null);
        String list[] = new String[cu.getCount()];
        int n=0;
        if (cu.moveToFirst()) {
            do {
                list[n] = cu.getString(0).toString();
                n++;
            } while (cu.moveToNext());
        }
        listv_client.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,list));
    }

}
