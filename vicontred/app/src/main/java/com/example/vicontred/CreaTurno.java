package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreaTurno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_turno);
    }

    public void execRegTurn (View view)
    {
        //   Intent nextActivy = new Intent(this, UseryEmpra.class);
        //Intent nextActivy = new Intent(this, CreaSeguriMain.class);
        ///basefragmento  UseryEmpra
        //startActivity(nextActivy);
        // valida y graba
    }

    public void execNewCode (View view)
    {
        //   Intent nextActivy = new Intent(this, UseryEmpra.class);
        //Intent nextActivy = new Intent(this, CreaSeguriMain.class);
        ///basefragmento  UseryEmpra
        //startActivity(nextActivy);
        // valida y graba
    }

    public void nextActivityCreaGrTurno (View view)
    {
        //   Intent nextActivy = new Intent(this, UseryEmpra.class);
        Intent nextActivy = new Intent(this, CreaGdrTurno.class);
        ///basefragmento  UseryEmpra
        startActivity(nextActivy);
    }

}