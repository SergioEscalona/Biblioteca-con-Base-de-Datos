package Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.ResultSet;

import JavaBean.Libro;

/**
 * Created by Sergio on 02/04/2017.
 */

public class GestionLibros {
    Ayudante helper;
    SQLiteDatabase db;
    public GestionLibros
            (Context ctx, String nombreBd){
        //creación objeto ayudante
        helper=new Ayudante(ctx,nombreBd);
        db=helper.getWritableDatabase();
    }


    public void altaLibro(Libro libro){
        String sql="insert into biblioteca (nombre, isbn, precio) ";
        sql+="values ('"+libro.getNombre()+"'," + "'"
                        +libro.getIsbn()+"',"
                        +libro.getPrecio()+")";
        db.execSQL(sql);

    }

    public void altaLibro(String nombre, String isbn, int precio){
        String sql="insert into biblioteca (nombre, isbn, precio) ";
        sql+="values ('"+nombre+"','"+isbn+"',"+precio+")";
        db.execSQL(sql);

    }

    public Cursor obtenerLibros(){
        String sql="select * from biblioteca";
        return db.rawQuery(sql,null);
    }

    public Cursor obtenerLibrosIsbn(String isbn){
        /*String sql="select * from contactos where telefono="+tel;
        return db.rawQuery(sql,null);*/
        String sql="select * from biblioteca where isbn =?";
        String[] args= new String[1];
        args[0]=isbn;
        return db.rawQuery(sql,args);
    }

    public void cerrar(){
        db.close();
    }

    public void eliminarLibro(String nombre){
        String sql="delete from biblioteca where nombre='"+nombre+"'";

        db.execSQL(sql);
    }

    public boolean comprobarNombre (String nombre){
        boolean res=false;
        String sql="select * from biblioteca where nombre="+nombre;
        Cursor c=db.rawQuery(sql,null);
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                nombre = c.getString(1);
            } while(c.moveToNext());
        }
        return res;
    }


}
