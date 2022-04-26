package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity5 extends AppCompatActivity {
    Button btn_change;
    ImageView img1,img2;
    TextView text_change1,text_change2;
    int i=0;
    int j = 0;
    int score1 = 0;
    int score2 = 0;
    int[] imgArr = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        btn_change = findViewById(R.id.btn_change);
        text_change1 = findViewById(R.id.textChange);
        text_change2 = findViewById(R.id.textChange3);
        String a = String.valueOf(score1);
        String b = String.valueOf(score2);
        text_change1.setText(a);
        text_change2.setText(b);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                i = rnd.nextInt(6);
                j = rnd.nextInt(6);

                img1.setImageResource(imgArr[i]);
                img2.setImageResource(imgArr[j]);

                if(i>j){
                    ++score1;
                    String a = String.valueOf(score1);
                    text_change1.setText(a);
                    Toast.makeText(MainActivity5.this,
                            "왼쪽 승리!",
                            Toast.LENGTH_SHORT).show();
                }else if(i<j){
                    ++score2;
                    String b = String.valueOf(score2);
                    text_change2.setText(b);
                    Toast.makeText(MainActivity5.this,
                            "오른쪽 승리!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity5.this,
                            "무승부!",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}