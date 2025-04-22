package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.vicontred.RetrofitInstance;
import android.content.Intent;
import com.example.vicontred.model.Seguridad;
import com.example.vicontred.model.Equipo;
import java.util.List;
import java.util.Locale;
import com.example.vicontred.model.Auditoria;
import android.location.LocationManager;
import android.content.Context;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import androidx.core.app.ActivityCompat;
import java.util.Map;

public class CreaSeguriMain extends AppCompatActivity {

    // Declaración de variables para los componentes de la interfaz
    private EditText editDni, editNombreComercial, editRazonSocial, editRepresentanteLegal;
    private EditText editDireccion, editMail, editTelefonos, editSupervisor, editTelSeguridad;
    private CheckBox chbEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_seguri_main);

        // Enlazar los elementos de la vista con sus IDs
        editDni = findViewById(R.id.editdni);
        editNombreComercial = findViewById(R.id.editnmcomer);
        editRazonSocial = findViewById(R.id.editemseg);
        editRepresentanteLegal = findViewById(R.id.editnadm);
        editDireccion = findViewById(R.id.editdirem);
        editMail = findViewById(R.id.editmail);
        editTelefonos = findViewById(R.id.editncell);
        editSupervisor = findViewById(R.id.editSuper);
        editTelSeguridad = findViewById(R.id.editelfseg);
        chbEstado = findViewById(R.id.chbEstado);

    }

    public void execRegEmpSeg(View view) {
        // Obtener los valores desde los campos
        String regAuditoria = SecurityUtils.generarIndiceEncriptado();
        String dni = editDni.getText().toString();
        Seguridad seguridad = new Seguridad();
        seguridad.setDni(editDni.getText().toString());
        seguridad.setNombreComercial(editNombreComercial.getText().toString());
        seguridad.setRazonSocial(editRazonSocial.getText().toString());
        seguridad.setRepresentanteLegal(editRepresentanteLegal.getText().toString());
        seguridad.setDireccion(editDireccion.getText().toString());
        seguridad.setCorreo(editMail.getText().toString());
        seguridad.setTelefono(editTelefonos.getText().toString());
        seguridad.setSupervisor(editSupervisor.getText().toString());
        seguridad.setTelefonoSeguridad(editTelSeguridad.getText().toString());
        seguridad.setRegAuditoria(regAuditoria);

        Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
        ApiService apiService = retrofit.create(ApiService.class);
        Map<String, String> datosEquipo = DeviceInfo.obtenerDatosDelDispositivo(CreaSeguriMain.this);
        Call<Seguridad> call = apiService.registrarSeguridad(seguridad);
        call.enqueue(new Callback<Seguridad>() {
            @Override
            public void onResponse(Call<Seguridad> call, Response<Seguridad> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CreaSeguriMain.this, "Registrado correctamente", Toast.LENGTH_LONG).show();
                    String fecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    String hora = new SimpleDateFormat("HH:mm:ss").format(new Date());
                    String pais = obtenerPais();
                    String equipo = datosEquipo.get("modelo");
                    String usuario = dni;
                    String token = "TOKEN_GENERADO";

                    Auditoria nuevaAuditoria = new Auditoria(fecha, hora, pais, usuario, equipo, token, regAuditoria);
                    Call<Auditoria> callAuditoria = apiService.registrarAuditoria(nuevaAuditoria);
                    callAuditoria.enqueue(new Callback<Auditoria>() {
                        @Override
                        public void onResponse(Call<Auditoria> call, Response<Auditoria> response) {
                            if (response.isSuccessful()) {
                                Log.d("AUDITORIA", "Auditoría registrada correctamente");
                            } else {
                                Log.e("AUDITORIA", "Error al registrar auditoría: " + response.code());
                            }
                        }

                        @Override
                        public void onFailure(Call<Auditoria> call, Throwable t) {
                            Log.e("AUDITORIA", "Fallo al registrar auditoría: " + t.getMessage());
                        }
                    });
                } else {
                    Toast.makeText(CreaSeguriMain.this, "Error al registrar", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Seguridad> call, Throwable t) {
                Toast.makeText(CreaSeguriMain.this, "Fallo de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private String obtenerPais() {
        String pais = "Desconocido";

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (location != null) {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                try {
                    List<Address> addresses = geocoder.getFromLocation(
                            location.getLatitude(),
                            location.getLongitude(),
                            1);

                    if (addresses != null && !addresses.isEmpty()) {
                        pais = addresses.get(0).getCountryName();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Log.w("PAIS", "Ubicación no encontrada");
            }
        } else {
            Log.w("PAIS", "Permisos de ubicación no concedidos");
        }

        return pais;
    }

    public void nextActivityCreaSeg(View view) {
        Intent nextActivy = new Intent(this, CreaGuard.class);
        startActivity(nextActivy);
    }
}
