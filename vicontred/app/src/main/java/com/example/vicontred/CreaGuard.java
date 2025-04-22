package com.example.vicontred;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.content.Intent;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.example.vicontred.model.Guardia;
import com.example.vicontred.model.Equipo;
import com.example.vicontred.RetrofitInstance;
import android.util.Log;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.text.SimpleDateFormat;
import com.example.vicontred.SecurityUtils;
import android.location.Geocoder;
import android.location.Location;
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

import androidx.core.app.ActivityCompat;

public class CreaGuard extends AppCompatActivity {

    private CheckBox chbEstado;
    private EditText editcdgrd;
    private EditText editdni;
    private EditText editrmil;
    private EditText editapgrd;
    private EditText editapgrd2;
    private EditText editnmgrd;
    private EditText editnmgrd2;
    private EditText editfono1;
    private EditText editnace;
    private CheckBox chbLic;
    private CheckBox chbGuns;
    private EditText editdir;
    private EditText editfecini;
    private EditText editfecfin;
    private ListView lstGrd;
    private Button btnCrearGurd;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_guard);

        chbEstado = findViewById(R.id.chbEstado);
        editcdgrd = findViewById(R.id.editcdgrd);
        editdni = findViewById(R.id.editdni);
        editrmil = findViewById(R.id.editrmil);
        editapgrd = findViewById(R.id.editapgrd);
        editapgrd2 = findViewById(R.id.editapgrd2);
        editnmgrd = findViewById(R.id.editnmgrd);
        editnmgrd2 = findViewById(R.id.editnmgrd2);
        editfono1 = findViewById(R.id.editfono1);
        editnace = findViewById(R.id.editnace);
        chbLic = findViewById(R.id.chbLic);
        chbGuns = findViewById(R.id.chbGuns);
        editdir = findViewById(R.id.editdir);
        editfecini = findViewById(R.id.editfecini);
        editfecfin = findViewById(R.id.editfecfin);
        lstGrd = findViewById(R.id.lstGrd);
        btnCrearGurd = findViewById(R.id.btnCrearGurd);
        btnCancelar = findViewById(R.id.btnCancelar);
    }

    // Función para manejar la creación del guardia
    public void execRegGrdSgr(View view) {
        // Capturar valores desde los campos del formulario
        String codigoGuardia = editcdgrd.getText().toString().trim();
        String dni = editdni.getText().toString().trim();
        String recordMilitar = editrmil.getText().toString().trim();
        String primerApellido = editapgrd.getText().toString().trim();
        String segundoApellido = editapgrd2.getText().toString().trim();
        String primerNombre = editnmgrd.getText().toString().trim();
        String segundoNombre = editnmgrd2.getText().toString().trim();
        String telefono = editfono1.getText().toString().trim();
        String fechaNacimiento = editnace.getText().toString().trim();
        String correo = "";
        String regAuditoria = SecurityUtils.generarIndiceEncriptado();
        ;

        if (dni.isEmpty() || primerNombre.isEmpty() || primerApellido.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Los campos obligatorios no pueden estar vacíos",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Guardia guardia = new Guardia(
                dni,
                primerApellido,
                segundoApellido,
                primerNombre,
                segundoNombre,
                telefono,
                fechaNacimiento,
                codigoGuardia,
                recordMilitar,
                regAuditoria,
                correo);

        Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
        ApiService apiService = retrofit.create(ApiService.class);
        Map<String, String> datosEquipo = DeviceInfo.obtenerDatosDelDispositivo(CreaGuard.this);
        Call<Guardia> call = apiService.registrarGuardia(guardia);
        call.enqueue(new Callback<Guardia>() {
            @Override
            public void onResponse(Call<Guardia> call, Response<Guardia> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Guardia registrado exitosamente", Toast.LENGTH_SHORT)
                            .show();
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
                    Intent intent = new Intent(CreaGuard.this, CreaTurno.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Guardia> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fallo en la conexión", Toast.LENGTH_SHORT).show();
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

    public void nextActivityCreaTurno(View view) {
        Intent nextActivity = new Intent(this, CreaTurno.class);
        startActivity(nextActivity);
    }
}
