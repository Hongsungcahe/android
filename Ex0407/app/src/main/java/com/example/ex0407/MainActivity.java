package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2;
    TextView txt;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        txt = findViewById(R.id.textView);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int view_Id = view.getId();

        if(view_Id == R.id.btn_1){
            ++i;
            String a = String.valueOf(i);
            txt.setText(a);
        }else{
            i-=1;
            String a = String.valueOf(i);
            txt.setText(a);
        }
    }
}