package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.example.vicontred.model.Empresa;
import com.example.vicontred.RetrofitInstance;
import java.io.IOException;

public class CreaEmpresa extends AppCompatActivity {

    // Definir los campos que contienen los IDs
    private EditText editempre, editdirem, editmail, editncell, editdni, editnadm, editndirect, editdnidirec,
            editdnitel;
    private TextView editnadmText;
    private Button btnCrearEmpresa, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_empresa);

        // Inicializar los elementos con los IDs definidos en el XML
        editempre = findViewById(R.id.editempre);
        editdirem = findViewById(R.id.editdirem);
        editmail = findViewById(R.id.editmail);
        editncell = findViewById(R.id.editncell);
        editdni = findViewById(R.id.editdni);
        editnadm = findViewById(R.id.editnadm);
        editndirect = findViewById(R.id.editndirect);
        editdnidirec = findViewById(R.id.editdnidirec);
        editdnitel = findViewById(R.id.editdnitel);
        editnadmText = findViewById(R.id.editnadm);

        btnCrearEmpresa = findViewById(R.id.btnCrearEmpresa);
        btnCancelar = findViewById(R.id.btnCancelar);
    }

    public void execRegEmp(View view) {
        // Aquí puedes obtener los datos de los campos y hacer la validación
        String empresa = editempre.getText().toString();
        String direccion = editdirem.getText().toString();
        String email = editmail.getText().toString();
        String telefono = editncell.getText().toString();
        String dni = editdni.getText().toString();
        String director = editndirect.getText().toString();
        String dniDirector = editdnidirec.getText().toString();
        String telfDirector = editdnitel.getText().toString();

        if (empresa.isEmpty() || direccion.isEmpty() || email.isEmpty() || telefono.isEmpty() || dni.isEmpty() ||
                director.isEmpty() || dniDirector.isEmpty() || telfDirector.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        Empresa empresaObj = new Empresa();
        empresaObj.setNombre(empresa);
        empresaObj.setDireccion(direccion);
        empresaObj.setCorreo(email);
        empresaObj.setCelular(telefono);
        empresaObj.setDni(dni);
        empresaObj.setDirector(director);
        empresaObj.setDniDirector(dniDirector);
        empresaObj.setTelefonoDirecto(telfDirector);

        // Enviar los datos al backend usando Retrofit
        Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.registrarEmpresa(empresaObj).enqueue(new Callback<Empresa>() {
            @Override
            public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                if (response.isSuccessful()) {
                    // Empresa registrada exitosamente
                    Empresa empresaRegistrada = response.body();
                    Toast.makeText(getApplicationContext(), "Empresa registrada: " + empresaRegistrada.getNombre(),
                            Toast.LENGTH_SHORT).show();

                    // Iniciar la siguiente actividad
                    Intent nextActivy = new Intent(CreaEmpresa.this, cvrBienvenido.class);
                    startActivity(nextActivy);
                } else {
                    // Error en la respuesta de la API
                    String errorMessage = "Error desconocido";
                    try {
                        if (response.errorBody() != null) {
                            errorMessage = response.errorBody().string(); // Obtén más detalles del error
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(getApplicationContext(), "Error al registrar la empresa: " + errorMessage,
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Empresa> call, Throwable t) {
                // Error en la conexión
                Toast.makeText(getApplicationContext(), "Fallo la conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void nextActivityCreaLoc(View view) {
        // Iniciar la actividad de creación de localización
        Intent nextActivy = new Intent(this, CreaLocaliz.class);
        startActivity(nextActivy);
    }
}
