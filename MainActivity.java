package com.example.ameeshashrivastav.test_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView disp, subdisp;
    Button b;

    double result = 0, operand1 = 0, operand2 = 0;
    int operator = 0, flag = 0;
    String str, str1, str2;

    public void clickce(View view){

        disp = (TextView)findViewById(R.id.display);
        subdisp = (TextView)findViewById(R.id.subs);
        result = 0;
        flag = 0;
        operand1 = 0;
        operand2 = 0;
        operator = 0;
        disp.setText("");
        subdisp.setText("");
    }


    public void click(View view){
        b = (Button)findViewById(view.getId());
        disp = (TextView)findViewById(R.id.display);
        subdisp = (TextView)findViewById(R.id.subs);
        if(operator == 1){
            subdisp.setText(""+disp.getText());
            disp.setText("");
            operator = 2;
        }
        disp.setText(""+disp.getText()+b.getText());

    }

    public void back(View view){
        b = (Button) findViewById(view.getId());
        disp = (TextView)findViewById(R.id.display);
        subdisp = (TextView)findViewById(R.id.subs);
        if (disp.getText().toString().startsWith("=")){
            subdisp.setText(str1);
            disp.setText(str2);
            operator = 2;
        }
        else {
            str = disp.getText().toString();
            disp.setText(str.substring(0, str.length() - 1));
        }
        if (operator == 1)
            operator = 0;
        else if (operator == 2){
            if (disp.getText().toString().isEmpty()){
                disp.setText(subdisp.getText());
                subdisp.setText("");
                operator = 1;
            }
        }
    }

    public void calculate(View view){

        b = (Button) findViewById(view.getId());
        disp = (TextView)findViewById(R.id.display);
        subdisp = (TextView)findViewById(R.id.subs);
        if(operator == 2){
            operand2 = Float.parseFloat(disp.getText().toString());
            if (flag == R.id.plus) {
                result = operand1 + operand2;
            } else if (flag == R.id.minus) {
                result = operand1 - operand2;
            } else if (flag == R.id.mul) {
                result = operand1*operand2;
            } else if (flag == R.id.div && operand2!=0) {
                result = operand1 / operand2;
            } else if (flag == R.id.mod) {
                result = operand1 % operand2;
            }
            str1 = subdisp.getText().toString();
            str2 = disp.getText().toString();
            subdisp.setText(""+subdisp.getText()+disp.getText());
            DecimalFormat dm = new DecimalFormat("#0.00");
            disp.setText(dm.format(result));
        }
        if(disp.getText().toString().isEmpty()){
            disp.setText(""+b.getText());
        }
        else {

            if (disp.getText().toString().startsWith("=")){
                operand1 = Float.parseFloat(disp.getText().toString().substring(1));
            }
            else
                operand1 = Float.parseFloat(disp.getText().toString());
            Log.i("Haa","Pahunch gaya behen");
            if (b.getId()== R.id.equals) {
                if(flag == R.id.div && operand2 == 0)
                    disp.setText("error");
                else
                    disp.setText("" + b.getText() + disp.getText());
            }
            else
                disp.setText(""+disp.getText()+b.getText());

            operator = 1;
            flag = b.getId();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disp  = (TextView)findViewById(R.id.display);
        disp.setText("");

    }
}
