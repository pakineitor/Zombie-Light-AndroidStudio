package com.Fran.ZombieLight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    EditText Correo, Password, Nombre, Fechatxt;            //Declaramos las variables.
    Button Aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
                                                           //Vamos a referenciar los elementos EditText de la clase con la activity.xml-->
        Correo      = findViewById(R.id.Correo);
        Password    = findViewById(R.id.Password);
        Nombre      = findViewById(R.id.Nombre);
        Fechatxt    = findViewById(R.id.Fechatxt);
                                                            //Vamos a referenciar los elementos Button de la clase con la activity.xml-->
        Aceptar     = findViewById(R.id.Aceptar);




    }


}