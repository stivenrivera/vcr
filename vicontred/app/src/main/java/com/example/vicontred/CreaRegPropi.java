package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vicontred.model.Localizacion;
import com.example.vicontred.model.Propietario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreaRegPropi extends AppCompatActivity {

    EditText editDni, editNm1Prop, editNm2Prop, editAp1Pro, editAp2Pro;
    EditText editNcell, editMail, editDirem;
    Spinner spnLocali;
    CheckBox chbNotif, chbBitac, chbEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_reg_propi);

        // Inicializar campos del formulario
        editDni = findViewById(R.id.editdni);
        editNm1Prop = findViewById(R.id.editnm1prop);
        editNm2Prop = findViewById(R.id.editnm2prop);
        editAp1Pro = findViewById(R.id.editap1pro);
        editAp2Pro = findViewById(R.id.editap2pro);
        editNcell = findViewById(R.id.editncell);
        editMail = findViewById(R.id.editmail);
        editDirem = findViewById(R.id.editdirem);

        spnLocali = findViewById(R.id.spnLocali);

        chbNotif = findViewById(R.id.chbNotif);
        chbBitac = findViewById(R.id.chbBitac);
        chbEstado = findViewById(R.id.chbEstado);

        // Cargar localizaciones al spinner
        cargarLocalizaciones();
    }

    private void cargarLocalizaciones() {
        ApiService apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        Call<List<Localizacion>> call = apiService.getLocalizaciones();

        call.enqueue(new Callback<List<Localizacion>>() {
            @Override
            public void onResponse(Call<List<Localizacion>> call, Response<List<Localizacion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Localizacion> localizaciones = response.body();

                    // Crear adaptador con las localizaciones (se mostrará lo que retorna
                    // toString())
                    ArrayAdapter<Localizacion> adapter = new ArrayAdapter<>(
                            CreaRegPropi.this,
                            android.R.layout.simple_spinner_item,
                            localizaciones);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnLocali.setAdapter(adapter);
                } else {
                    Toast.makeText(CreaRegPropi.this, "Error al obtener localizaciones", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Localizacion>> call, Throwable t) {
                Toast.makeText(CreaRegPropi.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void execRegPropietario(View view) {
        // Capturar los datos del formulario
        String dni = editDni.getText().toString();
        String primerNombre = editNm1Prop.getText().toString();
        String segundoNombre = editNm2Prop.getText().toString();
        String primerApellido = editAp1Pro.getText().toString();
        String segundoApellido = editAp2Pro.getText().toString();
        String telefono = editNcell.getText().toString();
        String mail = editMail.getText().toString();
        String direccion = editDirem.getText().toString();

        // Obtener la localización seleccionada
        Localizacion localizacionSeleccionada = (Localizacion) spnLocali.getSelectedItem();
        String matriz = localizacionSeleccionada.getMatriz();
        String localizacion = localizacionSeleccionada.getLocalizacion();

        String localizacionConcatenada = matriz + ": " + localizacion;

        // Crear el objeto Propietario
        Propietario propietario = new Propietario(dni, primerNombre, segundoNombre,
                primerApellido, segundoApellido,
                localizacionConcatenada, telefono, mail, direccion);

        // Enviar el propietario a la API para registrarlo
        ApiService apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        Call<Propietario> call = apiService.registrarPropietario(propietario);

        call.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CreaRegPropi.this, "Propietario registrado exitosamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreaRegPropi.this, "Error al registrar propietario", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(CreaRegPropi.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void execCreaResidentes(View view) {
        finish();
    }
}
