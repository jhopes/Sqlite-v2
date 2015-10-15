package com.example.docente05.sqlite_v2;

import android.app.AlertDialog;
import android.content.Intent;
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
        cx = new SQLite(this, "BDventa", null, 1);
        Edtname = (EditText) findViewById(R.id.EdtName);
        Edtlast_name = (EditText) findViewById(R.id.EdtAp);
        Edtaddress = (EditText) findViewById(R.id.EdtDirec);
        Edtdni = (EditText) findViewById(R.id.Edtdni);
        Edtemail = (EditText) findViewById(R.id.EdtEmail);
        Edtname.setText(Edtaddress.getText().toString());

    }
    public void create_client(View v){
        if(valida_vacio()) {
            if (cx.getWritableDatabase() != null) {
                cx.getWritableDatabase().execSQL("INSERT INTO cliente(nombres, apellidos, direccion, dni, email) " +
                        "VALUES('" + Edtname.getText().toString() + "', '" + Edtlast_name.getText().toString() + "' , " +
                        "'" + Edtaddress.getText().toString() + "' , '" + Edtdni.getText().toString() + "' , '" + Edtemail.getText().toString() + "' )");

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Insertado correctamente").show();
                this.limpiar();
            }
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Ingrese datos").show();
        }
    }
    public void limpiar(){
        Edtname.setText("");
        Edtlast_name.setText("");
        Edtaddress.setText("");
        Edtdni.setText("");
        Edtemail.setText("");
    }
    public boolean valida_vacio()
    {
        if(!Edtname.getText().toString().equals("") &&
            !Edtlast_name.getText().toString().equals("") &&
            !Edtaddress.getText().toString().equals("") &&
            !Edtdni.getText().toString().equals("") &&
            !Edtemail.getText().toString().equals("")){
            return true;
        }else{
            return false;
        }

    }
    public void next_Activity(View v){
        Intent i = new Intent(this,Activity_List.class);
        //this.finish();
        startActivity(i);
    }
}
