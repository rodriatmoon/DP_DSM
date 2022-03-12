package com.example.desafio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Formula extends AppCompatActivity {

    EditText a, b, c;
    TextView r1, r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);
        a = (EditText)findViewById(R.id.txtA);
        b = (EditText)findViewById(R.id.txtB);
        c = (EditText)findViewById(R.id.txtC);
        r1 = (TextView)findViewById(R.id.lblX1);
        r2 = (TextView)findViewById(R.id.lblX2);
    }
    public void menu (View V){
        Intent Login = new Intent(this, Menu.class);
        startActivity(Login);
    }
    public void Calcular (View view){
        float x1, x2, na, nb, nc, D1, D2, N;
        double r;
        double rr;
        double nbc;
        na = Float.parseFloat(a.getText().toString());
        nb = Float.parseFloat(b.getText().toString());
        nc = Float.parseFloat(c.getText().toString());

        nbc = Math.pow(nb, 2);
        r = nbc - (4* na * nc);

        if (r >=0 ) {
            rr = Math.pow(r, 2);
            D1 = (float) ((-nb) + rr);
            D2 = (float) ((-nb) - rr);
            N = 2 * na;
            x1 = D1/N;
            x2 = D2/N;

            r1.setText("X1: " + x1);
            r2.setText("X2: " + x2);
        }else {
            Toast.makeText(getApplicationContext(), "No se puede calcular por fórmula cuadrática ya que el argumento de la raíz es negativo.", Toast.LENGTH_LONG).show();
        }
    }
}