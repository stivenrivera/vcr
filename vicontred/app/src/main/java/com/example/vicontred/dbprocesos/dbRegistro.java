package com.example.vicontred.dbprocesos;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class dbRegistro extends StringRequest {
    private static final String ruta = "http://localhost/VisitorCR/conexion/registro.php";
    private Map<String,String> parametros;



    public dbRegistro(String rqindreg, String rqdni, String rqusuario, String rqusernm1,
                      String rqusernm2, String rqapell1, String rqapell2, String rqpass,
                      String rqcpass, String rqcell, String rqemail, String rqadmin, String rqseguridad,
                      String rqestado,  String rqfeccrea, String rquserdb, Response.Listener<String> listener ){

        super(Request.Method.POST, ruta , listener, null);

        parametros = new HashMap<>();
        parametros.put("dni",rqdni+"");
        parametros.put("mmusuario",rqusuario+"");
        parametros.put("mmuser1",rqusernm1+"");
        parametros.put("mmuser2",rqusernm2+"");
        parametros.put("mmapell1",rqapell1+"");
        parametros.put("mmapell2",rqapell2+"");
        parametros.put("mmpass",rqpass+"");
        parametros.put("mmcpass",rqcpass+"");
        parametros.put("cell",rqcell+"");
        parametros.put("mail",rqemail+"");
        parametros.put("admin",rqadmin+"");
        parametros.put("seguridad",rqseguridad+"");
        parametros.put("estado",rqestado+"");
        parametros.put("feccrea",rqfeccrea+"");
        parametros.put("userdb",rquserdb+"");
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

/*    public void dbLogueo(String mmusuario, String mmpass, Response.Listener<String> listener ){
        super(Method.POST, ruta , listener, null);

        logueo = new HashMap<>();
        logueo.put("mmusuario",mmusuario+"");
        logueo.put("mmpass",mmpass+"");
    }
*/
}
