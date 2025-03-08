package com.example.calculatorapp.mvc;

public class CalculatorModel {
    private double result = 0.0;
    private String currentNumber = "";
    private String operator = null;

    public void appendNumber(String number) {
        currentNumber += number;
    }

    public void setOperator(String op) {
        if (!currentNumber.isEmpty()) {
            calculate();
            operator = op;
        }
    }

    public void calculate() {
        if (currentNumber.isEmpty()) return;
        double number = Double.parseDouble(currentNumber);
        currentNumber = "";
        if (operator == null) {
            result = number;
        } else {
            switch (operator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    result /= number;
                    break;
            }
        }
    }

    public String getResult() {
        if (currentNumber.isEmpty()) {
            return String.valueOf(result);
        } else {
            return currentNumber;
        }
    }

    public void clear() {
        result = 0.0;
        currentNumber = "";
        operator = null;
    }
}