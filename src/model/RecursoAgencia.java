package model;

public abstract class RecursoAgencia {//Superclase Abstracta con atrib comunes de las clases hijas. Sin getters y setter puesto que no se modificaran los atributos, solo se ingresaran.
    protected String nombre;
    protected ID id;

    public RecursoAgencia() {}

    public RecursoAgencia(String nombre, ID id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() { return nombre;}
    public void setNombre(String nombre) { this.nombre = nombre;}

    public String registrarDatos() { return nombre + "|" + id.getId();}
    public void mostrarResumen() { System.out.print("Nombre: " + nombre + " | ID: " + id.getId());}//Polimorfismo para mostrar resultado en consola
    public String toString() { return "Nombre: " + nombre +" | ID: " + id.getId();}//toString para mostrar resultado en una interfaz grafica
}