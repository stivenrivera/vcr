package com.example.vicontred.dbprocesos;

public class Apis {
    // aqui crearemos las URLs correspondientes a cada escenario.

    public static String URL_user_001="http://192.168.1.11:8080";

    public static tbAdminServices getUsuarioServices(){
        return clsUsuarios.getUsuarios(URL_user_001).create(tbAdminServices.class);
    }
}
