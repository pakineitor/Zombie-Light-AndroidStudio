package com.Fran.ZombieLight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    int time_splash=2500;                                                                           //Medio segundo para decirle el tiempo que se ajuste.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
                                                                                                    /*Función Handler, ejecuta en un tiempo concreto lo que pide el método*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {                                                                     //Se ejecuta el intent, cuyo objeto permite ir de una actividad a otra. por eso se lo pasamos al start activity.
                                                                                                    //Al intent le pasamos el contexto y la clase a la que queremos ir.
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        }, time_splash);
    }
}