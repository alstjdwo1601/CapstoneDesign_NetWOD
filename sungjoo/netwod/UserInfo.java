package com.example.netwod;

import java.util.ArrayList;

public class UserInfo {

    public WODrecord wodrecord; //���ø��� �ִ� ������ ������ �� ���
    public ArrayList<WOD> userwodlist; //�͵� �����Ҷ� ����Ʈ(�� ���� ����)

    private String UserName;
    private String UserAge;
    private String UserWeight;
    private String UserHeight;
    private String User_NumOfTraining;

    public int getCurrentwodindex() {
        return currentwodindex;
    }

    public void setCurrentwodindex(int currentwodindex) {
        this.currentwodindex = currentwodindex;
    }

    private int currentwodindex=0;
    public UserInfo(){
        this.wodrecord=new WODrecord(); //���ø��� �ִ� ������ ������ �� ���
        this.userwodlist=new ArrayList<WOD>(); //�͵� �����Ҷ� ����Ʈ(�� ���� ����)

    }


    //� �ⱸ�� �ִ��� ������
    private boolean Dumbbell;
    private boolean Body;
    private boolean Kettlebell;
    private boolean Barbell;
    private boolean WallBall;
    private boolean Box;
    private boolean Jumprope;
    private boolean PullUpBar;


    //���� ��� ���ھ�
    private String avg_WODlevel;
    private String avg_round_reps;
    private String avg_time;
    private String avg_score;
    private String avg_time_amrep;

    public String getAvg_time_amrep() {
        return avg_time_amrep;
    }

    public void setAvg_time_amrep(String avg_time_amrep) {
        this.avg_time_amrep = avg_time_amrep;
    }

    public String getAvg_WODlevel() { return avg_WODlevel; }

    public void setAvg_WODlevel(String avg_WODlevel) { this.avg_WODlevel = avg_WODlevel; }

    public String getAvg_round_reps() { return avg_round_reps; }

    public void setAvg_round_reps(String avg_round_reps) { this.avg_round_reps = avg_round_reps; }

    public String getAvg_time() { return avg_time; }

    public void setAvg_time(String avg_time) { this.avg_time = avg_time; }

    public String getAvg_score() { return avg_score; }

    public void setAvg_score(String avg_score) { this.avg_score = avg_score; }



    public WODrecord getWodrecord() {
        return wodrecord;
    }

    public void setWodrecord(WODrecord wodrecord) {
        this.wodrecord = wodrecord;
    }

    public ArrayList<WOD> getUserwodlist() {
        return userwodlist;
    }

    public void setUserwodlist(ArrayList<WOD> userwodlist) {
        this.userwodlist = userwodlist;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserAge() {
        return UserAge;
    }

    public void setUserAge(String userAge) {
        UserAge = userAge;
    }

    public String getUserWeight() {
        return UserWeight;
    }

    public void setUserWeight(String userWeight) {
        UserWeight = userWeight;
    }

    public String getUserHeight() {
        return UserHeight;
    }

    public void setUserHeight(String userHeight) {
        UserHeight = userHeight;
    }

    public String getUser_NumOfTraining() {
        return User_NumOfTraining;
    }

    public void setUser_NumOfTraining(String user_NumOfTraining) {
        User_NumOfTraining = user_NumOfTraining;
    }

    public boolean isDumbbell() {
        return Dumbbell;
    }

    public void setDumbbell(boolean dumbbell) {
        Dumbbell = dumbbell;
    }

    public boolean isBody() {
        return Body;
    }

    public void setBody(boolean body) {
        Body = body;
    }

    public boolean isKettlebell() {
        return Kettlebell;
    }

    public void setKettlebell(boolean kettlebell) {
        Kettlebell = kettlebell;
    }

    public boolean isBarbell() {
        return Barbell;
    }

    public void setBarbell(boolean barbell) {
        Barbell = barbell;
    }

    public boolean isWallBall() {
        return WallBall;
    }

    public void setWallBall(boolean wallBall) {
        WallBall = wallBall;
    }

    public boolean isBox() {
        return Box;
    }

    public void setBox(boolean box) {
        Box = box;
    }

    public boolean isJumprope() {
        return Jumprope;
    }

    public void setJumprope(boolean jumprope) {
        Jumprope = jumprope;
    }

    public boolean isPullUpBar() {
        return PullUpBar;
    }

    public void setPullUpBar(boolean pullUpBar) {
        PullUpBar = pullUpBar;
    }

}