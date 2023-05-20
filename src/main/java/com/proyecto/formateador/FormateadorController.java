package com.proyecto.formateador;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class FormateadorController {

    @FXML
    private TextField txtEntrada;
    @FXML
    private Label resultado;
    @FXML
    private Label resCalculable;
    
    
    @FXML
    private void darFormato(){
        String res = Utilidades.formato(txtEntrada.getText());
        double num = Utilidades.formatoCalculable(res);
        double suma = 1000.01 + num;
        String resSuma = Utilidades.numFormato(suma);
        resultado.setText(res);
        resCalculable.setText("Prueba de Calculo 1.000,01 + "+res+" = "+resSuma);
    }
}
