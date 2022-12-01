package com.example.roommate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class QuestionActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;                 // 파이어베이스 인증처리
    private DatabaseReference mDatabaseRef;             // 실시간 데이터베이스
    private Button btn_endreg;                          // 회원가입 버튼
    private RadioGroup rb_gender;                       // 성별 그룹
    private RadioButton rb_man, rb_woman;               // 남성, 여성
    private String str_result;                          // 성별값 저장




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        btn_endreg=findViewById(R.id.btn_endReg);       //오타?? btn_endreg로 하면 오류 발생합니다
        btn_endreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QuestionActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}