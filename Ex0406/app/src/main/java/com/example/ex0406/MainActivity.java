package com.example.ex0406;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// 인터페이스 구현을 통해 이벤트 적용
// : 유사한 기능을 구현할 때 사용
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //onClick에서 사용하기 위해 전역변수로 선언
    EditText edtMsg;
    TextView tvMsg;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView()로 생성된 이후에
        //findViewById() 메소드를 사용하여 view의 id값을 참조할 수 있다.
        tvMsg = findViewById(R.id.tvMsg );
        edtMsg = findViewById(R.id.edtMsg);
        layout = findViewById(R.id.layout);
        Button btn_Change = findViewById(R.id.btn_Change);
        Button btn_bgChange = findViewById(R.id.btnBgChange);

        //textView의 text 값을 접근 =>log.d()를 활용하여 출력
        //출력결과 : logcat창 or run창
        //결과값을 확인하거나 서버통신 데이터 확인할 때 사용
        Log.d("MainActivity_tvMsg",edtMsg.getText().toString());

        //onclick()가 동작되도록 Button객체에 이벤트 설정
        //this: onclicklistenner를 구현한 MainActivity를 가리킴
        btn_Change.setOnClickListener(this);
        btn_bgChange.setOnClickListener(this);
    }
    //View.OnClickListener 인터페이스를 사용하기위해 추상메서드
    @Override
    public void onClick(View view) {
        //이벤트가 발생한 View의 id값을 변수에 저장
        int viewId = view.getId();
        if(viewId == R.id.btn_Change){
            String msg = edtMsg.getText().toString();
            tvMsg.setText(msg);
        }else{
            layout.setBackgroundColor(Color.parseColor("#55ff0000"));
        }
    }
}