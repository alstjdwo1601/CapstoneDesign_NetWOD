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