package com.example.vicontred;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import com.example.vicontred.model.User;
import com.example.vicontred.model.Administrador;
import com.example.vicontred.model.Equipo;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.text.SimpleDateFormat;
import com.example.vicontred.model.Password;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreaAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_admin);

        Toast.makeText(CreaAdmin.this, "en crear", Toast.LENGTH_LONG).show();

        final EditText lceditdni = findViewById(R.id.editdni);
        final EditText lcedituser = findViewById(R.id.edituser);
        final EditText lceditpass = findViewById(R.id.editpass);
        final EditText lceditcpass = findViewById(R.id.editcpass);
        final EditText lceditnm1user = findViewById(R.id.editnm1user);
        final EditText lceditnm2user = findViewById(R.id.editnm2user);
        final EditText lceditapell1 = findViewById(R.id.editapell1);
        final EditText lceditapell2 = findViewById(R.id.editapell2);
        final EditText lceditmail = findViewById(R.id.editmail);
        final EditText lceditncell = findViewById(R.id.editncell);
        final CheckBox lcchbAdmin = findViewById(R.id.chbAdmin);

        Button lcbtnCreaRegistro = findViewById(R.id.btnCreaRegistro);

        lcbtnCreaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = lceditdni.getText().toString();
                String user = lcedituser.getText().toString();
                String pass = lceditpass.getText().toString();
                String cpass = lceditcpass.getText().toString();
                String nm1user = lceditnm1user.getText().toString();
                String nm2user = lceditnm2user.getText().toString();
                String apell1 = lceditapell1.getText().toString();
                String apell2 = lceditapell2.getText().toString();
                String email = lceditmail.getText().toString();
                String cell = lceditncell.getText().toString();
                boolean esAdmin = lcchbAdmin.isChecked();

                // Validación de datos
                if (!user.isEmpty() && !pass.isEmpty() && pass.equals(cpass) && !dni.isEmpty() && !nm1user.isEmpty()
                        && !apell1.isEmpty()) {
                    // Crear un objeto User
                    User nuevoUsuario = new User(user, pass);
                    Log.d("DEBUG", "Username: " + user);
                    // Configurar Retrofit
                    Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
                    ApiService apiService = retrofit.create(ApiService.class);

                    Call<User> callUser = apiService.crearUsuario(nuevoUsuario);
                    callUser.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                User usuarioCreado = response.body();
                                Toast.makeText(CreaAdmin.this, "Usuario creado con éxito", Toast.LENGTH_SHORT).show();

                                // 👉 REGISTRAR PASSWORD
                                Password nuevaPassword = new Password(pass, usuarioCreado);
                                Call<Password> callPass = apiService.registrarPassword(nuevaPassword);
                                callPass.enqueue(new Callback<Password>() {
                                    @Override
                                    public void onResponse(Call<Password> call, Response<Password> response) {
                                        if (response.isSuccessful()) {
                                            Log.d("PASSWORD", "Contraseña registrada correctamente");
                                        } else {
                                            Log.e("PASSWORD", "Error al registrar contraseña: " + response.code());
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Password> call, Throwable t) {
                                        Log.e("PASSWORD", "Fallo al registrar contraseña: " + t.getMessage());
                                    }
                                });

                                // 👉 REGISTRAR ADMINISTRADOR
                                Administrador nuevoAdministrador = new Administrador(dni, nm1user, nm2user, apell1,
                                        apell2, cell, email);
                                nuevoAdministrador.setUser(usuarioCreado);

                                Call<Administrador> callAdmin = apiService.registrarAdministrador(nuevoAdministrador);
                                callAdmin.enqueue(new Callback<Administrador>() {
                                    @Override
                                    public void onResponse(Call<Administrador> call, Response<Administrador> response) {
                                        if (response.isSuccessful()) {
                                            Toast.makeText(CreaAdmin.this, "Administrador registrado",
                                                    Toast.LENGTH_SHORT).show();

                                            // 👉 REGISTRAR EQUIPO
                                            Map<String, String> datosEquipo = DeviceInfo
                                                    .obtenerDatosDelDispositivo(CreaAdmin.this);
                                            Equipo nuevoEquipo = new Equipo(
                                                    usuarioCreado.getId(),
                                                    datosEquipo.get("android_id"),
                                                    datosEquipo.get("marca"),
                                                    datosEquipo.get("modelo"),
                                                    datosEquipo.get("version_os"),
                                                    datosEquipo.get("fecha_registro"),
                                                    datosEquipo.get("imei"),
                                                    datosEquipo.get("numero_telefono"));

                                            Call<Equipo> callEquipo = apiService.registrarEquipo(nuevoEquipo);
                                            callEquipo.enqueue(new Callback<Equipo>() {
                                                @Override
                                                public void onResponse(Call<Equipo> call, Response<Equipo> response) {
                                                    if (response.isSuccessful()) {
                                                        Toast.makeText(CreaAdmin.this, "Equipo registrado",
                                                                Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(CreaAdmin.this, "Error al registrar equipo",
                                                                Toast.LENGTH_SHORT).show();
                                                    }
                                                }

                                                @Override
                                                public void onFailure(Call<Equipo> call, Throwable t) {
                                                    Toast.makeText(CreaAdmin.this,
                                                            "Fallo en registro de equipo: " + t.getMessage(),
                                                            Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                            Intent nextActivity = new Intent(CreaAdmin.this, CreaEmpresa.class);
                                            startActivity(nextActivity);
                                        } else {
                                            Toast.makeText(CreaAdmin.this, "Error al registrar Administrador",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Administrador> call, Throwable t) {
                                        Toast.makeText(CreaAdmin.this, "Error de conexión: " + t.getMessage(),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                Toast.makeText(CreaAdmin.this, "Error al crear usuario", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(CreaAdmin.this, "Error en la conexión: " + t.getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    Toast.makeText(CreaAdmin.this, "Complete los campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void execRegAdmin(View view) {
        Intent nextActivy = new Intent(this, CreaEmpresa.class);
        startActivity(nextActivy);
    }

    private boolean GrabaAdministrador() {
        boolean graba = false;
        return graba;
    }

    private boolean ValidaDatos() {
        boolean validaDato = true;
        return validaDato;
    }

    public void nextActivityCreaEmp(View view) {
        Intent nextActivy = new Intent(this, UseryEmpra.class);
        startActivity(nextActivy);
    }
}
