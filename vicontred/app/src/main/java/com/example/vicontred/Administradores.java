package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Administradores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administradores);
    }

    public void nextActivityAD (View view)
    {
        Intent nextActivy = new Intent(this, cvrempresa.class);
        startActivity(nextActivy);
    }

}