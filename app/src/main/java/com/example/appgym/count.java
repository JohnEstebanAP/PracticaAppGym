package com.example.appgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.primerproyecto.R;

public class count extends AppCompatActivity {

    private Button btnIncrement, btnDecrement;
    private ImageButton btnSave, btnDelete;
    private TextView tvNum;
    private SharedPreferences prefer;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        prefer = getSharedPreferences("data", MODE_PRIVATE);
        editor = prefer.edit();

        MediaPlayer pop = MediaPlayer.create(this, R.raw.pop);

        btnDecrement = (Button) findViewById(R.id.btn_decrement);
        btnIncrement = (Button) findViewById(R.id.btn_increment);
        btnSave = (ImageButton) findViewById(R.id.btn_saved);
        btnDelete = (ImageButton) findViewById(R.id.btn_delete);

        tvNum = (TextView) findViewById(R.id.tv_num);

        btnIncrement.setOnClickListener(view -> {
            int count = 0;
            pop.start();
            String numero = (String) tvNum.getText();
            count = Integer.parseInt(tvNum.getText().toString());
            count++;

            //String result = String.valueOf(count);       //Pasar de tipo Int a String
            tvNum.setText(""+count);
        });

        btnDecrement.setOnClickListener(view -> {
            int count = 0;
            pop.start();
            String numero = (String) tvNum.getText();
            count = Integer.parseInt(tvNum.getText().toString());
            count--;
            tvNum.setText(""+count);

        });

        btnSave.setOnClickListener(view -> {
            pop.start();
            editor.putString("count", tvNum.getText().toString()); //guardamos el valor en el sharedPreferences
            editor.apply();
        });

        btnDelete.setOnClickListener(view -> {
            pop.start();
            editor.remove("count").apply(); //Limpiamos o borramos los valores guardados en el SharedPreferences de una key en espesifico
            //editor.clear().apply();  // para limpiar todos los valores del Shared Preferences.
        });


    }


    /*
    //Persistencia de datos en ejecucion, ejemplo cuando se boltea la app a horizontal y vertical para que no se pierdan los datos.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("count",tvNum.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvNum.setText(savedInstanceState.getString("count"));
    }
*/

    //Persistencia de datos con el  Ciclo de vida de la app
    @Override
    protected void onResume() {
        super.onResume();
        tvNum.setText(prefer.getString("count","0"));  //recuperamos el valor guadado en el sharedPreferencesindicundole su llave y un valor or defectoenc aso de no tener nada guadado ("count", 0);
    }

    /*
    @Override
    protected void onPause() {
        editor.putString("count", tvNum.getText().toString()); //guardamos el valor en el sharedPreferences
        editor.apply();
        super.onPause();
    }
     */

}