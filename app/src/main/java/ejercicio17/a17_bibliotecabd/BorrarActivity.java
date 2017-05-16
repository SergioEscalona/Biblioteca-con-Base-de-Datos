package ejercicio17.a17_bibliotecabd;

import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import Model.GestionLibros;

public class BorrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
    }

    public void salir(View v) {
        this.finish();
    }

    public void borrar (View v){
        GestionLibros glibros=new GestionLibros(this,"biblioteca");
        EditText borrNomb = (EditText) this.findViewById(R.id.borrNombr);
        TextView tvborrado = (TextView) this.findViewById(R.id.tvBorrado);
        glibros.eliminarLibro(borrNomb.getText().toString());
        borrNomb.getText().clear();
        if (glibros.comprobarNombre(borrNomb.getText().toString())){
            tvborrado.setText("Libro borrado.");
        }else{
            tvborrado.setText("No existe el libro");
        }


    }
}
