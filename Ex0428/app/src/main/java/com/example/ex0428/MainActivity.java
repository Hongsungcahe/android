package com.example.ex0428;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn_start, btn_start2;
    TextView tv_number, tv_number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_number = findViewById(R.id.number);
        btn_start = findViewById(R.id.start_btn);

        tv_number2 = findViewById(R.id.number2);
        btn_start2 = findViewById(R.id.start_btn2);





        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Thread 객체 생성
                TimerThread thread = new TimerThread(tv_number);
                thread.start();// Thread 동작시키는
                btn_start.setEnabled(false);
            }
        });
        btn_start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Thread 객체 생성
                TimerThread thread2 = new TimerThread(tv_number2);
                thread2.start();
                btn_start2.setEnabled(false);
            }
        });

    }

    //Thread(스레드)
    // : 하나의 프로세스 내에서 작업을 처리하는 작은 단위
    // : Main Thread 이외에 작업을 별도로 처리할 때 활용

    // Main Thread의 역할
    //: UI를 업데이트하는 역할
    class TimerThread extends Thread {
        TimerHandler handler = new TimerHandler();
        TextView tv;
        public TimerThread(TextView tv){
            this.tv = tv;
        }
        @Override
        public void run() {
            //실행할 로직 정의
            for (int i = 0; i < 10; i++) {
                Log.d("TimmerThread", "카운트 : " + (i + 1));
                //tv_number.setText(String.valueOf(i+1));

                //Handler에 값을 전달 -> Message 객체
                Message msg = new Message();
                msg.arg1 = i + 1;
                msg.obj = tv;// TextView -> object로 업캐스팅되서 저장
                //Message 객체 전송
                handler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class TimerThread2 extends Thread {
        TimerHandler2 handler2 = new TimerHandler2();
        TextView tv;

        @Override
        public void run() {

            //실행할 로직 정의
            for (int i = 0; i < 10; i++) {
                Log.d("TimmerThread", "카운트 : " + (i + 1));
                //tv_number.setText(String.valueOf(i+1));

                //Handler에 값을 전달 -> Message 객체
                Message msg = new Message();
                msg.arg1 = i + 1;

                //Message 객체 전송
                handler2.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }//end class

        class TimerHandler extends Handler {
            @Override
            public void handleMessage(@NonNull Message msg) {
                //sub Thread에서 처리한 결과를 UI에 업데이트할 때
                //handlerMessage() 안에 정의
                int count = msg.arg1;
                TextView tv = (TextView) msg.obj;//object 타입으로 저장된 TextView 객체를 다운캐스팅
                //tv_number.setText(String.valueOf(count));

                //TimerThread객체 생성 시 넘겨받은 TextView객체에 내용을 업데이트
                tv.setText(String.valueOf(count));
            }
        }

        class TimerHandler2 extends Handler {
            @Override
            public void handleMessage(@NonNull Message msg) {
                //sub Thread에서 처리한 결과를 UI에 업데이트할 때
                //handlerMessage() 안에 정의
                int count = msg.arg1;

                //tv_number.setText(String.valueOf(count));

                //TimerThread객체 생성 시 넘겨받은 TextView객체에 내용을 업데이트
                tv_number2.setText(String.valueOf(count));
            }
        }

    }
