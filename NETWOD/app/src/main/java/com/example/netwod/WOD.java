package com.example.netwod;

import java.util.ArrayList;

class WOD{
    private String WODname;//ex) FRAN,고성주의 와드
    private String WODlevel;
    private String WODtype; //포타임, 암랩 등등

    //데드21,월볼21 + 데드15,월볼15 와드 예시
    private ArrayList<String> movement;//{데드,월볼,데드,월볼,데드,월볼}
    private ArrayList<String> movementnum;//={21,21,21,15,15,15};
    private ArrayList<String> weightlist;//각각 무게
    private ArrayList<String> equipment;// 사용한 기구

    public WOD(){
        this.movement=new ArrayList<String>();
        this.movementnum=new ArrayList<String>();
        this.weightlist=new ArrayList<String>();
        this.equipment=new ArrayList<String>();


    }
    public void clearWOD(){
        this.WODname="default";
        this.WODlevel="default";
        this.WODtype="default";
        this.movement.clear();;
        this.movementnum.clear();
        this.weightlist.clear();
        this.equipment.clear();

    }





    public String getWODlevel() {
        return WODlevel;
    }

    public void setWODlevel(String WODlevel) {
        this.WODlevel = WODlevel;
    }

    public String getWODname() {
        return WODname;
    }

    public void setWODname(String WODname) {
        this.WODname = WODname;
    }

    public String getWODtype() {
        return WODtype;
    }

    public void setWODtype(String WODtype) {
        this.WODtype = WODtype;
    }

    public ArrayList<String> getMovement() {
        return movement;
    }

    public void setMovement(ArrayList<String> movement) {
        this.movement = movement;
    }

    public ArrayList<String> getMovementnum() {
        return movementnum;
    }

    public void setMovementnum(ArrayList<String> movementnum) {
        this.movementnum = movementnum;
    }

    public ArrayList<String> getWeightlist() {
        return weightlist;
    }

    public void setWeightlist(ArrayList<String> weightlist) {
        this.weightlist = weightlist;
    }

    public ArrayList<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<String> equipment) {
        this.equipment = equipment;
    }




}
class WODrecord{
    public ArrayList<WOD> wodlist; //{프란,신디,민성재,김정훈}
    public ArrayList<String> scorelist; //{"70","80","75","60"}
    public ArrayList<String> recordlist; //{"4:32","3:53","2:10","6:34"}


    public WODrecord(){
        wodlist=new ArrayList<WOD>();
        scorelist=new ArrayList<String>();
        recordlist=new ArrayList<String>();

    }

    public ArrayList<WOD> getWodlist() {
        return wodlist;
    }

    public void setWodlist(ArrayList<WOD> wodlist) {
        this.wodlist = wodlist;
    }

    public ArrayList<String> getScorelist() {
        return scorelist;
    }

    public void setScorelist(ArrayList<String> scorelist) {
        this.scorelist = scorelist;
    }

    public ArrayList<String> getRecordlist() {
        return recordlist;
    }

    public void setRecordlist(ArrayList<String> recordlist) {
        this.recordlist = recordlist;
    }


}
class UserInfo {

    public WODrecord wodrecord; //템플릿에 있는 개인이 실제로 한 기록
    public ArrayList<WOD> userwodlist; //와드 선택할때 리스트(뭐 할지 고를지)

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
        this.wodrecord=new WODrecord(); //템플릿에 있는 개인이 실제로 한 기록
        this.userwodlist=new ArrayList<WOD>(); //와드 선택할때 리스트(뭐 할지 고를지)

    }


    //운동 기구가 있는지 없는지
    private boolean Dumbbell;
    private boolean Body;
    private boolean Kettlebell;
    private boolean Barbell;
    private boolean WallBall;
    private boolean Box;
    private boolean Jumprope;
    private boolean PullUpBar;


    //개인 평균 스코어
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