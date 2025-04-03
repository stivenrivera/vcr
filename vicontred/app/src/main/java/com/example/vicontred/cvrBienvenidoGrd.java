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

public class cvrBienvenidoGrd extends AppCompatActivity {

    private ViewPager2 viewPager;
    private int[] images = { R.drawable.img1, R.drawable.img2, R.drawable.img3 };
    private Handler handler = new Handler();
    private Runnable runnable;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvr_bienvenido_grd);

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

        Button btnGrdTurno = findViewById(R.id.btnRegistroLocalizaciones);
        Button btnIngreso = findViewById(R.id.btnRegistroSeguridad);
        FloatingActionButton btnAlarma = findViewById(R.id.btnAlarma);

        btnGrdTurno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenidoGrd.this, CreaGdrTurno.class);
                startActivity(intent);
            }
        });

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cvrBienvenidoGrd.this, CreaRegsVstor.class);
                startActivity(intent);
            }
        });

        // Manejar clic en el botón flotante de alarma
        btnAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cvrBienvenidoGrd.this, "Se envía alarma a todos los usuarios", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
