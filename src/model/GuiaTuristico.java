package model;

public class GuiaTuristico extends RecursoAgencia implements Registrable {//Clase heredera que conserva el formato para un trabajador interno
    private String especialidad;

    public GuiaTuristico(String especialidad) {
        this.especialidad = especialidad;
    }

    public GuiaTuristico(String nombre, int id, String especialidad) {
        super(nombre, id);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarResumen() {
        System.out.print("Tipo Trabajador: Guia Turistico | ");
        super.mostrarResumen();
        System.out.print(" | Especialidad: " + especialidad + " | Agencia: LlanquihueTour");
    }

    @Override
    public String toString() {
        return "Tipo Trabajador: Guia Turistico | " + "Nombre: " + nombre + " | ID: " + id + " | Especialidad: " + especialidad + " | Agencia: LlanquihueTour";
    }
}