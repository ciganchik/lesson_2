package com.example.lesson_2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lesson_2.R;
import com.example.lesson_2.model.CalculatorImpl;
import com.example.lesson_2.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class Calculator extends AppCompatActivity implements CalculaterView{
    private TextView resultTxt;
    private CalculatorPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultTxt = findViewById(R.id.result);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.button_1, 1);
        digits.put(R.id.button_2, 2);
        digits.put(R.id.button_3, 3);
        digits.put(R.id.button_4, 4);
        digits.put(R.id.button_5, 5);
        digits.put(R.id.button_6, 6);
        digits.put(R.id.button_7, 7);
        digits.put(R.id.button_8, 8);
        digits.put(R.id.button_9, 9);
        digits.put(R.id.button_0, 0);

        View.OnClickListener digitClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitsPressed(digits.get(view.getId()));
            }
        };

        findViewById(R.id.button_1).setOnClickListener(digitClick);
        findViewById(R.id.button_2).setOnClickListener(digitClick);
        findViewById(R.id.button_3).setOnClickListener(digitClick);
        findViewById(R.id.button_4).setOnClickListener(digitClick);
        findViewById(R.id.button_5).setOnClickListener(digitClick);
        findViewById(R.id.button_6).setOnClickListener(digitClick);
        findViewById(R.id.button_7).setOnClickListener(digitClick);
        findViewById(R.id.button_8).setOnClickListener(digitClick);
        findViewById(R.id.button_9).setOnClickListener(digitClick);
        findViewById(R.id.button_0).setOnClickListener(digitClick);

        Map<Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.plus, Operator.ADD);
        operators.put(R.id.minus, Operator.SUB);
        operators.put(R.id.multiply, Operator.MULT);
        operators.put(R.id.div, Operator.DIV);


        View.OnClickListener operatorsClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorPressed(operators.get(view.getId()));
            }
        };

        findViewById(R.id.plus).setOnClickListener(operatorsClick);
        findViewById(R.id.minus).setOnClickListener(operatorsClick);
        findViewById(R.id.multiply).setOnClickListener(operatorsClick);
        findViewById(R.id.div).setOnClickListener(operatorsClick);



        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDotPressed();
            }
        });

        findViewById(R.id.def).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDefPressed(operators.get(view.getId()));
            }
        });

        findViewById(R.id.clear_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClearPressed();
            }
        });
    }



    @Override
    public void ShowResult(String result) {
        resultTxt.setText(result);
    }
}