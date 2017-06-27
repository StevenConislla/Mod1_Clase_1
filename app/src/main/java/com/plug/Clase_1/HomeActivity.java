package com.plug.Clase_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {
    private EditText texto;
    private Button procesar,pasar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Nos dice que ejecutara el metodo que viene por defecto al inicio del OnCreate
        super.onCreate(savedInstanceState);
        //Agregamos el diseño a mostrar y hacemos referencia al archivo XML
        setContentView(R.layout.activity_home);
        //Guardamos las variables obtenidas de cada uno en las variables creadas.
        texto=(EditText)findViewById(R.id.edTexto);
        procesar=(Button)findViewById(R.id.btnPresionar);
        resultado=(TextView)findViewById(R.id.tvResultado);
        pasar=(Button)findViewById(R.id.btnPasar);
        Log.d("TAG", "-->onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "-->onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "-->onResume");
        //creamos el evento que pasara luego de presionar pasar
        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Evento OnClick

                //Obtenemos el texto que escribimos
                String textoEscrito=texto.getText().toString();
                //Cambiamos el texto a mostrar.

                if(textoEscrito.trim().isEmpty()){
                    //Si es que no tiene texto, se mostrata un mensaje de error
                    //Toast.makeText(HomeActivity.this, getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
                    Toast toast=Toast.makeText(HomeActivity.this, getResources().getString(R.string.error), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    //el 0,0 son las coordenadas medidas desde el centro
                    toast.show();
                }
                else{
                    //Si tod esta bien se muestra el texto escrito
                    resultado.setText(textoEscrito);
                    //CAMBIAMOS EL TEXTO A MOSTRAR
                }
                //Creamos el evento que ocurre al presionar pasar

                //Leng short dura 1 segundo, length long dura mas de un segundo.
                //Integer.parseInt() lo que hace es convertir el texto escrito en nummero
                //Double.parseDouble() convierte el texto en un decimal
            }
        });

        pasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //el intent me sirve para pasar de un layout a otro, o desde el mismo layout a otra aplicacion
                Intent intent=new Intent(HomeActivity.this,RegistroActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "-->onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "-->onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "-->onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "-->onRestart");
    }
}
