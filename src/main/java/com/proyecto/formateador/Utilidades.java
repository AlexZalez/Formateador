/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.formateador;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.text.ParseException;
import javafx.scene.control.Alert;

/**
 *
 * @author Administrador
 */
public class Utilidades {
    
    // formato convierte un String a un formato 9.000.000,00
    public static String formato(String valor){
        try {                

            if (!valor.matches("[0-9.,]+")) {
                System.out.println("Error tiene letras");
                throw new ParseException(valor, 0);
            }  
            double valido;

            valido = Double.parseDouble(valor);
            double redondeado = (double)Math.round(valido * 100d) / 100d;

            DecimalFormat formato = new DecimalFormat("#,###.00");
            DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
            dfs.setDecimalSeparator(',');
            formato.setDecimalFormatSymbols(dfs);
            String cadena = formato.format(redondeado);

            char coma = cadena.charAt(0);
            if (coma == ',') {
                cadena = "0"+cadena;
            }

            return cadena;

        } catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();    
        }    
            
        return "";
        
    }
    
    //numFormato convierte un Double a formato 9.000.000,00
    public static String numFormato(double valor){
        double redondeado = (double)Math.round(valor * 100d) / 100d;

        DecimalFormat formato = new DecimalFormat("#,###.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
        dfs.setDecimalSeparator(',');
        formato.setDecimalFormatSymbols(dfs);
        String cadena = formato.format(redondeado);

        char coma = cadena.charAt(0);
        if (coma == ',') {
            cadena = "0"+cadena;
        }

        return cadena;   
    }
    
    //formatoCalculable convierte un String de formato 9.000.000,00 a un Double
    public static double formatoCalculable(String valor){
        try {                

            if (!valor.matches("[0-9.,]+")) {
                System.out.println("Error tiene letras");
                throw new ParseException(valor, 0);
            }  
            double valido;

            valido = myParseDouble(valor);
            double redondeado = (double)Math.round(valido * 100d) / 100d;
            
            return redondeado;

        } catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();    
        }    
            
        return 0;
    
    }
    
    private static double myParseDouble(String input) throws ParseException {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat format = new DecimalFormat("#,##0.00", symbols);
        return format.parse(input).doubleValue();
    }
    
    
}
