package com.example.roommate;

// 사용자 계정 정보 모델 클래스
public class UserAccount {

    private String idToken; // Firebase Uid(고유 토큰 정보)
    private String EmailId; // 이메일 아이디
    private String password;  // 비밀번호
    private String Name; //이름
    private String Age; //나이
    private String Gen; //성별

    private String Wakeup;// 기상시간
    private String Sleep;//수면시간
    private String Floor;//선호층수
    private String Exam;//반수/편입
    private String Shower;//샤워시간
    private String WhenShower;//샤워시간대
    private String Warm;//더위
    private String Cold;//추위
    private String Study;//공부장소
    private String Home;//본가방문주기
    private String Alcohol;//음주여부
    private String AlcPeriod;//음주빈도
    private String Game;//게임
    private String Dorm;//기숙사
    private String SleepHap;//잠버릇
    private String Smoke;//흡연
    private String Exercise;//운동
    private String Clean;//청소
    private String EatIn;//실내취식


    public UserAccount() { }//빈 생성자 만들기

    //모델클래스에 입력 출력을 하기위한 설정
    //Alt+insert

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGen() {
        return Gen;
    }

    public void setGen(String gen) {
        Gen = gen;
    }

    public String getWakeup() {
        return Wakeup;
    }

    public void setWakeup(String wakeup) {
        Wakeup = wakeup;
    }

    public String getSleep() {
        return Sleep;
    }

    public void setSleep(String sleep) {
        Sleep = sleep;
    }

    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        Floor = floor;
    }

    public String getExam() {
        return Exam;
    }

    public void setExam(String exam) {
        Exam = exam;
    }

    public String getShower() {
        return Shower;
    }

    public void setShower(String shower) {
        Shower = shower;
    }

    public String getWhenShower() {
        return WhenShower;
    }

    public void setWhenShower(String whenShower) {
        WhenShower = whenShower;
    }

    public String getWarm() {
        return Warm;
    }

    public void setWarm(String warm) {
        Warm = warm;
    }

    public String getCold() {
        return Cold;
    }

    public void setCold(String cold) {
        Cold = cold;
    }

    public String getStudy() {
        return Study;
    }

    public void setStudy(String study) {
        Study = study;
    }

    public String getHome() {
        return Home;
    }

    public void setHome(String home) {
        Home = home;
    }

    public String getAlcohol() {
        return Alcohol;
    }

    public void setAlcohol(String alcohol) {
        Alcohol = alcohol;
    }

    public String getAlcPeriod() {
        return AlcPeriod;
    }

    public void setAlcPeriod(String alcPeriod) {
        AlcPeriod = alcPeriod;
    }

    public String getGame() {
        return Game;
    }

    public void setGame(String game) {
        Game = game;
    }

    public String getDorm() {
        return Dorm;
    }

    public void setDorm(String dorm) {
        Dorm = dorm;
    }

    public String getSleepHap() {
        return SleepHap;
    }

    public void setSleepHap(String sleepHap) {
        SleepHap = sleepHap;
    }

    public String getSmoke() {
        return Smoke;
    }

    public void setSmoke(String smoke) {
        Smoke = smoke;
    }

    public String getExercise() {
        return Exercise;
    }

    public void setExercise(String exercise) {
        Exercise = exercise;
    }

    public String getClean() {
        return Clean;
    }

    public void setClean(String clean) {
        Clean = clean;
    }

    public String getEatIn() {
        return EatIn;
    }

    public void setEatIn(String eatIn) {
        EatIn = eatIn;
    }
}
