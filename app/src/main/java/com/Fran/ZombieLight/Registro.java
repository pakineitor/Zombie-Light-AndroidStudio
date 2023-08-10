package com.Fran.ZombieLight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {
    EditText Correo, Password, Nombre;                                                              //Declaramos las variables.
    TextView Fechatxt;
    Button Aceptar;
    final int LongitudPassword=6;
    FirebaseAuth auth;                                                                              // Esta variable sirve para nstanciar el registro de cada usuario con la bd de Firebase.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
                                                                                                    // Conexión con la vista:
                                                                                                    // Vamos a referenciar los elementos EditText de la clase con la activity_registro.xml-->
        Correo                  = findViewById(R.id.Correo);
        Password                = findViewById(R.id.Password);
        Nombre                  = findViewById(R.id.Nombre);
                                                                                                    // Vamos a referenciar el elemento Textview de la clase con el del activity_registro.xml-->
        Fechatxt                = findViewById(R.id.Fechatxt);
                                                                                                    // Vamos a referenciar los elementos Button de la clase con la activity_registro.xml-->
        Aceptar                 = findViewById(R.id.Aceptar);

        auth                     = FirebaseAuth.getInstance();

        mostrarFechaActual();

        Aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gmail    = Correo.getText().toString();
                String password = Password.getText().toString();
                ComprobarDatos(gmail,password);
            }
        });
    }
                                                                                                    /*
                                                                                                    * Método que va a comprobar si los datos de registro son válidos.
                                                                                                    * @param gmail de tipo String, este parámetro de entrada almacnará el correo que el usuario introduzca.
                                                                                                    * @param password de tipo String, este parámetro almacenará la contraseña que el usuario introduzca.
                                                                                                    * */
    public void ComprobarDatos(String gmail, String password){
        if(!Patterns.EMAIL_ADDRESS.matcher(gmail).matches()){                                       //Esta línea de código comprueba que esté el "@" y ".com/.es" para saber que es una dirección de correo.
            Correo.setError("Los datos introducidos no son correctos");                                 //Mostramos un mensaje de error para informar al usuario.
            Correo.setFocusable(true);                                                                  //Permite modificar
        }else if(password.length() < LongitudPassword){
            Password.setError("La contraseña debe tener al menos caracteres");
            Password.setFocusable(true);
        }
        if(password.length() > LongitudPassword){
            RegistrarJugador(gmail, password);
        }
    }

        private void RegistrarJugador(String gmail, String password){
                auth.createUserWithEmailAndPassword(gmail, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                //Si el proceso es correcto:
                                if(task.isSuccessful()){
                                    FirebaseUser user = auth.getCurrentUser();
                                    int Contador         = 0;
                                    assert user         != null;
                                    String uidString     = user.getUid();
                                    String correoString  = Correo.getText().toString();
                                    String passwordString= Password.getText().toString();
                                    String nombreString  = Nombre.getText().toString();
                                    String fechaString   = Fechatxt.getText().toString();
                                }
                            }
                            //Si falla el proceso:
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });

         }                                                                                           /*
                                                                                                    * Método que va a extraer de forma automática la fecha en la cual se registra el usuario.
                                                                                                    */
    public void mostrarFechaActual() {
        Calendar c  = Calendar.getInstance();
        int anio    = c.get(Calendar.YEAR);
        int mes     = c.get(Calendar.MONTH) + 1;
        int dia     = c.get(Calendar.DAY_OF_MONTH);
        Fechatxt.setText(dia + "/" + mes + "/" + anio);
    }

}