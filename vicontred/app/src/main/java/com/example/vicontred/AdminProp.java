package com.example.vicontred;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminProp extends AppCompatActivity {

    private Button btnAdmin;
    private Button btnPropietario;
    private Button btnSeguridad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_prop);

        // Inicializar los botones
        btnAdmin = findViewById(R.id.btnAdmin);
        btnPropietario = findViewById(R.id.btnPropietario);
        btnSeguridad = findViewById(R.id.btnSeguridad);

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProp.this, cvrBienvenido.class);
                startActivity(intent);
            }
        });

        btnPropietario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProp.this, cvrBienvenidoUsr.class);
                startActivity(intent);
            }
        });

        btnSeguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminProp.this, cvrBienvenidoGrd.class);
                startActivity(intent);
            }
        });

    }

    // Método para abrir una pantalla específica
    private void abrirPantalla(Class<?> destino) {
        Intent intent = new Intent(AdminProp.this, destino);
        startActivity(intent);
    }
}
