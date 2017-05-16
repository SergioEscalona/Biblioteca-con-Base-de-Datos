package ejercicio17.a17_bibliotecabd;

import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import Model.GestionLibros;

public class MostrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        GestionLibros glibros = new GestionLibros(this, "biblioteca");
        Cursor c = glibros.obtenerLibros();
        //array con los nombres de las columnas del cursor que queremos mostrar
        String[] nombres = {"nombre", "isbn", "precio"};
        //array con los identificadores de los controles donde se volcarán las columnas
        int[] ids = {R.id.tvFNombre, R.id.tvFisbn, R.id.tvFPrecio};
        //creación del adaptador
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.fila,
                c,
                nombres,
                ids,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        //asignamos adaptador al ListView
        ListView lstdatos = (ListView) this.findViewById(R.id.listaLibros);
        lstdatos.setAdapter(adapter);
    }

    public void salir(View v) {
        this.finish();
    }

}
