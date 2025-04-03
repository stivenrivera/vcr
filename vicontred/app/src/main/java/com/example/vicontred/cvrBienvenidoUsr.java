package com.example.vicontred;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class cvrBienvenidoUsr extends AppCompatActivity {

    private ViewPager2 viewPager;
    private int[] images = { R.drawable.img1, R.drawable.img2, R.drawable.img3 };
    private Handler handler = new Handler();
    private Runnable runnable;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvr_bienvenido_usr);

        // Configurar el ViewPager2
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ImageAdapter(this, images));

        // Configurar carrusel automático
        runnable = new Runnable() {
            @Override
            public void run() {
                if (currentIndex >= images.length) {
                    currentIndex = 0;
                }
                viewPager.setCurrentItem(currentIndex, true);
                currentIndex++;
                handler.postDelayed(this, 3000); // Cambia cada 3 segundos
            }
        };
        handler.postDelayed(runnable, 3000);
        Button btnIngPerm = findViewById(R.id.btnRegistroLocalizaciones);
        Button btnAutIngreso = findViewById(R.id.btnRegistroSeguridad);
        Button btnAutResidentes = findViewById(R.id.btnRegistroPropietarios);
        FloatingActionButton btnAlarma = findViewById(R.id.btnAlarma);

        btnIngPerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenidoUsr.this, CreaIngPerma.class);
                startActivity(intent);
            }
        });

        btnAutIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenidoUsr.this, CreaRegsVstor.class);
                startActivity(intent);
            }
        });

        btnAutResidentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenidoUsr.this, CreaRegAut.class);
                startActivity(intent);
            }
        });

        btnAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cvrBienvenidoUsr.this, "Se envia alarma al Guardia de Turno", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
