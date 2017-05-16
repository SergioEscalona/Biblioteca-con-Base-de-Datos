package JavaBean;

import java.io.Serializable;

/**
 * Created by Sergio on 02/04/2017.
 */

public class Libro implements Serializable {

    private String nombre;
    private String isbn;
    private int precio;

    public Libro(String nombre, String isbn, int precio) {

        this.nombre = nombre;
        this.isbn = isbn;
        this.precio = precio;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" +
                ", nombre='" + nombre + '\'' +
                ", isbn='" + isbn + '\'' +
                ", precio=" + precio +
                '}';
    }
}
