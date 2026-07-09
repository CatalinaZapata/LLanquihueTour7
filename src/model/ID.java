package model;

public class ID {//Clase composicion
    private int id;

    public ID(int id) { this.id = id;}

    public int getId() { return id;}
    public void setId(int id) { this.id = id;}

    @Override
    public String toString() { return " | ID: " + id;}
}
