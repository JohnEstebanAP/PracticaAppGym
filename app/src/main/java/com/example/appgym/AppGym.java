package com.example.appgym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.primerproyecto.PreviewActivity;
import com.example.primerproyecto.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AppGym extends AppCompatActivity {

    private MediaPlayer pop;
    private ImageButton btnPower, btnStrong, btnYoga, btnCardio, btnFitness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_gym);

        btnPower = findViewById(R.id.btn_power);
        btnStrong = findViewById(R.id.btn_strong);
        btnYoga = findViewById(R.id.btn_yoga);
        btnCardio = findViewById(R.id.btn_cardio);
        btnFitness = findViewById(R.id.btn_fitness);

        pop = MediaPlayer.create(this, R.raw.pop);

        btnPower.setOnClickListener(view -> {
            pop.start();
            startActivity(new Intent(this, PreviewActivity.class));
        });

        btnStrong.setOnClickListener(view -> {
            pop.start();
            startActivity(new Intent(this, PreviewActivity.class));
        });

        btnYoga.setOnClickListener(view -> {
            pop.start();
            startActivity(new Intent(this, PreviewActivity.class));
        });

        btnCardio.setOnClickListener(view -> {
            pop.start();
            startActivity(new Intent(this, PreviewActivity.class));
        });

        btnFitness.setOnClickListener(view -> {
            pop.start();
            startActivity(new Intent(this, PreviewActivity.class));
        });
    }

    //El metodo se ejecuta cadabes que precionamos el boton de atras.
    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
        new MaterialAlertDialogBuilder(this)
                .setTitle("EXIT")
                .setMessage("Decea salir de la app GYM")
                .setNegativeButton("Canselar", (dialogInterface, i) -> dialogInterface.cancel())
                .setPositiveButton("Salir", (dialogInterface, i) -> super.finishAndRemoveTask())
                .show();
    }

    //onCreateOptionsMuno nos ayuda a implementar el menu en este activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return  true;
    }

    //onOptionsItemSelected nos ayuda a controlar el evento de cuando se hace click en uno de los items del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       final int share = R.id.mn_share;
       final int count = R.id.mn_count;
       final int information = R.id.mn_information;
       final int configuration = R.id.mn_configuration;

       pop.start();
        switch (item.getItemId()){
            case share:
                Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
                return true;
            case count:
                Toast.makeText(this,"Count",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, count.class));
                return true;
            case information:
                Toast.makeText(this,"information",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Information.class));
                return true;
            case configuration:
                Toast.makeText(this,"configutation",Toast.LENGTH_SHORT).show();
                showInformation();
                return true;
            default:
                return false;
        }
    }

    private void showInformation(){
        new MaterialAlertDialogBuilder(this)
                .setTitle("Information")
                .setMessage("Version: 1.9 \n This information test GymSaturday Project")
                .setPositiveButton("ok", (dialogInterface, i) -> dialogInterface.cancel())
                .show();
    }
}