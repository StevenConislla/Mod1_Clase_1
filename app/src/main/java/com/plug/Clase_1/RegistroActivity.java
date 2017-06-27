package com.plug.Clase_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by OSKAR on 23/06/2017.
 */

public class RegistroActivity extends Activity {
    private EditText etNombre,etApellido;
    private RadioButton rbMayor,rbMenor;
    private Spinner spGenero,spEdad;
    private CheckBox cbToma,cbFuma;
    private Button btnProcesar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Definimos de que clase xml se va a tomar el diseño
        setContentView(R.layout.activity_registro);
        etNombre=(EditText)findViewById(R.id.etNombre);
        etApellido=(EditText)findViewById(R.id.etApellido);
        rbMayor=(RadioButton)findViewById(R.id.rbMayor);
        rbMenor=(RadioButton)findViewById(R.id.rbMenor);
        spGenero=(Spinner)findViewById(R.id.spGenero);
        spEdad=(Spinner)findViewById(R.id.spEdad);
        cbToma=(CheckBox)findViewById(R.id.cbToma);
        cbFuma=(CheckBox)findViewById(R.id.cbFuma);
        btnProcesar=(Button)findViewById(R.id.btnProcesar);
        //Creamos una lista la cual tendra edades
        ArrayList<String> edades=new ArrayList<>();
        //Creamos los números del 15 al 65 para poder llenar la lista
        for (int i=15; i<65; i++){
            //agregamos los numeros a la lsta
            //String.valueOf->vuelve texto el numero que le mandamos
            edades.add(String.valueOf(i));
        }
        //Creamos el adapter que se usará para poder reemplazar el contenido del spinner
        ArrayAdapter arrayAdapter=new ArrayAdapter(

                RegistroActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                edades);
        //Cambiamos los datos a mostrar en nuestro spinner
        spEdad.setAdapter(arrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String nombre=etNombre.getText().toString();
                String apellido=etApellido.getText().toString();
                String genero=spGenero.getSelectedItem().toString();
                String edad=spEdad.getSelectedItem().toString();
                boolean mayor=rbMayor.isChecked();
                boolean menor=rbMenor.isChecked();
                boolean toma=cbToma.isChecked();
                boolean fuma=cbFuma.isChecked();
                //Pasamos a entero la edad, si el texto ingresado no es numero, entonces la app se cae;
                int edadEntero=Integer.parseInt(edad);
                if(nombre.trim().isEmpty()){
                    etNombre.setError("El campo es requerido");
                    return;
                }
                else{
                    etNombre.setError(null);
                }
                if(apellido.trim().isEmpty()){
                    etApellido.setError("El campo es requerido");
                    return;
                }
                else{
                    etApellido.setError(null);
                }
                //Validamos que los datos estén cargados
                if(!mayor&&!menor){
                    Toast.makeText(RegistroActivity.this,"Debe de seleccionar una opción Mayor o Menor",Toast.LENGTH_SHORT).show();
                    return;
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(RegistroActivity.this);
                builder.setTitle("Datos");
                builder.setMessage("Nombre->"+nombre+"\n"+
                        "Apellido->"+apellido+"\n"+
                        "Genero->"+genero+"\n"+
                        "Edad->"+edad+"\n"+
                        //solo pregunto por el mayor, ya que en caso no sea mayor sera menor ezzz
                        "Mayor?->"+(mayor? "Si" : "No")+"\n"+
                        "Toma?->"+(toma? "Si" : "No")+"\n"+
                        "Fuma?->"+(fuma? "Si" : "No")
                );
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.setNeutralButton("Cancel",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                //Creamos el mensaje y lo mostramos
                builder.show();
            }
        });
    }
}