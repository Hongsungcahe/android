package com.example.ex0428;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MoreActivity extends AppCompatActivity {
    ImageView[] moreArr = new ImageView[9];
    TextView tv_time, tv_count;
    boolean isPlaying = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        tv_time = findViewById(R.id.tv_Time);
        tv_count = findViewById(R.id.tv_Count);

        //동적으로 리소스ID 접근 후 ImageView 초기화
        for(int i = 0; i < moreArr.length; i++) {
            final int pos = i;

            int resId = getResources().getIdentifier("img" + (i+1), "id", getPackageName());
            moreArr[i] = findViewById(resId);

            //imageView에 tag 설정
            //tag : View에 대한 상태값 저장
            moreArr[i].setTag("down");

        MoreMoveThread thread = new MoreMoveThread(i);
        thread.start();
        TimerThread thread1 = new TimerThread(tv_time);
        thread1.start();

        //두더지(ImageView)를 클릭했을 때
        moreArr[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(tv_count.getText().toString());
                String status = moreArr[pos].getTag().toString();
                if (status.equals("up")){
                    count+=1;
                }else{
                    if(count > 0){
                        count-=1;
                    }
                }
                tv_count.setText(String.valueOf(count));
            }
        });
        }
    }//end

    class TimerThread extends Thread {
        TimerHandler handler = new TimerHandler();
        TextView tv;
        public TimerThread(TextView tv){
            this.tv = tv;
        }
        @Override
        public void run() {
            //실행할 로직 정의
            int time = Integer.parseInt(tv_time.getText().toString());
            for (int i = time; i >= 0; i--) {
                //Handler에 값을 전달 -> Message 객체
                Message msg = new Message();
                msg.arg1 = i;
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
            if(count == 0){
                isPlaying = false;
            }
        }
    }
    class MoreMoveThread extends Thread{
        MoreMoveHandler handler = new MoreMoveHandler();

        int more_pos;
        public MoreMoveThread(int more_pos){

            this.more_pos = more_pos;
        }
        @Override
        public void run() {
            Random rd = new Random();
            //저장해야 할 데이터: 두더지 번호, 변경할 두더지 이미지, 두더지 상태
            int downTime = rd.nextInt(5000);
            int upTime = rd.nextInt(5000);
            while (isPlaying) {
                try {
                    Thread.sleep(upTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            Message msg = new Message();
            msg.arg1 = more_pos;
            msg.arg2 = R.drawable.up;
            msg.obj = "up";

            handler.sendMessage(msg);
            try {
                Thread.sleep(downTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg = new Message();
            msg.arg1 = more_pos;
            msg.arg2 = R.drawable.down;
            msg.obj = "down";
            handler.sendMessage(msg);
        }
        }
    }//end
    class MoreMoveHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            int pos = msg.arg1;
            int img = msg.arg2;
            String status = (String)msg.obj;

            moreArr[pos].setImageResource(img);
            moreArr[pos].setTag(status);//up,down 상태 저장
        }
    }//end
}
