package com.example.desafio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Contar extends AppCompatActivity {

    TextView LResultado;
    EditText TVotos;
    Button Bcalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contar);
        TVotos = (EditText)findViewById(R.id.txtVotos);
        LResultado = (TextView)findViewById(R.id.lblResultados);
    }

    public void menu (View V){
        Intent Login = new Intent(this, Menu.class);
        startActivity(Login);
    }

    public void Cont (View view) {
        String cadena;
        int U = 0, D = 0, T = 0, C = 0, PU, PD, PT, PC;
        cadena = TVotos.getText().toString();
        String[] vote = cadena.split("-");

        if (cadena.equals("")){
            Toast.makeText(this, "No puede deja campos vacíos", Toast.LENGTH_SHORT).show();
        }else for (int i = 0; i < vote.length; i++){
            String a = vote[i];
            switch (a){
                case "1":
                    U++;
                    break;
                case "2":
                    D++;
                    break;
                case "3":
                    T++;
                    break;
                case "4":
                    C++;
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Solo pueden contarse 4 candidatos. del 1 al 4", Toast.LENGTH_SHORT).show();                    break;
            }
        }
        PU = (U*100)/vote.length;
        PD = (D*100)/vote.length;
        PT = (T*100)/vote.length;
        PC = (C*100)/vote.length;
        LResultado.setText("Candidato 1 \n  Votos:" + U + "\n  Porcentaje: " + PU + "%" +"\n\nCandidato 2 \n  Votos:" + D + "\n  Porcentaje: " + PD + "%" +"\n\nCandidato 3 \n  Votos:" + T + "\n  Porcentaje: " + PT + "%" +"\n\nCandidato 4 \n  Votos:" + C + "\n  Porcentaje: " + PC + "%");
    }
}