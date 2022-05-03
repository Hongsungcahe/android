package com.example.ex0425;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connection conn = DriverManager.getConnection();
        //파이어베이스 데이터베이스 객체 생성
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //데이터 베이스 내 데이터를 참조하는 객체
        //해당 참조경로가 없는 경우 -> 새롭게 생성
        //참조 경로가 있을 경우 -> 데이터에 접근
        DatabaseReference myRef = database.getReference("message");

        //랜덤키를 생성하여 데이터를 저장

        //데이터 저장
        //myRef.setValue(new PersonVO("홍0동",25,true));
        //myRef.setValue("Hello, World!");
        myRef.push().setValue(new PersonVO("홍0동",25,true));

        // message경로 안에 여러개의 데이터를 읽어와야 할 경우
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                PersonVO value = snapshot.getValue(PersonVO.class);
                Log.d(TAG,"value is : "+value);
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        // Read from the database
        // 데이터베이스 내 변경사항이 발생했을 때(이벤트)
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //getValue(클래스타입) -> 클래스타입에 맞춰 데이터를 읽어오는 메소드
                //String value = dataSnapshot.getValue(String.class);
                PersonVO value = dataSnapshot.getValue(PersonVO.class);
                Log.d(TAG, "Value is: " + value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}