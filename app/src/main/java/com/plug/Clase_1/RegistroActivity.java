package com.plug.Clase_1;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by OSKAR on 23/06/2017.
 */

public class RegistroActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Definimos de que clase xml se va a tomar el diseño
        setContentView(R.layout.activity_registro);
    }
}
