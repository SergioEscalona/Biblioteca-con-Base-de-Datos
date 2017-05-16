package ejercicio17.a17_bibliotecabd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import JavaBean.Libro;
import Model.GestionLibros;

public class AltaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
    }

    public void altaLibro(View v) {
        //recuperamos referencias a los controles de texto
        EditText edtNombre = (EditText) this.findViewById(R.id.edtNombre);
        EditText edtIsbn = (EditText) this.findViewById(R.id.edtIsbn);
        EditText edtPrecio = (EditText) this.findViewById(R.id.edtPrecio);
        //creamos objeto que encapsula las operaciones contra la base de datos
        GestionLibros glibros = new GestionLibros(this, "biblioteca");
        //añadimos contacto
        glibros.altaLibro(edtNombre.getText().toString(),
                edtIsbn.getText().toString(),
                Integer.parseInt(edtPrecio.getText().toString()));
        //cierre de la base de datos
        glibros.cerrar();
        edtNombre.getText().clear();
        edtIsbn.getText().clear();
        edtPrecio.getText().clear();
    }

    public void salir(View v){
        AltaActivity.this.finish();
    }
}
