package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreaEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_empresa);
    }

    public void execRegEmp(View view) {
        // Intent nextActivy = new Intent(this, UseryEmpra.class);
        Intent nextActivy = new Intent(this, cvrBienvenido.class);
        /// basefragmento UseryEmpra
        startActivity(nextActivy);
        // aqui validacion de datos y grabar
    }

    public void nextActivityCreaLoc(View view) {
        // Intent nextActivy = new Intent(this, UseryEmpra.class);
        Intent nextActivy = new Intent(this, CreaLocaliz.class);
        /// basefragmento UseryEmpra
        startActivity(nextActivy);
    }

}