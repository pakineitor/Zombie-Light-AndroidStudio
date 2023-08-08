package com.Fran.ZombieLight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {
    EditText Correo, Password, Nombre;            //Declaramos las variables.
    TextView Fechatxt;
    Button Aceptar;
    FirebaseAuth auth;                                      // Esta variable sirve para nstanciar el registro de cada usuario con la bd de Firebase.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
                                                           // Conexión con la vista:
                                                           // Vamos a referenciar los elementos EditText de la clase con la activity_registro.xml-->
        Correo      = findViewById(R.id.Correo);
        Password    = findViewById(R.id.Password);
        Nombre      = findViewById(R.id.Nombre);
                                                           // Vamos a referenciar el elemento Textview de la clase con el del activity_registro.xml-->
        Fechatxt    = findViewById(R.id.Fechatxt);
                                                           // Vamos a referenciar los elementos Button de la clase con la activity_registro.xml-->
        Aceptar     = findViewById(R.id.Aceptar);




    }


}