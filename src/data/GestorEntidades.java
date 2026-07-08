package data;

import model.*;//Llamo full el paquete porque en los metodos use todas las clases
import util.Validadores;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class GestorEntidades {
    Validadores validador = new Validadores();
    private ArrayList<Registrable> listaEntidades = new ArrayList<>();//se crea la lista registrable, para guardar los =/= obj y formatos en una misma coleccion

    public void agregarEntidades(Registrable entidades) {//metodo para agregar a los trabajadores como obj registrables
        listaEntidades.add(entidades);
    }

    /*public ArrayList<Registrable> cargarEntidades() {
        String rutaArchivo = "src/resources/tours.txt";
        try {
            File archivo = new File(rutaArchivo);
            Scanner lector = new Scanner(archivo);
            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                String[] partes = linea.split("\\|");
            }
        } catch (Exception e) {
            System.out.println("Error: No se encuentra el archivo.");
        }
        return listaEntidades;
    }*/

    public void registrarGuiaTuristico(){//metodo con el formato de GT
        try (BufferedWriter escribir = new BufferedWriter((new FileWriter("src/resources/tours.txt", true)))){//FileWriter escribir = new FileWriter(new FileWriter("src/resources/tours.txt"
            String nomG = validador.validarIngreso("Nombre: ");
            int idG = validador.validarID("ID: ");
            String espG = validador.validarIngreso("Especialidad: ");
            agregarEntidades(new GuiaTuristico(nomG, idG, espG));
            escribir.write("GuiaTuristico|" + nomG + "|" + idG + "|" + espG + "|LlanquihueTour");
            escribir.newLine();
        } catch (RuntimeException e) {
            return;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: No se logra registrar.");
        }
        JOptionPane.showMessageDialog(null, "Registrado exitosamente.");
    }

    public void registrarColaboradorExterno(){//metodo con el formato de CE
        try(BufferedWriter escribir = new BufferedWriter((new FileWriter("src/resources/tours.txt", true)))) {
            String nomE = validador.validarIngreso("Nombre: ");
            int idE = validador.validarID("ID: ");
            String espE = validador.validarIngreso("Especialidad: ");
            String agE = validador.validarIngreso("Agencia: ");
            agregarEntidades(new ColaboradorExterno(nomE, idE, espE, agE));
            escribir.write("ColaboradorExterno" + "|" + nomE + "|" + idE + "|" + espE + "|" + agE);
            escribir.newLine();
        } catch (RuntimeException e) {
            return;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: No se logra registrar.");
        }
        JOptionPane.showMessageDialog(null, "Registrado exitosamente.");
    }

    public void registrarMovilizacion(){//metodo con el formato de M
        try(BufferedWriter escribir = new BufferedWriter((new FileWriter("src/resources/tours.txt", true)))) {
            String nomM = validador.validarIngreso("Nombre: ");
            int idM = validador.validarID("ID: ");
            String espM = validador.validarIngreso("Tipo de Vehículo: ");
            String agM = validador.validarIngreso("Agencia: ");
            agregarEntidades(new Movilizacion(nomM, idM, espM, agM));
            escribir.write("Movilizacion" + "|" + nomM + "|" + idM + "|" + espM + "|" + agM);
            escribir.newLine();
        } catch (RuntimeException e) {
            return;
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: No se logra registrar.");
        }
        JOptionPane.showMessageDialog(null, "Registrado exitosamente.");
    }

    public void mostrarHistorialResumen() {//metodo para mostrar el historial registrado en la sesion
        StringBuilder reporte = new StringBuilder("Entidades Registradas: \n\n");
        for(Registrable registrable : listaEntidades){//for-each permite recorrer los datos de la lista.
            if(registrable instanceof RecursoAgencia){//permite diferenciar el tipo de obj de acuerdo a la clase y eso ayuda a la impresion correcta de la info
                reporte.append("");
                System.out.println("");
            }
            reporte.append(registrable.toString()).append("\n");
            registrable.mostrarResumen();
        }
        JOptionPane.showMessageDialog(null, reporte.toString());
    }

    public ArrayList<Registrable> getLista() { return listaEntidades;}//accede al array
}