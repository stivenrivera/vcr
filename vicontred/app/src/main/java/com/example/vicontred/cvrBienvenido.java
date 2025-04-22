package com.example.vicontred;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class cvrBienvenido extends AppCompatActivity {

    private ViewPager2 viewPager;
    private int[] images = { R.drawable.img4, R.drawable.img5, R.drawable.img6 };
    private Handler handler = new Handler();
    private Runnable runnable;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvr_bienvenido);

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
        Button btnLocalizaciones = findViewById(R.id.btnRegistroLocalizaciones);
        Button btnSeguridad = findViewById(R.id.btnRegistroSeguridad);
        Button btnPropietarios = findViewById(R.id.btnRegistroPropietarios);
        Button btnSeguridadTurno = findViewById(R.id.btnGuardiasTurno);
        Button btnRegistroGuardiaSeguridad = findViewById(R.id.btnRegistroGuardiaSeguridad);
        Button btnCrearNofi = findViewById(R.id.btnCrearNofi);

        btnLocalizaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenido.this, CreaLocaliz.class);
                startActivity(intent);
            }
        });

        btnSeguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenido.this, CreaSeguriMain.class);
                startActivity(intent);
            }
        });

        btnSeguridadTurno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenido.this, CreaGdrTurno.class);
                startActivity(intent);
            }
        });

        btnPropietarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenido.this, CreaRegPropi.class);
                startActivity(intent);
            }
        });

        btnRegistroGuardiaSeguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenido.this, CreaGuard.class);
                startActivity(intent);
            }
        });

        btnCrearNofi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenido.this, CreaNotific.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
