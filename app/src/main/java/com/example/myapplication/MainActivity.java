package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;
    char op;
    String num1 = null;
    String num2 = null;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.resultTextView);
    }

    public void numButtonClick(View view) {
        if (!(view instanceof Button)) {
            return;
        }

        if(flag == 1){
            rest();
        }else {

            Button b = (Button) view;
            String str = b.getText().toString();
            result.append(str);
        }
    }

    public void opButtonClick(View view) {
        if (!(view instanceof Button)) {
            return;
        }

        if(flag == 1){
            rest();
        }else {
            Button b = (Button) view;

            op = b.getText().toString().charAt(0);
            num1 = result.getText().toString();
            result.setText("");
        }

    }

    public void equButtonClick(View view) {
        if (!(view instanceof Button)) {
            return;
        }

        num2 = result.getText().toString();

        if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
            flag = 1;
            double tempResult = 0;

            int intNum1 = Integer.parseInt(num1);
            int intNum2 = Integer.parseInt(num2);


            switch (op) {
                case '+':
                    tempResult = intNum1 + intNum2;
                    break;
                case '-':
                    tempResult = intNum1 - intNum2;
                    break;
                case '*':
                    tempResult = intNum1 * intNum2;
                    break;
                case '/':
                    if (intNum2 != 0) {
                        tempResult = intNum1 / intNum2;
                    }else{
                        Toast.makeText(this, "Error - can't be divided by 0", Toast.LENGTH_SHORT).show();
                        rest();
                    }
                    break;
            }

            result.setText(String.valueOf(tempResult));
            num1 =null;
            num2 = null;

        }else{
            Toast.makeText(this, "Error - Please enter Number and Operator", Toast.LENGTH_SHORT).show();
            rest();
        }
    }

    public void acButtonClick(View view) {
        if (!(view instanceof Button)) {
            return;
        }

        rest();
    }

    public void rest(){
        result.setText("");
        num1= null;
        num2 = null;
        flag =0;
    }
}
