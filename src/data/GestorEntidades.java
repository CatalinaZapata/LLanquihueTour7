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

    public void registrarGuiaTuristico(){//metodo con el formato de GT
        try (BufferedWriter escribir = new BufferedWriter((new FileWriter("src/resources/tours.txt", true)))){//FileWriter escribir = new FileWriter(new FileWriter("src/resources/tours.txt"
            String nomG = validador.validarIngreso("Nombre: ");
            int idG = validador.validarID("ID: ");
            ID id = new ID(idG);
            String espG = validador.validarIngreso("Especialidad: ");
            GuiaTuristico guia = new GuiaTuristico(nomG, id, espG);
            agregarEntidades(guia);
            escribir.write(guia.registrarDatos());
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
            ID id = new ID(idE);
            String espE = validador.validarIngreso("Especialidad: ");
            String agE = validador.validarIngreso("Agencia: ");
            ColaboradorExterno colaborador = new ColaboradorExterno(nomE, id, espE, agE);
            agregarEntidades(colaborador);
            escribir.write(colaborador.registrarDatos());
            //escribir.write("ColaboradorExterno" + "|" + nomE + "|" + idE + "|" + espE + "|" + agE);
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
            ID id = new ID(idM);
            String espM = validador.validarIngreso("Tipo de Vehículo: ");
            String agM = validador.validarIngreso("Agencia: ");
            Movilizacion movilizacion = new Movilizacion(nomM, id, espM, agM);
            agregarEntidades(movilizacion);
            escribir.write(movilizacion.registrarDatos());
            //escribir.write("Movilizacion" + "|" + nomM + "|" + idM + "|" + espM + "|" + agM);
            escribir.newLine();
        } catch (RuntimeException e) {
            return;
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: No se logra registrar.");
        }
        JOptionPane.showMessageDialog(null, "Registrado exitosamente.");
    }

    public void cargarArchivo(){
        try(BufferedReader leer = new BufferedReader(new FileReader("src/resources/tours.txt"))){
            String linea;
            while((linea = leer.readLine()) != null){
                String[] datos = linea.split("\\|");

                if(datos[0].equals("GuiaTuristico")){
                    agregarEntidades(new GuiaTuristico(datos[1], new ID(Integer.parseInt(datos[2])), datos[3]));
                }

                if(datos[0].equals("ColaboradorExterno")){
                    agregarEntidades(new ColaboradorExterno(datos[1], new ID(Integer.parseInt(datos[2])), datos[3], datos[4]));
                }

                if(datos[0].equals("Movilizacion")){
                    agregarEntidades(new Movilizacion( datos[1], new ID(Integer.parseInt(datos[2])), datos[3], datos[4]));
                }
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error: No se logra cargar archivo.");
        }
    }

    public void mostrarHistorialResumen() {//metodo para mostrar el historial registrado en la sesion
        StringBuilder reporte = new StringBuilder("Entidades Registradas: \n\n");
        //String linea;
        for(Registrable registrable : listaEntidades) {//for-each permite recorrer los datos de la lista.
            if (registrable instanceof RecursoAgencia) {//permite diferenciar el tipo de obj de acuerdo a la clase y eso ayuda a la impresion correcta de la info
                reporte.append("");
                System.out.println("");
            }
            reporte.append(registrable.toString()).append("\n");
            registrable.mostrarResumen();
        }
        JOptionPane.showMessageDialog(null, reporte.toString());
    }

    public void filtrarEntidades() {
        String[] desplegableEntidades = {"GuiaTuristico",
                                         "ColaboradorExterno",
                                         "Movilizacion"};

        Object opcionEntidades = JOptionPane.showInputDialog(null,
                                                             "Seleccione una opción de filtrado",
                                                             "Filtro de Funcionarios",
                                                             JOptionPane.INFORMATION_MESSAGE,
                                                             null,
                                                             desplegableEntidades,
                                                             desplegableEntidades[0]);

        StringBuilder filtroEntidades = new StringBuilder("Resultado del filtro: \n\n");

        for (Registrable registrable : listaEntidades) {
            if (opcionEntidades.equals("GuiaTuristico") && registrable instanceof GuiaTuristico){
                filtroEntidades.append(registrable).append("\n");
            }
            if (opcionEntidades.equals("ColaboradorExterno") && registrable instanceof ColaboradorExterno){
                filtroEntidades.append(registrable).append("\n");
            }
            if (opcionEntidades.equals("Movilizacion") && registrable instanceof Movilizacion){
                filtroEntidades.append(registrable).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, filtroEntidades.toString());
    }

    public ArrayList<Registrable> getLista() { return listaEntidades;}//accede al array
}