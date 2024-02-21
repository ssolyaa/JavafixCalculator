package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label result;
    private  boolean start = true;

     private double number1 = 0;
     private double number2 = 0;
     private  String operator = "";

    @FXML
    public void clear(ActionEvent event) {
        result.setText("");
        operator = "";
        start = true;
    }
    @FXML
    public void processNumber(ActionEvent event) {
        if (start){
            result.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        result.setText(result.getText()+ value);
    }
    @FXML
    public void processBinaryOperator(ActionEvent event) {
        String currentOperator = ((Button) event.getSource()).getText();
        if (!currentOperator.equals("=")) {
            if (!operator.isEmpty()) {
                return;
            }
            operator = currentOperator;
            number1 = Double.parseDouble(result.getText());
            result.setText("");

        } else {
                if (operator.isEmpty()) {
                    return;
            }
            number2 = Double.parseDouble(result.getText());
            double output = Calculation.calculateBinaryNumber(number1, number2, operator);
            result.setText(String.valueOf(output));
            operator = "";


        }


    }
    @FXML
    public  void processUnaryOperator(ActionEvent event) {
        String currentOperator = ((Button) event.getSource()).getText();
        if (!operator.isEmpty()) {
            return;
        }
        operator = currentOperator;
        number1 = Double.parseDouble(result.getText());
        result.setText("");

        double output = Calculation.calculateUnaryNumber(number1, operator);
        result.setText(String.valueOf(output));
        operator = "";

    }

}


