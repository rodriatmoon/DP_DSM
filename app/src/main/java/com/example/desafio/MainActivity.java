package com.example.desafio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText User, Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User = (EditText) findViewById(R.id.txtUser);
        Pass = (EditText) findViewById(R.id.txtPass);
    }
    public void Registro (View view){
        Intent Registro = new Intent(this, Registro.class);
        startActivity(Registro);
    }

    public void Menu (View view) {
        BaseSQLite admin = new BaseSQLite(this, "inicio", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String usr, psw, pswbd = null;
        usr = User.getText().toString();
        psw = Pass.getText().toString();
        Cursor item = bd.rawQuery("select user from Login where user= '" + usr + "' and pass= '" + psw+"'", null);
        if (usr.equals("") || psw.equals("")){
            Toast.makeText(this, "No puede deja campos vacíos", Toast.LENGTH_SHORT).show();
        }else if (item.moveToFirst()) {
            Intent Menu = new Intent(this, Menu.class);
            startActivity(Menu);
        }
        bd.close();
    }

}