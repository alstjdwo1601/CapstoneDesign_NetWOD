package com.example.netwod;


import java.util.ArrayList;



class WOD{
    private String WODname;//ex) FRAN,������ �͵�
    private String WODlevel;
    private String WODtype; //��Ÿ��, �Ϸ� ���
    //����21,����21 + ����15,����15 �͵� ����
    private ArrayList<String> movement;//{����,����,����,����,����,����}
    private ArrayList<String> movementnum;//={21,21,21,15,15,15};
    private ArrayList<String> weightlist;//���� ����
    private ArrayList<String> equipment;// ����� �ⱸ

    
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