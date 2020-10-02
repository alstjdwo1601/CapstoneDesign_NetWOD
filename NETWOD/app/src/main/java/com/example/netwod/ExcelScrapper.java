package com.example.netwod;
import android.content.Intent;

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



class exData {
    private String category;
    private String value;

    public String getCategory(){
        return category;
    }

    public String getValue(){
        return value;
    }

    public void setCategory(String s) {
        this.category = s;
    }

    public void setValue(String s) {
        this.value = s;
    }
}




class ExcelScrapper {

    public static Object mContext;
    public ArrayList<exData> list= new ArrayList<exData>();
    public void readExcel(){

        //String path = Objects.requireNonNull(ExcelScrapper.class.getResource("")).getPath();

        try {
            Workbook workbook = null;
            Sheet sheet = null;

            InputStream is = new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\CapstoneDesign_NetWOD\\NETWOD\\app\\src\\main\\java\\com\\example\\netwod\\"+"NetWOD teplate sheet.xls");
            workbook = Workbook.getWorkbook(is);


            if(workbook != null){
                sheet = workbook.getSheet(1);

                if(sheet != null){
                    System.out.println("????");
                    int nMaxColumn = 17;
                    int nRowStartIndex = 5;
                    int nRowEndIndex = sheet.getColumn(nMaxColumn - 1).length - 1;
                    int nColumnStartIndex = 12;
                    int nColumnEndIndex = sheet.getRow(17).length - 1;
                    exData ed = new exData();

                    /*
                    for (int nRow = nRowStartIndex; nRow <= nRowEndIndex; nRow++) {
                        String ctgy = sheet.getCell(nColumnStartIndex, nRow).getContents();
                        String val = sheet.getCell(nColumnStartIndex + 1, nRow).getContents();
                        ed.setCategory(ctgy);
                        ed.setValue(val);

                    }
                    */
                    String ctgy = sheet.getCell(13,5).getContents();
                    String val = sheet.getCell(12, 5).getContents();
                    ed.setCategory(ctgy);
                    ed.setValue(val);
                    this.list.add(ed);
                }
                else{
                    System.out.println("Sheet is null");
                }
            }
            else{
                System.out.println("Workbook is null");
            }


            /*
            //File file = new File(path + "NetWOD teplate sheet.xlsx");
            File file = new File("C:\\Users\\user\\Documents\\GitHub\\CapstoneDesign_NetWOD\\NETWOD\\app\\src\\main\\java\\com\\example\\netwod"+"NetWOD teplate sheet.xlsx");
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            XSSFWorkbook workbook = null;
            try {
                assert fis != null;
                workbook = new XSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int rowindex = 5;
            int colindex = 12;
            //시트
            assert workbook != null;
            XSSFSheet sheet = workbook.getSheetAt(1);
            //행
            int rows = sheet.getPhysicalNumberOfRows();
            exData ed = new exData();
            XSSFRow row = sheet.getRow(rowindex);
            //XSSFCell cell = row.getCell(2);
            ed.setCategory(String.valueOf(row.getCell(12)));
            ed.setValue(String.valueOf(row.getCell(12)));
            //Log.d("ddddddddddddd", String.valueOf(ed));
            exData ed2=new exData();
            ed2.setValue("sung");
            ed2.setCategory("min");
            //list.add(ed);
            list.add(ed2);
            /*
            for (rowindex = 5; rowindex < rows; rowindex++) {
                exData ed = new exData();
                //행 읽기
                XSSFRow row = sheet.getRow(rowindex);
                XSSFCell cell = row.getCell(2);
                //Log.d("dddddddddddddddddd", String.valueOf(row));
                //Log.d("dddddddddddddddddd", String.valueOf(cell));
                ed.setCategory(String.valueOf(row.getCell(0)));
                ed.setValue(String.valueOf(row.getCell(1)));
                //Log.d("ddddddddddddd", String.valueOf(ed));
                list.add(ed);
            }
            */


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    public void writeExcel(){
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");
    }
    */


}

