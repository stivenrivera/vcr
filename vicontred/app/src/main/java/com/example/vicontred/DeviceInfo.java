package com.example.vicontred;

import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DeviceInfo {

    public static Map<String, String> obtenerDatosDelDispositivo(Context context) {
        Map<String, String> datos = new HashMap<>();

        // ANDROID_ID
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        datos.put("android_id", androidId);

        // Marca y modelo
        datos.put("marca", Build.MANUFACTURER);
        datos.put("modelo", Build.MODEL);

        // Versión del SO
        datos.put("version_os", Build.VERSION.RELEASE);

        // Fecha actual
        datos.put("fecha_registro", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        // IMEI y número (requiere permisos)
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                String imei = telephonyManager.getImei(); // solo disponible hasta API 28
                datos.put("imei", imei);
            } else {
                datos.put("imei", "No disponible en Android 10+");
            }

            String numeroTelefono = telephonyManager.getLine1Number();
            datos.put("numero_telefono", numeroTelefono);
        } else {
            datos.put("imei", "Sin permiso");
            datos.put("numero_telefono", "Sin permiso");
        }

        return datos;
    }
}
