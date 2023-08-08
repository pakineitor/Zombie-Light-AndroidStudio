package com.Fran.ZombieLight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button BotonRegistrar, BotonLogin;                                        //Creamos el objeto de tipo botón para asociarlas con los elementos del xml.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BotonRegistrar = findViewById(R.id.bt_Registrar);                      //Asocio esta variable con la del xml.
        BotonLogin     = findViewById(R.id.bt_Login);

        BotonLogin.setOnClickListener(new View.OnClickListener() {             //Método que sirve para darle funcionalidad al botón.
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Has pulsado al botón login", Toast.LENGTH_SHORT).show();
            }
        });

        BotonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Registro.class));               //Lanzamos una actividad realizada en un tiempo determinado pasándole donde estamos y a qué clase queremos ir.
            }
        });
    }
}