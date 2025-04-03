package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UseryEmpra extends AppCompatActivity {
    FragmentTransaction transaction;
    Fragment fragCreaEmpresa, fragCreaAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usery_empra);

        fragCreaEmpresa = new fragEmpresa();
        fragCreaAdmin = new fragmUser();
        getSupportFragmentManager().beginTransaction().commit();
    }

/*    public void onClick(View view){
        switch (view.getId()){
            case R.id.btCAdmin:
            break;
            case R.id.btCEmpr:
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
*/
    // pasar a otro activity
  /*  public void nextActivityUsEmp (View view)
    {
        Intent nextActivy = new Intent(this, Administradores.class);
        startActivity(nextActivy);
    }
*/
    public void OnClick (View view){
        transaction=getSupportFragmentManager().beginTransaction();
        switch (view.getId())
        {
            case R.id.btCAdmin:
                transaction.replace(R.id.fragmUser,fragCreaAdmin).commit();
                break;  
            case R.id.btCEmpr:   transaction.replace(R.id.fragEmpresa,fragCreaEmpresa).commit();
                break;
        }
    }

    /*


    }

     */

}