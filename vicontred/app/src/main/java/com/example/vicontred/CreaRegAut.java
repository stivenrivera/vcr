package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Handler;

public class CreaRegAut extends AppCompatActivity {

    private ViewPager2 viewPager;
    private int[] images = { R.drawable.img1, R.drawable.img2, R.drawable.img3 };
    private Handler handler = new Handler();
    private Runnable runnable;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_reg_aut);

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
    }

    public void execRegCoPropietario(View view) {
        // Intent nextActivy = new Intent(this, UseryEmpra.class);
        // Intent nextActivy = new Intent(this, CreaSeguriMain.class);
        /// basefragmento UseryEmpra
        // startActivity(nextActivy);
        // valida y graba
    }

    public void execCreaIngPerma(View view) {
        // Intent nextActivy = new Intent(this, UseryEmpra.class);
        // Intent nextActivy = new Intent(this, CreaSeguriMain.class);
        /// basefragmento UseryEmpra
        // startActivity(nextActivy);
        // valida y graba
    }

}