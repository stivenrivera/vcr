package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.AdapterView;
import com.example.vicontred.RetrofitInstance;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.example.vicontred.model.Localizacion;

public class CreaLocaliz extends AppCompatActivity {

    private EditText editcdlocali;
    private Spinner spinnerLocalMatriz;
    private CheckBox chbMatriz;
    private Button btnCrearSitio;
    private ArrayAdapter<String> adapter;
    private List<String> listMatriz = new ArrayList<>();
    private EditText editnmlocali;
    private ListView lstLocaliView;
    private ArrayAdapter<String> listAdapter;

    private Map<String, List<String>> mapaMatrizConHijos = new LinkedHashMap<>();
    private List<String> listaVisible = new ArrayList<>();
    private Map<String, Boolean> matrizEstado = new LinkedHashMap<>(); // Para controlar si los hijos están visibles

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_localiz);

        editcdlocali = findViewById(R.id.editcdlocali);
        spinnerLocalMatriz = findViewById(R.id.spinnerLocalMatriz);
        chbMatriz = findViewById(R.id.chbMatriz);
        btnCrearSitio = findViewById(R.id.btnCrearSitio);
        editnmlocali = findViewById(R.id.editnmlocali);
        lstLocaliView = findViewById(R.id.lstLocali);

        Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
        ApiService apiService = retrofit.create(ApiService.class);

        // Adaptadores
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listMatriz);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocalMatriz.setAdapter(adapter);

        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaVisible);
        lstLocaliView.setAdapter(listAdapter);

        btnCrearSitio.setOnClickListener(v -> {
            String nombreLocal = editcdlocali.getText().toString().trim();

            if (!nombreLocal.isEmpty()) {
                if (chbMatriz.isChecked()) {
                    // Agrega matriz
                    listMatriz.add(nombreLocal);
                    adapter.notifyDataSetChanged();

                    mapaMatrizConHijos.put(nombreLocal, new ArrayList<>());
                    listaVisible.add(nombreLocal);
                    matrizEstado.put(nombreLocal, false); // Inicialmente, los hijos están ocultos
                    listAdapter.notifyDataSetChanged();

                } else {
                    // Agrega hijo
                    String matrizSeleccionada = spinnerLocalMatriz.getSelectedItem() != null
                            ? spinnerLocalMatriz.getSelectedItem().toString()
                            : "";

                    if (!matrizSeleccionada.isEmpty()) {
                        mapaMatrizConHijos.get(matrizSeleccionada).add("  ↳ " + nombreLocal);

                        // Agregar el hijo, pero solo si la matriz está visible
                        if (matrizEstado.get(matrizSeleccionada)) {
                            int matrizIndex = listaVisible.indexOf(matrizSeleccionada);
                            if (matrizIndex != -1) {
                                listaVisible.add(matrizIndex + mapaMatrizConHijos.get(matrizSeleccionada).size(),
                                        "  ↳ " + nombreLocal);
                                listAdapter.notifyDataSetChanged();
                            }
                        }
                        // Llamada a la API
                        Localizacion nuevaLoc = new Localizacion(matrizSeleccionada, nombreLocal);
                        Call<Localizacion> call = apiService.registrarLocalizacion(nuevaLoc);
                        call.enqueue(new Callback<Localizacion>() {
                            @Override
                            public void onResponse(Call<Localizacion> call, Response<Localizacion> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(CreaLocaliz.this, "Localización guardada correctamente",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(CreaLocaliz.this, "Error al guardar: " + response.code(),
                                            Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Localizacion> call, Throwable t) {
                                Toast.makeText(CreaLocaliz.this, "Error de red: " + t.getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }
                        });
                    } else {
                        Toast.makeText(this, "Selecciona una matriz primero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                Toast.makeText(this, "Sitio creado: " + nombreLocal, Toast.LENGTH_SHORT).show();
                editcdlocali.setText("");
                editnmlocali.setText("");
            } else {
                Toast.makeText(this, "Escribe el nombre del local", Toast.LENGTH_SHORT).show();
            }
        });

        lstLocaliView.setOnItemClickListener((parent, view, position, id) -> {
            String seleccionado = listaVisible.get(position);
            if (mapaMatrizConHijos.containsKey(seleccionado)) {
                List<String> hijos = mapaMatrizConHijos.get(seleccionado);

                // Verificamos si los hijos están visibles o no
                if (matrizEstado.get(seleccionado)) {
                    // Si los hijos están visibles, los ocultamos
                    listaVisible.removeAll(hijos);
                    matrizEstado.put(seleccionado, false); // Cambiar el estado a oculto
                } else {
                    // Si los hijos no están visibles, los mostramos
                    listaVisible.addAll(position + 1, hijos);
                    matrizEstado.put(seleccionado, true); // Cambiar el estado a visible
                }

                listAdapter.notifyDataSetChanged();
            }
        });
    }

    public void execRegLoc(View view) {
        // Para acciones futuras
    }

    public void nextActivityCreaSeg(View view) {
        Intent nextActivy = new Intent(this, CreaSeguriMain.class);
        startActivity(nextActivy);
    }
}
