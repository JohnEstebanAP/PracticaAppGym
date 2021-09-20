package com.example.appgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.primerproyecto.R;

public class HomeActivity extends AppCompatActivity {

    public WebView web;
    public Button btnContinuar;
    public Intent intent;
    public String outputUser;
    public TextView txtNombreUsr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        outputUser = getIntent().getStringExtra("user");
        web = (WebView)findViewById(R.id.webView);
        btnContinuar= (Button)findViewById(R.id.btnContinuar);
        txtNombreUsr= (TextView)findViewById(R.id.txt_nombre_urs);

        txtNombreUsr.setText(outputUser);
        web.loadUrl("https://www.pinterest.com.mx/pin/623748617131510367/");

        btnContinuar.setOnClickListener( View ->{
            intent = new Intent(this, ImgeAndChekbox.class);
            startActivity(intent);
        });
    }
}