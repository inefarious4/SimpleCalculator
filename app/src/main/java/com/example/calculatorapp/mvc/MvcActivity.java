package com.example.calculatorapp.mvc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;

public class MvcActivity extends AppCompatActivity {
    private TextView display;
    private CalculatorController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        CalculatorModel model = new CalculatorModel();
        controller = new CalculatorController(model, this);

        // Number buttons
        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.onNumberClicked("0");
            }
        });
        findViewById(R.id.button1).setOnClickListener(v -> controller.onNumberClicked("1"));
        findViewById(R.id.button2).setOnClickListener(v -> controller.onNumberClicked("2"));
        findViewById(R.id.button3).setOnClickListener(v -> controller.onNumberClicked("3"));
        findViewById(R.id.button4).setOnClickListener(v -> controller.onNumberClicked("4"));
        findViewById(R.id.button5).setOnClickListener(v -> controller.onNumberClicked("5"));
        findViewById(R.id.button6).setOnClickListener(v -> controller.onNumberClicked("6"));
        findViewById(R.id.button7).setOnClickListener(v -> controller.onNumberClicked("7"));
        findViewById(R.id.button8).setOnClickListener(v -> controller.onNumberClicked("8"));
        findViewById(R.id.button9).setOnClickListener(v -> controller.onNumberClicked("9"));

        // Operator buttons
        findViewById(R.id.buttonAdd).setOnClickListener(v -> controller.onOperatorClicked("+"));
        findViewById(R.id.buttonSubtract).setOnClickListener(v -> controller.onOperatorClicked("-"));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> controller.onOperatorClicked("*"));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> controller.onOperatorClicked("/"));
        findViewById(R.id.buttonEquals).setOnClickListener(v -> controller.onEqualsClicked());
        findViewById(R.id.buttonClear).setOnClickListener(v -> controller.onClearClicked());
    }

    public void updateDisplay(String text) {
        display.setText(text);
    }
}