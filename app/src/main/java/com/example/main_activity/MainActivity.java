package com.example.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private EditText Usuario, Contraseña;
    private Button LogIn ;
    private ProgressBar progressBar;
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario = (EditText)findViewById(R.id.Usuario);
        Contraseña = (EditText)findViewById(R.id.Contraseña);
        LogIn = (Button)findViewById(R.id.LogIn)  ;
        progressBar = (ProgressBar)findViewById(R.id.progressBar) ;
        imageButton = (ImageButton)findViewById(R.id.imageButton);

        imageButton.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute();
            }
        });
    }
    class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute()
        {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i <= 5; i++)
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.INVISIBLE);

            if(Usuario.getText().toString().trim().equals("Android"))
            {
                if(Contraseña.getText().toString().trim().equals("1234"))
                {
                    imageButton.setVisibility(View.VISIBLE);
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
            }
            if(Contraseña.getText().toString().trim().equals("1234"))
            {
                if(Usuario.getText().toString().trim().equals("Android"))
                {
                    imageButton.setVisibility(View.VISIBLE);
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void boton(View v)
    {
        ArrayList<String> libros = new ArrayList<String>();
        libros.add("Farenheith");
        libros.add("Revival");
        libros.add("El Alquimista");

        Intent i = new Intent(getBaseContext(), Biblioteca.class);
        i.putExtra("listaLibros",libros);

        startActivity(i);
        imageButton.setVisibility(View.INVISIBLE);
    }
}