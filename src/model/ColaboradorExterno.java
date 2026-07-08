package model;

public class ColaboradorExterno extends RecursoAgencia implements Registrable {//Clase heredera que conserva el formato para un trabajador externo
    private String especialidad;
    private String agenciaExterna;

    public ColaboradorExterno(String nombre, int id, String especialidad, String agenciaExterna) {
        super(nombre, id);
        this.especialidad = especialidad;
        this.agenciaExterna = agenciaExterna;
    }

    public ColaboradorExterno(String especialidad, String agenciaExterna) {
        this.especialidad = especialidad;
        this.agenciaExterna = agenciaExterna;
    }

    @Override
    public void mostrarResumen() {
        System.out.print("Tipo Trabajador: Guia Externo | ");
        super.mostrarResumen();
        System.out.print(" | Especialidad: " + especialidad + " | Agencia: " + agenciaExterna);
    }

    @Override
    public String toString() {
        return "Tipo Trabajador: Guia Externo | " + "Nombre: " + nombre + " | ID: " + id + " | Especialidad: " + especialidad + " | Agencia: " + agenciaExterna;
    }
}