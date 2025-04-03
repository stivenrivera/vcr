package com.example.vicontred;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vicontred.tablas.dbtablasAdmin;

import java.util.List;

// se crea esta clase, como mediador entre el activity, aca se cargara la info
// se hace el extends de tipo arrayadapter con la tabla usuarios
// se debe hacer los import necesarios.
// luego se crea el constructor x defal
public class UsuarioAdapter extends ArrayAdapter<dbtablasAdmin> {

    // aca definimos las variable internas con las que se trabajara
    // context que realmente aun no se.
    // list como array de los usuarios
    private Context context;
    private List<dbtablasAdmin>Usuarios;


    public UsuarioAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<dbtablasAdmin> objects) {
        super(context, resource, textViewResourceId, objects);

        // se toma el context que viebe como parametro del constructor y se lo asocia al local.
        // asumo que empieza a considerar_todo lo que viene como local!!

        this.context=context;
        // asi mismo el objeto la lista que viene, ahora es usuarios!! esto si esta clarito
        this.Usuarios=objects;

    }

    // ahora implementare un metodo view
    // todoes debe crearse...!!

    @NonNull
    @Override
    public View getView(int posicion, @Nullable View convertView, @NonNull ViewGroup parent){
    // esto lo comentas  return super.getView(posicion,convertView,parent);
        //creo 1 def del entorno main que me llega como context en la nueva layoutInflater
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // aca ya tengo los controles del objeto contect en una vista
        View rowUsuario = layoutInflater.inflate(R.layout.content_main,parent,false);

        // ahora defino una dato del mismo tipo como esta en mainacti, y lo casteo en la nueva variblae
        EditText usernm=(EditText)rowUsuario.findViewById(R.id.txtusernm);
        EditText passnm=(EditText)rowUsuario.findViewById(R.id.txtpssnm);

        // ahora a estos datos los voy a cargar con datos
        // ahora estamos cargando de la lista Usuario el dato necesario en el campo.
        usernm.setText(String.format("usernm:%",Usuarios.get(posicion).getMmusuario()));
        passnm.setText(String.format("passnm:%",Usuarios.get(posicion).getMmpass()));

        return rowUsuario;
    }


}
