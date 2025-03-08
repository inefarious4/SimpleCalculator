package com.example.calculatorapp.mvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatorapp.R;

public class MvvmActivity extends AppCompatActivity {
    private TextView display;
    private CalculatorViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        // Observe the LiveData
        viewModel.getDisplay().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                display.setText(s);
            }
        });

        // Number buttons
        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onNumberClicked("0");
            }
        });
        findViewById(R.id.button1).setOnClickListener(v -> viewModel.onNumberClicked("1"));
        findViewById(R.id.button2).setOnClickListener(v -> viewModel.onNumberClicked("2"));
        findViewById(R.id.button3).setOnClickListener(v -> viewModel.onNumberClicked("3"));
        findViewById(R.id.button4).setOnClickListener(v -> viewModel.onNumberClicked("4"));
        findViewById(R.id.button5).setOnClickListener(v -> viewModel.onNumberClicked("5"));
        findViewById(R.id.button6).setOnClickListener(v -> viewModel.onNumberClicked("6"));
        findViewById(R.id.button7).setOnClickListener(v -> viewModel.onNumberClicked("7"));
        findViewById(R.id.button8).setOnClickListener(v -> viewModel.onNumberClicked("8"));
        findViewById(R.id.button9).setOnClickListener(v -> viewModel.onNumberClicked("9"));

        // Operator buttons
        findViewById(R.id.buttonAdd).setOnClickListener(v -> viewModel.onOperatorClicked("+"));
        findViewById(R.id.buttonSubtract).setOnClickListener(v -> viewModel.onOperatorClicked("-"));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> viewModel.onOperatorClicked("*"));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> viewModel.onOperatorClicked("/"));
        findViewById(R.id.buttonEquals).setOnClickListener(v -> viewModel.onEqualsClicked());
        findViewById(R.id.buttonClear).setOnClickListener(v -> viewModel.onClearClicked());
    }
}