package com.example.desafio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void formula(View V){
        Intent Formula = new Intent(this, Formula.class);
        startActivity(Formula);
    }
    public void contar(View V){
        Intent Contar = new Intent(this, Contar.class);
        startActivity(Contar);
    }
    public void salario(View V){
        Intent Salario = new Intent(this, Salario.class);
        startActivity(Salario);
    }
    public void Logout (View V){
        Intent Logout = new Intent(this, MainActivity.class);
        startActivity(Logout);
    }
}