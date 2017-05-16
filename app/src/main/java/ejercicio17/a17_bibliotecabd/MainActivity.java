package ejercicio17.a17_bibliotecabd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void añadir(View v){
        Intent intent=new Intent(this,AltaActivity.class);
        this.startActivity(intent);
    }

    public void mostrarTodos(View v){
        Intent intent=new Intent(this,MostrarActivity.class);
        this.startActivity(intent);
    }

    public void borrarLibro(View v){
        Intent intent=new Intent(this,BorrarActivity.class);
        this.startActivity(intent);
    }


    public void mostrarISBN(View v){
        Intent intent=new Intent(this,IsbnActivity.class);
        this.startActivity(intent);
    }

    public void salir(View v){
        this.finish();
    }
}
