package util;

import javax.swing.*;

public class Validadores {
    public String validarIngreso (String mensaje) {//metodo que valida que los ingresos no sean espacios o vacios
        String variable;
        do{ variable = JOptionPane.showInputDialog(mensaje);
            if(variable == null){
                throw new RuntimeException("Cancelado.");
            }
            if(variable==null || variable.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Error: Debe completar el campo.");//si esta condicion se cumple que muestre el error
            } else if (!variable.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                JOptionPane.showMessageDialog(null, "Error: Solo puede ingresar letras.");
            }
        } while(variable==null || variable.trim().isEmpty() || !variable.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));//si esta condicion se cumple que continue el bucle
        return variable;
    }

    public int validarID (String mensaje) {//metodo que valida que los ingresos id sean solo numeros, no esten vacios, ni espacios
        int numero = 0;
        boolean valido = false;
        do {
            try {
                String numeroString = JOptionPane.showInputDialog(mensaje);
                if (numeroString == null) { // Si presiona Cancelar o X
                    throw new RuntimeException("Cancelado.");
                }
                if(numeroString==null || numeroString.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Error: Debe completar el campo.");
                } else{
                    numero = Integer.parseInt(numeroString);
                    valido = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Solo puede ingresar números.");
            }
        } while(!valido);
        return numero;
    }
}
