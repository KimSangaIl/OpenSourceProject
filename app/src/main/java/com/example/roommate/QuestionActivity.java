package com.example.roommate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roommate.databinding.ActivityQuestionBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class QuestionActivity extends AppCompatActivity {
    private ActivityQuestionBinding binding;
    private FirebaseAuth mFirebaseAuth;                                             // 파이어베이스 인증처리
    private FirebaseDatabase mDatabase;                                         // 실시간 데이터베이스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 타이틀 바 내용 바꾸기
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("문답표 작성하기");

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();

        binding.btnEndReg.setOnClickListener(v -> submit());
    }

    private void submit() {
        String dorm = getSelectedRadioButtonTitle(binding.dorm);
        String smoke = getSelectedRadioButtonTitle(binding.smoke);
        String exercise = getSelectedRadioButtonTitle(binding.exercise);
        String clean = getSelectedRadioButtonTitle(binding.clean);
        String eatIn = getSelectedRadioButtonTitle(binding.eatIn);
        String sleepHap = getSelectedRadioButtonTitle(binding.sleepHab);
        String game = getSelectedRadioButtonTitle(binding.game);
        String alcohol = getSelectedRadioButtonTitle(binding.alcohol);

        if (dorm == null || smoke == null || exercise == null || clean == null ||
                eatIn == null || sleepHap == null || game == null || alcohol == null) {
            Toast.makeText(QuestionActivity.this, "필수체크리스트를 확인해 주십시오", Toast.LENGTH_SHORT).show();
            return;
        }

        String wakeUp = (String) binding.spiWakeup.getSelectedItem();
        String sleep = (String) binding.spiSleep.getSelectedItem();
        String floor = (String) binding.spiFloor.getSelectedItem();
        String exam = (String) binding.spiExam.getSelectedItem();
        String shower = (String) binding.spiShower.getSelectedItem();
        String whenShower = getSelectedRadioButtonTitle(binding.whenShower);
        String warm = getSelectedRadioButtonTitle(binding.hot);
        String cold = getSelectedRadioButtonTitle(binding.cold);
        String study = getSelectedRadioButtonTitle(binding.studyPlace);
        String home = (String) binding.spiGoHome.getSelectedItem();
        String alcPeriod = (String) binding.spiAlcPeriod.getSelectedItem();

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("dorm", dorm);
        data.put("smoke", smoke);
        data.put("exercise", exercise);
        data.put("clean", clean);
        data.put("eatIn", eatIn);
        data.put("sleepHap", sleepHap);
        data.put("game", game);
        data.put("alcohol", alcohol);
        data.put("wakeup", wakeUp);
        data.put("sleep", sleep);
        data.put("floor", floor);
        data.put("exam", exam);
        data.put("shower", shower);
        data.put("whenShower", whenShower);
        data.put("warm", warm);
        data.put("cold", cold);
        data.put("study", study);
        data.put("home", home);
        data.put("alcPeriod", alcPeriod);

        mDatabase.getReference()
                .child("Roommate")
                .child("UserAccount")
                .child(mFirebaseAuth.getUid())
                .updateChildren(data);
        startActivity(new Intent(QuestionActivity.this, MainActivity.class));
        finishAffinity();
    }

    private String getSelectedRadioButtonTitle(RadioGroup group) {
        int id = group.getCheckedRadioButtonId();
        if (id == -1) return null;
        return ((RadioButton) group.findViewById(id)).getText().toString();
    }
}