package com.example.appgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primerproyecto.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class LoginActivity extends AppCompatActivity {
    private EditText user, psw;
    private String inputUser, inputPsw;
    public Button btnLogin;
    public Button btnClose;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.edtNameLogin);
        psw = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.btnlogin);
        btnClose = findViewById(R.id.btnExit);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                login();
            }
        });
        btnClose.setOnClickListener(View ->{
            super.finish(); // para finalisr mi activadad
            //super.finishAffinity();//Serar la aplicacion completa
            //super.finishAndRemoveTask();//finalisar la actividad y remover e la vasurera para que no quede abierta en segundo plano
        });
    }

    private void login(){
        inputUser = user.getText().toString();
        inputPsw = psw.getText().toString();
        if(inputUser.isEmpty()){
            Toast.makeText(LoginActivity.this, "Ingrese El usuario", Toast.LENGTH_SHORT).show();
        }else if(inputPsw.isEmpty()){
            Toast.makeText(LoginActivity.this, "Ingrese La Contraseña", Toast.LENGTH_SHORT).show();
        }else if(inputPsw.length() <= 3){
            Toast.makeText(LoginActivity.this, "La contraseña deve tener mas de 3 caracteres", Toast.LENGTH_SHORT).show();
        }else{
            intent = new Intent(this, HomeActivity.class);
            Toast.makeText(LoginActivity.this, "Bienvenido " + inputUser, Toast.LENGTH_SHORT).show();
            intent.putExtra("user",inputUser);
            startActivity(intent);
        }
    }

    public void close(){
        String title = getString(R.string.title_exit_alert);
        String message = getString(R.string.message_exit_alert);
        String btnNegative = getString(R.string.negative_exit_alert);
        String btnPositive = getString(R.string.positive_exit_alert);

        new MaterialAlertDialogBuilder(this)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(btnNegative, (dialogInterface, i) -> dialogInterface.cancel())
                .setPositiveButton(btnPositive, (dialogInterface, i) -> super.finishAndRemoveTask())
                .show();
    }
    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/ //metodo por defecto
       //Sobrecarga del metodo
        close();
    }
}