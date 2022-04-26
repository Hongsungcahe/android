package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    TextView result;
    Button btn1,btn2,btn3,btn4;
    EditText num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        result = findViewById(R.id.result);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int num3 = Integer.parseInt(num1.getText().toString());
        int num4 = Integer.parseInt(num2.getText().toString());
        if(id == R.id.btn1){
            result.setText("연산의 결과는 : "+(num3+num4));
        }else if(id == R.id.btn2) {
            result.setText("연산의 결과는 : "+(num3-num4));
        }else if(id == R.id.btn3){
            result.setText("연산의 결과는 : "+(num3*num4));
        }else{
            result.setText("연산의 결과는 : "+(num3/num4));
        }

    }
}