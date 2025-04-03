package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class cvrempresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvrempresa);
    }

    public void nextActivityEmp (View view)
    {
        Intent nextActivy = new Intent(this, MacroLotes.class);
        startActivity(nextActivy);
    }

}