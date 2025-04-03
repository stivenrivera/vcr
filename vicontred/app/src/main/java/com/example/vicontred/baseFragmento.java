package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class baseFragmento extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragCreaEmpresa, fragCreaAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_fragmento);

        fragCreaEmpresa = new fragEmpresa();
        fragCreaAdmin = new fragmUser();
        getSupportFragmentManager().beginTransaction().commit();
    }

    public void OnClick (View view){
        transaction=getSupportFragmentManager().beginTransaction();
       switch (view.getId())
       {
           case R.id.btCAdmin:
               transaction.replace(R.id.fragmUser,fragCreaAdmin).commit();
             break;
           case R.id.btCEmpr:
               transaction.replace(R.id.fragEmpresa,fragCreaEmpresa).commit();
             break;
       }
    }
}