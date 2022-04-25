package com.example.ex0404;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //TextVeiw를 참조하는 객체 생성 => View 초기화
        TextView tvData = findViewById(R.id.tvData);

        tvData.setText("textView 초기화 ");
        //1. 정해진 배경색으로 변경하는 방법
        /*        tvData.setBackgroundColor(Color.RED);*/
        //2. 16진수로 색상 적용
        tvData.setBackgroundColor(Color.parseColor("#ff0000"));

        // TextView의 글자색 변경
        tvData.setTextColor(Color.WHITE);
    }
}