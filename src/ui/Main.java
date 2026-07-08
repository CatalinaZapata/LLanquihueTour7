package ui;

import data.GestorEntidades;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GestorEntidades gestor = new GestorEntidades();
        boolean continuar = true;

        while (continuar) {
            String[] desplegable =  {"1.Registrar Guía Turístico",//se usa una lista desplegable para evitar errores en ingreso de datos
                    "2.Registrar Guía Externo",
                    "3.Registrar Conductor",
                    "4.Mostrar Historial"};

            Object opcion = JOptionPane.showInputDialog(null,
                    "Seleccione una opción",
                    "Menu Llanquihue Tour",
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    desplegable,
                    desplegable[0]);//Aquí se dejan las especificaciones de la lista desplegable

            int seleccion = java.util.Arrays.asList(desplegable).indexOf(opcion) + 1;//+1 para que inicie en 1 y no en 0

            switch (seleccion) {
                case 0://para que al apretar X o cancel se finalice el programa
                    continuar = false;
                    break;
                case 1:
                    gestor.registrarGuiaTuristico();
                    break;
                case 2:
                    gestor.registrarColaboradorExterno();
                    break;
                case 3:
                    gestor.registrarMovilizacion();
                    break;
                case 4:
                    gestor.mostrarHistorialResumen();
                    break;
                default:

            }
        }
    }
}