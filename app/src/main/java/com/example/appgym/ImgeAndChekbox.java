package com.example.appgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.primerproyecto.R;

public class ImgeAndChekbox extends AppCompatActivity {

    public CheckBox checkBox;
    public ImageView imageView;

    public Button btnContinuarMilu;
    public Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imge_and_chekbox);

        checkBox = (CheckBox)findViewById(R.id.checkBox);
        imageView = (ImageView)findViewById(R.id.imageView);
        btnContinuarMilu = (Button)findViewById(R.id.btnContinuarMilu);
        checkBox.setOnClickListener(View ->{
            if(checkBox.isChecked()){
                imageView.setImageResource(R.drawable.milu);
            }else{
                imageView.setImageResource(R.drawable.corazon);
            }
        });


        btnContinuarMilu.setOnClickListener( View ->{
            intent = new Intent(this, AppGym.class);
            startActivity(intent);
        });
    }
}