package com.example.vicontred.dbprocesos;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class dbLoginRequest extends StringRequest {
    private static final String ruta = "http://127.0.0.1/VisitorCR/conexion/logueo2.php";
    private Map<String,String> logueo;

    public dbLoginRequest(String mmusuario, String mmpass, Response.Listener<String> listener) {
        super(Request.Method.POST, ruta, listener, null);

        logueo = new HashMap<>();
     //   logueo.put("mmusuario",mmusuario+"");
     //   logueo.put("mmpass",mmpass+"");
        logueo.put("cAduser",mmusuario+"");
        logueo.put("cApass",mmpass+"");

    }

    public Map<String, String> getLogueo() {
        return logueo;
    }

}
