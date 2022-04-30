package com.example.ex0421;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class JoinActivity extends AppCompatActivity {
    Button reg_join;
    EditText regId, regPw, regNick;

    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        reg_join = findViewById(R.id.join_join);

        regId = findViewById(R.id.join_id);
        regNick = findViewById(R.id.join_nick);
        regPw = findViewById(R.id.join_pw);

        queue = Volley.newRequestQueue(JoinActivity.this);

        reg_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int method = Request.Method.POST;
                String server_url ="http://172.30.1.36:8085/android/Join";

                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(JoinActivity.this,
                                        "요청성공",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(JoinActivity.this,
                                "요청실패"+error.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                 }
                ){
                    //POST 방식으로 데이터 전송할 때 사용하는 메소드
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        //Key와 value 형태(타입 변경 가능)로 데이터를 저장하는 자료구조->Map
                        Map<String,String> param = new HashMap<>();
                        param.put("id",regId.getText().toString());
                        param.put("pw",regPw.getText().toString());
                        param.put("nick",regNick.getText().toString());

                        return param;
                    }
                };

                queue.add(request);

            }
        });
    }
}