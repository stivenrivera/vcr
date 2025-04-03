package com.example.vicontred;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class dbLoginRq extends StringRequest {
//    private static final String ruta = "http://127.0.0.1/VisitorCR/conexion/logueo.php";
private static final String ruta = "http://192.168.1.15/VisitorCR/conexion/logueo.php";

    private Map<String,String> logueo;
    private static final String errorListeres = null;

    public dbLoginRq(String mmusuario, String mmpass,  Response.Listener<String> listener) {
//        super(Request.Method.POST, ruta, listener, null);
        super(Method.GET, ruta, listener, null);

        logueo = new HashMap<>();
        //   logueo.put("mmusuario",mmusuario+"");
        //   logueo.put("mmpass",mmpass+"");
        logueo.put( "cAduser", mmusuario+"");
        logueo.put( "cApass", mmpass+"");

    }

    public Map<String, String> getLogueo() {
        return logueo;
    }

}

