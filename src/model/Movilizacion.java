package model;

public class Movilizacion extends RecursoAgencia implements Registrable{//Clase heredera que conserva el formato para un trabajador externo de movilizacion
    private String tipoVehiculo;//para el tipo de vehiculo que conduce
    private String agenciaMovilizacion;

    public Movilizacion(String nombre, int id, String tipoVehiculo, String agenciaMovilizacion) {
        super(nombre, id);
        this.tipoVehiculo = tipoVehiculo;
        this.agenciaMovilizacion = agenciaMovilizacion;
    }

    public Movilizacion(String tipoVehiculo, String agenciaMovilizacion) {
        this.tipoVehiculo = tipoVehiculo;
        this.agenciaMovilizacion = agenciaMovilizacion;
    }

    @Override
    public void mostrarResumen() {
        System.out.print("Tipo Trabajador: Conductor | ");
        super.mostrarResumen();
        System.out.print(" | Tipo de Vehículor: " + tipoVehiculo + " | Agencia de movilizacion: " + agenciaMovilizacion);
    }

    @Override
    public String toString() {
        return "Tipo Trabajador: Conductor | " + "Nombre: " + nombre + " | ID: " + id + " | Tipo de Vehículo: " + tipoVehiculo + " | Agencia de movilizacion: " + agenciaMovilizacion;
    }
}