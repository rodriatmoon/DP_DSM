package com.example.desafio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText User, Pass, CPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        User = (EditText) findViewById(R.id.txtUser2);
        Pass = (EditText) findViewById(R.id.txtPsw);
        CPass = (EditText) findViewById(R.id.txtCPsw);
    }

    public void Login (View view){
        BaseSQLite admin = new BaseSQLite(this, "inicio", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String usr, psw, cpsw;
        usr = User.getText().toString();
        psw = Pass.getText().toString();
        cpsw = CPass.getText().toString();
        ContentValues registro = new ContentValues();

        if(usr.equals("") || psw.equals("")|| cpsw.equals("")){
            Toast.makeText(this, "No puede deja campos vacíos", Toast.LENGTH_SHORT).show();
        }else if (psw.equals(cpsw)){
            registro.put("user", usr);
            registro.put("pass", psw);
            bd.insert("Login", null, registro);
            bd.close();
            Toast.makeText(this, "Se registró correctamente",Toast.LENGTH_SHORT).show();
            User.setText("");
            Pass.setText("");
            CPass.setText("");
            Intent Login = new Intent(this, MainActivity.class);
            startActivity(Login);
        }
        else {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }
    }
}