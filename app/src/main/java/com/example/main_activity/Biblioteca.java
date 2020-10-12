package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Biblioteca extends AppCompatActivity
{

    private TextView Valor;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca);

        Valor = (TextView)findViewById(R.id.Valor);
        spinner = (Spinner)findViewById(R.id.spinner)  ;

        ArrayList<String> ListaLisbros = (ArrayList<String>) getIntent().getSerializableExtra("ListaLibros");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListaLisbros);

        spinner.setAdapter(adapt);
    }
    public void Mostrar (View v)
    {
        spinner.getSelectedItem().toString();

        if (spinner.getSelectedItem().toString() == "Farenheith" )

        {
            Valor.setText("El Valor de Farenheith es 5000");
        }
        else if (spinner.getSelectedItem().toString() == "Revival")

        {
            Valor.setText("El Valor de Revival es 12000");
        }
        else if (spinner.getSelectedItem().toString()== "El Alquimista")

        {
            Valor.setText("El valor de El Alquimista es 45000");
        }


    }
}