package com.example.netwod;
import android.content.Intent;
import android.os.Environment;

//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.io.InputStream;
import jxl.Sheet;
import jxl.Workbook;



class UserInfo {
    private String UserName;

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

    private String UserAge;
    private String UserWeight;
    private String UserHeight;
    private String User_NumOfTraining;
    private boolean Dumbbell;
    private boolean Body;
    private boolean Kettlebell;
    private boolean Barbell;
    private boolean WallBall;
    private boolean Box;

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

    private boolean Jumprope;
    private boolean PullUpBar;
    public UserInfo(){}



}







class ExcelScrapper {

    public static Object mContext;
    public ArrayList<String> user_info= new ArrayList<String>();
    public ArrayList<String> equipment = new ArrayList<String>();
    public ArrayList<ArrayList<String>> schedule = new ArrayList<ArrayList<String>>();
    public ArrayList<ArrayList<String>> record = new ArrayList<ArrayList<String>>();
    public void readExcel(){


        try {

            Workbook workbook = null;

            Sheet sheet;
            String p=System.getProperty("user.dir");
            //System.out.println("디레ㄱㄱ토리:"+p);

       //   InputStream is = new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\CapstoneDesign_NetWOD\\NETWOD\\app\\src\\main\\java\\com\\example\\netwod\\"+"tem.xls");
            InputStream is = new FileInputStream("C:/Users/user/Documents/GitHub/CapstoneDesign_NetWOD/NETWOD/app/src/main//java/com/example/netwod/"+"tem.xls");

            //String p=System.getProperty("user.dir");
            //InputStream is=new FileInputStream("NetWOD teplate sheet.xls");

            workbook = Workbook.getWorkbook(is);
            //InputStream df=new FileInputStream("")
                   // String p=System.getProperty("user.dir");

            if(workbook != null){
                sheet = workbook.getSheet(1);

                if(sheet != null){




                    // 유저 정보 엑셀에서 읽어오는 부분
                    String name = sheet.getCell(13,5).getContents();
                    String age = sheet.getCell(13,6).getContents();
                    String weight=sheet.getCell(13,7).getContents();
                    String height=sheet.getCell(13,8).getContents();
                    String NumofTraining = sheet.getCell(13,9).getContents();

                    this.user_info.add(name);
                    //this.user_info.add(age);
                    this.user_info.add(weight);
                    this.user_info.add(height);
                    //this.user_info.add(NumofTraining);


                    //운동 스케줄 엑셀에서 읽어오는 부분
                    int nMaxColumn = 9;
                    int nRowStartIndex = 9;
                    int nRowEndIndex = 150;
                    int nColumnStartIndex = 2;
                    int nColumnEndIndex = 10;

                    ArrayList<String> wod_name = new ArrayList<String>();
                    ArrayList<String> wod_type = new ArrayList<String>();
                    ArrayList<String> movement = new ArrayList<String>();
                    ArrayList<String> equipment = new ArrayList<String>();
                    ArrayList<String> reps = new ArrayList<String>();
                    ArrayList<String> equip_weight = new ArrayList<String>();
                    ArrayList<String> wod_level = new ArrayList<String>();
                    ArrayList<String> wod_record = new ArrayList<String>();
                    ArrayList<String> score = new ArrayList<String>();


                    for (int nRow1 = nRowStartIndex; nRow1<=nRowEndIndex; nRow1+=50){
                        wod_name.add( sheet.getCell(nColumnStartIndex, nRow1).getContents());
                        wod_type.add( sheet.getCell(nColumnStartIndex+1,nRow1).getContents());

                        wod_level.add(sheet.getCell(nColumnStartIndex+6,nRow1).getContents());
                        wod_record.add(sheet.getCell(nColumnStartIndex+7,nRow1).getContents());
                        score.add(sheet.getCell(nColumnStartIndex+8,nRow1).getContents());
                    }
                    for (int nRow = nRowStartIndex; nRow <=nRowEndIndex; nRow ++){
                        do {
                            movement.add(sheet.getCell(nColumnStartIndex + 2, nRow).getContents());
                        } while (movement.contains(null));
                        do {
                            equipment.add(sheet.getCell(nColumnStartIndex + 3, nRow).getContents());
                        } while (equipment.contains(null));
                        do {
                            reps.add(sheet.getCell(nColumnStartIndex + 4, nRow).getContents());

                        } while (reps.contains(null));
                        do {
                            equip_weight.add(sheet.getCell(nColumnStartIndex + 5, nRow).getContents());

                        } while (equip_weight.contains(null));

                    }
                    schedule.add(wod_name);
                    schedule.add(wod_type);
                    schedule.add(movement);
                    schedule.add(equipment);
                    schedule.add(reps);
                    schedule.add(equip_weight);
                    schedule.add(wod_level);
                    schedule.add(wod_record);
                    schedule.add(score);

                    record.add(wod_name);
                    record.add(wod_type);
                    record.add(movement);
                    record.add(equipment);
                    record.add(reps);
                    record.add(equip_weight);
                    record.add(wod_level);
                    record.add(wod_record);
                    record.add(score);





                }
                else{
                    System.out.println("Sheet is null");
                }
            }
            else{
                System.out.println("Workbook is null");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

