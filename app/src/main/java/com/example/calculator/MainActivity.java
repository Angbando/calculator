package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    private Calculate calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        int[] numButtons = new int[]{R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.comma};

        int[] actButtons = new int[]{R.id.plus, R.id.minus, R.id.multiply, R.id.divide, R.id.equals, R.id.del};

        calculate = new Calculate();

        text = findViewById(R.id.textView);

        View.OnClickListener clickNum = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate.numPress(view.getId());
                text.setText(calculate.numText());
            }
        };

        View.OnClickListener clickAct = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate.actPress(view.getId());
                text.setText(calculate.numText());
            }
        };

        for (int i = 0; i < numButtons.length; i++) {
            findViewById(numButtons[i]).setOnClickListener(clickNum);
        }

        for (int i = 0; i < actButtons.length; i++) {
            findViewById(actButtons[i]).setOnClickListener(clickAct);
        }

        findViewById(R.id.themes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent themes = new Intent(MainActivity.this, ThemesChoiceActivity.class);
                startActivity(themes);
            }
        });

    }
}