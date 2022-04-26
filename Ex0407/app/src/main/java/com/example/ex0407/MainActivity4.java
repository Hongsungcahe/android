package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {
    Button btnPre,btnNext;
    ImageView img;
    int i=0;
    // 이미지 배열 생성
    int[] imgArr = {R.drawable.chunsik1,R.drawable.chunsik2,R.drawable.chunsik3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        img = findViewById(R.id.imageView2);
        img.setImageResource(imgArr[1]);
        btnNext = findViewById(R.id.btnNext);
        btnPre = findViewById(R.id.btnPre);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++i;
                if(i < imgArr.length) {
                img.setImageResource(imgArr[i]);
                }
                else {
                    i = 0;
                    img.setImageResource(imgArr[i]);
                }
            }
        });
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --i;
                if(i < 0) {
                    i = imgArr.length-1;
                    img.setImageResource(imgArr[i]);
                }
                else {
                    img.setImageResource(imgArr[i]);
                }
            }
        });
    }
}
