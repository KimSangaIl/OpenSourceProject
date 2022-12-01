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
    private String Sleep;
    private String Floor;
    private String Exam;
    private String Shower;
    private String WhenShower;
    private String Warm;
    private String Cold;
    private String Study;
    private String Home;
    private String Alcohol;


    public UserAccount() { }//빈 생성자 만들기

    //모델클래스에 입력 출력을 하기위한 설정
    //Alt+insert

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String emailId) {
        EmailId = emailId;
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
}
