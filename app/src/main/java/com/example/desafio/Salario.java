package com.example.desafio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;

public class Salario extends AppCompatActivity {

    Spinner opciones;
    EditText N, Ape, H;
    ArrayList<String> Anombre = new ArrayList<>();
    ArrayList<String> Aapellido = new ArrayList<>();
    ArrayList<String> Ahora = new ArrayList<>();
    ArrayList<String> Acargo = new ArrayList<>();
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);

        N = (EditText) findViewById(R.id.txtN);
        Ape = (EditText) findViewById(R.id.txtApe);
        H = (EditText) findViewById(R.id.txtH);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        opciones =(Spinner)findViewById(R.id.Spn1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.preference_category);
        opciones.setAdapter(adapter);

    }

    public void agregar (View V){
        String nombres, apellidos, cargo, hora;
        nombres = N.getText().toString();
        apellidos = Ape.getText().toString();
        cargo = opciones.getSelectedItem().toString();
        hora = H.getText().toString();

        if(nombres.equals("") || apellidos.equals("") || hora.equals("")){
            Toast.makeText(this, "No puede deja campos vacíos", Toast.LENGTH_SHORT).show();
        } else {
            Anombre.add(nombres);
            Aapellido.add(apellidos);
            Ahora.add(hora);
            Acargo.add(cargo);

            N.setText("");
            H.setText("");
            Ape.setText("");
        }
    }

    public void calcular(View V){
        String nombres, apellidos, cargo, cadena, cadenat = "", h;
        int hora;
        double pt, st, is, afp, renta;
        if (Anombre.size() == 3){
            for (int i = 0; i <=2; i++){
                nombres = Anombre.get(i);
                apellidos = Aapellido.get(i);
                cargo = Acargo.get(i);
                h = Ahora.get(i);
                h.trim();
                hora = Integer.parseInt((h));

                if (hora <= 160){
                    pt = 9.75 * hora;
                } else {
                    hora -= 160;
                    pt = (hora * 11.50) + (160 * 9.75);
                }
                is = pt * 0.0525;
                afp = pt * 0.0688;
                renta = pt * 0.1;

                st = pt - (is + afp + renta);

                if (Acargo.get(0).equals("Gerente") && Acargo.get(1).equals("Asistente") && Acargo.get(2).equals("Secretaria")){
                    Toast.makeText(this, "NO HAY BONO", Toast.LENGTH_SHORT).show();
                }else if(cargo.equals("Gerente")){
                    st +=  (st * 0.1);
                }else if(cargo.equals("Asistente")){
                    st += (st * 0.05);
                }else if(cargo.equals("Secretaria")){
                    st +=(st * 0.03);
                }else {
                    st +=(st * 0.02);
                }
                cadena= "\n\n\tNombre: " + nombres + " " + apellidos + "\n\tDescuento ISSS $: " + is + "\n\tDescuento AFP: $" + afp + "\n\tDescuento Renta: $" + renta + "\n\tSueldo liquido: $" + st;
                cadenat += cadena;
            }
            lblResultado.setText(cadenat);
        } else{
            Toast.makeText(this, "INGRESE LOS TRES EMPLEADOS PRIMERO", Toast.LENGTH_SHORT).show();
        }
    }
    public void menu (View V){
        Intent Login = new Intent(this, Menu.class);
        startActivity(Login);
    }
}