package com.example.calculatorapp.mvc;

public class CalculatorController {
    private CalculatorModel model;
    private MvcActivity view;

    public CalculatorController(CalculatorModel model, MvcActivity view) {
        this.model = model;
        this.view = view;
    }

    public void onNumberClicked(String number) {
        model.appendNumber(number);
        view.updateDisplay(model.getResult());
    }

    public void onOperatorClicked(String operator) {
        model.setOperator(operator);
        view.updateDisplay(model.getResult());
    }

    public void onEqualsClicked() {
        model.calculate();
        view.updateDisplay(model.getResult());
    }

    public void onClearClicked() {
        model.clear();
        view.updateDisplay("0");
    }
}