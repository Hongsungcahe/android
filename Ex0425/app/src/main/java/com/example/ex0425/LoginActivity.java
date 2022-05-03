package com.example.ex0425;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText UserPw;
    EditText UserId;
    Button btnlog;
    String[] userIdList = {"smhrd","mj"};
    String[] userPwList = {"4321","1234"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserId = findViewById(R.id.edtUserId);
        UserPw = findViewById(R.id.edtUserPw);
        btnlog = findViewById(R.id.btnLogin);

            btnlog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String id = UserId.getText().toString();
                    String pw = UserPw.getText().toString();
                    for(int i =0; i<userIdList.length; i++){

                        if(id.equals(userIdList[i]) && pw.equals(userPwList[i])){
                            Intent intent = new Intent(LoginActivity.this,ChatActivity.class);
                            intent.putExtra("id",id);

                            startActivity(intent);
                            break;
                        }
                        if(i==userIdList.length-1){
                            Toast.makeText(LoginActivity.this,
                                    "다시 로그인해주세요",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            });
        }
    }
