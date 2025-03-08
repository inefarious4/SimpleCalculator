package com.example.calculatorapp.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {
    private CalculatorModel model = new CalculatorModel();
    private MutableLiveData<String> display = new MutableLiveData<>();

    public CalculatorViewModel() {
        display.setValue("0");
    }

    public LiveData<String> getDisplay() {
        return display;
    }

    public void onNumberClicked(String number) {
        model.appendNumber(number);
        display.setValue(model.getResult());
    }

    public void onOperatorClicked(String operator) {
        model.setOperator(operator);
        display.setValue(model.getResult());
    }

    public void onEqualsClicked() {
        model.calculate();
        display.setValue(model.getResult());
    }

    public void onClearClicked() {
        model.clear();
        display.setValue("0");
    }
}