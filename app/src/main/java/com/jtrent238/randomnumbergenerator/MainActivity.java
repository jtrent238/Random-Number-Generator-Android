package com.jtrent238.randomnumbergenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    public void generateRandomNumber(View view) {
        Button btn = findViewById(R.id.buttonGenerate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText minText = findViewById(R.id.numberMin);
                EditText maxText = findViewById(R.id.numberMax);

                double min = Double.valueOf(minText.getText().toString());
                double max = Double.valueOf(maxText.getText().toString());

                TextView randomNumber = findViewById(R.id.randomNumber);

                if (Double.valueOf(min) == null) {
                    startActivity(new Intent(MainActivity.this, InvalidNumber.class));
                }

                if (Double.valueOf(max) == null) {
                    startActivity(new Intent(MainActivity.this, InvalidNumber.class));
                }

                double myRandNumber = getRandomIntegerBetweenRange(min, max);

                randomNumber.setText(Double.toString(myRandNumber));
            }
        });
    }


    public void clearNumbers(View view) {

        Button btn = findViewById(R.id.buttonClear);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberMin = findViewById(R.id.numberMin);
                EditText numberMax = findViewById(R.id.numberMax);
                TextView randomNumber = findViewById(R.id.randomNumber);

                numberMin.setText(null);
                numberMax.setText(null);
                randomNumber.setText(null);
            }
        });
    }

    public void youClickedMe(View view) {

        Button btn = findViewById(R.id.buttonNo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, YUCLICKME.class));
            }
        });
    }
}
