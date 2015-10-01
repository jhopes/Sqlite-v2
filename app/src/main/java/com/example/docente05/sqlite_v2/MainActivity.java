package com.example.docente05.sqlite_v2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.docente05.sqlite_v2.BD_SQLite.SQLite;


public class MainActivity extends ActionBarActivity {
 SQLite cx;
    EditText Edtname, Edtlast_name, Edtaddress, Edtdni, Edtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cx = new SQLite(this,"BDventa",null,1);
        Edtname = (EditText) findViewById(R.id.EdtName);
        Edtlast_name = (EditText) findViewById(R.id.EdtAp);
        Edtaddress = (EditText) findViewById(R.id.EdtDirec);
        Edtdni = (EditText) findViewById(R.id.Edtdni);
        Edtemail = (EditText) findViewById(R.id.EdtEmail);


    }
    public void create_client(View v){
        if(cx.getWritableDatabase()!=null){
            cx.getWritableDatabase().execSQL("INSERT INTO cliente(nombres, apellidos, direccion, dni, email) " +
                    "VALUES('"+Edtname.getText().toString()+"', '"+Edtlast_name.getText().toString()+"' , " +
                    "'"+Edtaddress.getText().toString()+"' , '"+Edtdni.getText().toString()+"' , '"+Edtemail.getText().toString()+"' )");

        }
    }
}
