package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreaBitaco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_bitaco);
    }


    public void execRegBitacora (View view)
    {
        //   Intent nextActivy = new Intent(this, UseryEmpra.class);
        //Intent nextActivy = new Intent(this, CreaSeguriMain.class);
        ///basefragmento  UseryEmpra
        //startActivity(nextActivy);
        // valida y graba
    }


    public void execClosBitacora (View view)
    {
        //   Intent nextActivy = new Intent(this, UseryEmpra.class);
        //Intent nextActivy = new Intent(this, CreaSeguriMain.class);
        ///basefragmento  UseryEmpra
        //startActivity(nextActivy);
        // valida y graba
    }

    public void nextActivityImpBitaco (View view)
    {
        //   Intent nextActivy = new Intent(this, UseryEmpra.class);
        Intent nextActivy = new Intent(this, CreaBitaco.class);
        ///basefragmento  UseryEmpra
        startActivity(nextActivy);
    }

}