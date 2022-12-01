package com.example.roommate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuestionActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;                                             // 파이어베이스 인증처리
    private DatabaseReference mDatabaseRef;                                         // 실시간 데이터베이스
    private Button btn_endReg;                                                      // 회원가입 버튼
    private RadioGroup dorm, smoke, exercise, clean, eatIn, sleepHap, game,
                        alcohol, when_shower, hot, cold, study_place;               // 라디오 그룹
    private RadioButton yangJin, yangSung, gaeSung, yesSmoke, noSmoke, yesExercise,
                        noExercise, yesClean, noClean, yesEat, noEat, yesHap, noHap,
                        yesGame, noGame, yesAlcohol, noAlcohol, morning, evening,
                        veryHot, middleHot, notHot, veryCold, middleCold, notCold,
                        dormitory, ectDormitory;               // 라디오 버튼
    private Spinner spi_wakeup, spi_sleep, spi_floor, spi_exam, spi_shower, spi_goHome, spi_alcPeriod; // 스피너 그룹
    private String str_dorm, str_smoke, str_exercise, str_clean, str_eatIn,
                        str_sleepHap, str_game, str_alcohol, str_when_shower, str_hot,
                        str_cold, str_study_place, str_wakeup, str_sleep, str_floor,
                        str_exam, str_shower, str_goHome, str_alcPeriod;                           // 라디오, 스피너 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Roommate");

        dorm = findViewById(R.id.dorm);
        yangJin = findViewById(R.id.yangJin);
        yangSung = findViewById(R.id.yangSung);
        gaeSung = findViewById(R.id.gaeSung);

        smoke = findViewById(R.id.smoke);
        yesSmoke = findViewById(R.id.yesSmoke);
        noSmoke = findViewById(R.id.noSmoke);

        exercise = findViewById(R.id.exercise);
        yesExercise = findViewById(R.id.yesExercise);
        noExercise = findViewById(R.id.noExercise);

        clean = findViewById(R.id.clean);
        yesClean = findViewById(R.id.yesClean);
        noClean = findViewById(R.id.noClean);

        eatIn = findViewById(R.id.eatIn);
        yesEat = findViewById(R.id.yesEat);
        noEat = findViewById(R.id.noEat);

        sleepHap = findViewById(R.id.sleepHab);
        yesHap = findViewById(R.id.yesHap);
        noHap = findViewById(R.id.noHap);

        game = findViewById(R.id.game);
        yesGame = findViewById(R.id.yesGame);
        noGame = findViewById(R.id.noGame);

        alcohol = findViewById(R.id.alcohol);
        yesAlcohol = findViewById(R.id.yesAlcohol);
        noAlcohol = findViewById(R.id.noAlcohol);

        dorm = findViewById(R.id.dorm);
        yangJin = findViewById(R.id.yangJin);
        yangSung = findViewById(R.id.yangSung);

        spi_wakeup = findViewById(R.id.spi_wakeup);
        spi_sleep = findViewById(R.id.spi_sleep);
        spi_floor = findViewById(R.id.spi_floor);
        spi_exam = findViewById(R.id.spi_exam);
        spi_shower = findViewById(R.id.spi_shower);

        when_shower = findViewById(R.id.when_shower);
        morning = findViewById(R.id.morning);
        evening = findViewById(R.id.evening);

        hot = findViewById(R.id.hot);
        veryHot = findViewById(R.id.veryHot);
        middleHot = findViewById(R.id.middleHot);
        notHot = findViewById(R.id.notHot);

        cold = findViewById(R.id.cold);
        veryCold = findViewById(R.id.veryCold);
        middleCold = findViewById(R.id.middleCold);
        notCold = findViewById(R.id.notCold);

        study_place = findViewById(R.id.study_place);
        dormitory = findViewById(R.id.dormitory);
        ectDormitory = findViewById(R.id.ectDormitory);

        spi_goHome = findViewById(R.id.spi_goHome);
        spi_alcPeriod = findViewById(R.id.spi_alcPeriod);

        dorm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//기숙사 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.yangJin) {
                    str_dorm = yangJin.getText().toString();
                }else if(i == R.id.yangSung){
                    str_dorm = yangSung.getText().toString();
                }else if(i == R.id.gaeSung){
                    str_dorm = gaeSung.getText().toString();
                }
            }
        });

        smoke.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//흡연 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.yesSmoke) {
                    str_smoke = yesSmoke.getText().toString();
                }else if(i == R.id.noSmoke){
                    str_smoke = noSmoke.getText().toString();
                }
            }
        });

        exercise.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//운동 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.yesExercise) {
                    str_exercise = yesExercise.getText().toString();
                }else if(i == R.id.noExercise){
                    str_exercise = noExercise.getText().toString();
                }
            }
        });

        clean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//청소 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.yesClean) {
                    str_clean = yesClean.getText().toString();
                }else if(i == R.id.noClean){
                    str_clean = noClean.getText().toString();
                }
            }
        });

        eatIn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//실내 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.eatIn) {
                    str_eatIn = yesEat.getText().toString();
                }else if(i == R.id.noEat){
                    str_eatIn = noEat.getText().toString();
                }
            }
        });

        sleepHap.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//잠버릇 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.yesHap) {
                    str_sleepHap = yesHap.getText().toString();
                }else if(i == R.id.noHap){
                    str_sleepHap = noHap.getText().toString();
                }
            }
        });

        game.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//게임 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.yesGame) {
                    str_game = yesGame.getText().toString();
                }else if(i == R.id.noGame){
                    str_game = noGame.getText().toString();
                }
            }
        });

        alcohol.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//음주 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.yesAlcohol) {
                    str_alcohol = yesAlcohol.getText().toString();
                }else if(i == R.id.noAlcohol){
                    str_alcohol = noAlcohol.getText().toString();
                }
            }
        });

        str_wakeup = spi_wakeup.getSelectedItem().toString();//기상시간 선택
        str_sleep = spi_sleep.getSelectedItem().toString();//취침시간 선택
        str_floor = spi_floor.getSelectedItem().toString();//선호층수 선택
        str_exam = spi_exam.getSelectedItem().toString();//반수/편입 선택
        str_shower = spi_shower.getSelectedItem().toString();//샤워시간 선택

        when_shower.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//샤워시간대 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.morning) {
                    str_when_shower = morning.getText().toString();
                }else if(i == R.id.evening){
                    str_when_shower = evening.getText().toString();
                }
            }
        });

        hot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//더위 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.veryHot) {
                    str_hot = veryHot.getText().toString();
                }else if(i == R.id.middleHot){
                    str_hot = middleHot.getText().toString();
                }else if(i == R.id.notHot){
                    str_hot = notHot.getText().toString();
                }
            }
        });

        cold.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//추위 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.veryCold) {
                    str_cold = veryCold.getText().toString();
                }else if(i == R.id.middleCold){
                    str_cold = middleCold.getText().toString();
                }else if(i == R.id.notCold){
                    str_cold = notCold.getText().toString();
                }
            }
        });

        study_place.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//더위 선택
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.dormitory) {
                    str_study_place = dormitory.getText().toString();
                }else if(i == R.id.ectDormitory){
                    str_study_place = ectDormitory.getText().toString();
                }
            }
        });

        str_goHome = spi_goHome.getSelectedItem().toString();//반수/편입 선택
        str_alcPeriod = spi_alcPeriod.getSelectedItem().toString();//샤워시간 선택

        btn_endReg=findViewById(R.id.btn_endReg);


        btn_endReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(str_dorm.toString().length() == 0 || str_smoke.toString().length() == 0 ||
                        str_exercise.toString().length() == 0 || str_clean.toString().length() == 0 ||
                        str_eatIn.toString().length() == 0 || str_sleepHap.toString().length() == 0 ||
                        str_game.toString().length() == 0 || str_alcohol.toString().length() == 0) {
                    Toast.makeText(QuestionActivity.this, "필수체크리스트를 확인해 주십시오", Toast.LENGTH_SHORT).show();
                }else{
                    String strDorm = str_dorm.toString();
                    String strSmoke = str_smoke.toString();
                    String strExercise = str_exercise.toString();
                    String strClean = str_clean.toString();
                    String strEatIn = str_eatIn.toString();
                    String strSleepHap = str_sleepHap.toString();
                    String strGame = str_game.toString();
                    String strAlcohol = str_alcohol.toString();
                    String strWakeUp = str_wakeup.toString();
                    String strSleep = str_sleep.toString();
                    String strFloor = str_floor.toString();
                    String strExam = str_exam.toString();
                    String strShower = str_shower.toString();
                    String strWhenShower = str_when_shower.toString();
                    String strHot = str_hot.toString();
                    String strCold = str_cold.toString();
                    String strStudyPlace = str_study_place.toString();
                    String strGoHome = str_goHome.toString();
                    String strAlcPeriod = str_alcPeriod.toString();

                }


                Intent intent=new Intent(QuestionActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}