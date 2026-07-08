package model;

public class RecursoAgencia {//Superclase Abstracta con atrib comunes de las clases hijas. Sin getters y setter puesto que no se modificaran los atributos, solo se ingresaran.
    protected String nombre;
    protected int id;

    public RecursoAgencia() {}

    public RecursoAgencia(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void mostrarResumen() {//Polimorfismo para mostrar resultado en consola
        System.out.print("Nombre: " + nombre + " | ID: " + id);
    }

    @Override
    public String toString() {//toString para mostrar resultado en una interfaz grafica
        return "Nombre: " + nombre + " | ID: " + id;
    }
}