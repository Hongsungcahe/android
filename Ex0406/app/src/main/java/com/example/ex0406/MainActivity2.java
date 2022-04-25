package com.example.ex0406;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    Button btn_red;
    Button btn_green;
    Button btn_blue;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_red = findViewById(R.id.btn_red);
        btn_green = findViewById(R.id.btn_green);
        btn_blue = findViewById(R.id.btn_blue);
        layout = findViewById(R.id.layout);

        btn_red.setOnClickListener(this);
        btn_green.setOnClickListener(this);
        btn_blue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int view_id = view.getId();
        if(view_id == R.id.btn_red){
            layout.setBackgroundColor(Color.RED);
        }else if(view_id == R.id.btn_green){
            layout.setBackgroundColor(Color.GREEN);
        }else if(view_id == R.id.btn_blue){
            layout.setBackgroundColor(Color.BLUE);
        }
    }
}