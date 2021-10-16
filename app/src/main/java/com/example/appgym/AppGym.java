package com.example.appgym;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.example.appgym.fragments.CameraFragment;
import com.example.appgym.fragments.ContactFragment;
import com.example.appgym.fragments.HomeFragment;
import com.example.appgym.fragments.NutritionFragment;
import com.example.primerproyecto.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AppGym extends AppCompatActivity {

    private MediaPlayer pop;
    private MaterialToolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_gym);

        pop = MediaPlayer.create(this, R.raw.pop);

        toolbar = findViewById(R.id.topAppBar);
        toolbar.setOnMenuItemClickListener(item -> {
            final int share = R.id.mn_share;
            final int count = R.id.mn_count;
            final int information = R.id.mn_information;
            final int configuration = R.id.mn_configuration;

            pop.start();
            switch (item.getItemId()){
                case share:
                    shareApp();
                    Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
                    return true;
                case count:
                    Toast.makeText(this,"Count", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, count.class));
                    return true;
                case information:
                    Toast.makeText(this,"information",Toast.LENGTH_SHORT).show();
                    showInformation();
                    return true;
                case configuration:
                    Toast.makeText(this,"configutation",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, Information.class));
                    return true;
                default:
                    return false;
            }
        });

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(item ->{
            final int HOME = R.id.nb_home;
            final int NUTRITION = R.id.nb_nutrition;
            final int CAMERA = R.id.nb_camera;
            final int CONTACT = R.id.nb_contact;
            switch (item.getItemId()){
                case HOME:
                    showFragmentHome();
                    return true;
                case NUTRITION:
                    showFragmentNutrition();
                    return true;
                case CAMERA:
                    showFragmentCamera();
                    return true;
                case CONTACT:
                    showFragmentContact();
                    return true;
                default:
                    return false;
            }
        });

        showFragmentHome();
    }

    private void showFragmentHome(){
        toolbar.setTitle(R.string.home);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new HomeFragment())
                .setReorderingAllowed(true).addToBackStack(null)
                .commit();
    }
    private void showFragmentNutrition(){
        toolbar.setTitle(R.string.title_nutrition);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new NutritionFragment())
                .setReorderingAllowed(true).addToBackStack(null)
                .commit();
    }
    private void showFragmentCamera(){
        toolbar.setTitle(R.string.title_camera);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new CameraFragment())
                .setReorderingAllowed(true).addToBackStack(null)
                .commit();
    }
    private void showFragmentContact(){
        toolbar.setTitle(R.string.title_contact);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new ContactFragment())
                .setReorderingAllowed(true).addToBackStack(null)
                .commit();
    }

//Compartir la aplicacion con redes  sociales o gmail.
    private void shareApp(){
        String url = "https://play.google.com/store/apps/details?id=vcstudio.com.vcedmgr_f&hl=en_US&gl=US";
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, url);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
/*
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
    }*/
    private void showInformation(){
        new MaterialAlertDialogBuilder(this)
                .setTitle("Information")
                .setMessage("Version: 1.9 \n This information test GymSaturday Project")
                .setPositiveButton("ok", (dialogInterface, i) -> dialogInterface.cancel())
                .show();
    }

/*
    //onCreateOptionsMuno nos ayuda a implementar el menu en este activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return  true;
    }
*/
    /*
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
                showInformation();
                return true;
            case configuration:
                Toast.makeText(this,"configutation",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Information.class));
                return true;
            default:
                return false;
        }
    }
*/


}