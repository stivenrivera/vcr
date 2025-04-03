package com.example.vicontred;

import java.sql.Connection;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vicontred.ImageAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private int[] images = { R.drawable.img4, R.drawable.img5, R.drawable.img6 };
    private Handler handler = new Handler();
    private Runnable runnable;
    private int currentIndex = 0;

    TextView CreaRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inicializar el ViewPager2 para el banner
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

        // Inicializar elementos de la UI
        CreaRegistro = findViewById(R.id.txtCrearRegistro);

        // Evento click para cambiar de pantalla
        CreaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(MainActivity.this, "aa", Toast.LENGTH_LONG).show();
                    Intent registro = new Intent(MainActivity.this, CreaAdmin.class);
                    startActivity(registro);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                } finally {
                    Toast.makeText(MainActivity.this, "ee", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Detener el carrusel al cerrar la actividad
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    // Método para ir a otra actividad
    public void nextActivityMain(View view) {
        Intent nextActivy = new Intent(this, CreaAdmin.class);
        startActivity(nextActivy);
    }

    public void bienvenido(View view) {
        Intent nextActivy = new Intent(this, AdminProp.class);
        startActivity(nextActivy);
    }

}
