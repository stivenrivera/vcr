package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MacroLotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macro_lotes);
    }

    public void nextActivityEmp (View view)
    {
        Intent nextActivy = new Intent(this, MainActivity.class);
        startActivity(nextActivy);
    }

}