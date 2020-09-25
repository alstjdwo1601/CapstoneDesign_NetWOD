package com.example.netwod;
import android.content.Intent;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;


class UserInfo {
    private String UserName;
    private String UserAge;
    private String UserWeight;
    private String UserHeight;
    private String User_NumOfTraining;

    public UserInfo(){}

    public UserInfo(String UserName, String UserAge, String UserWeight, String UserHeight, String User_NumOfTraining) {
        super();
        this.UserName = UserName;
        this.UserAge = UserAge;
        this.UserHeight = UserHeight;
        this.UserWeight = UserWeight;
        this.User_NumOfTraining = User_NumOfTraining;
    }

    public String getUserName(){
        return UserName;
    }

    public void setUserName(){
        this.UserName = UserName;
    }

    public String getUserAge(){
        return UserAge;
    }

    public void setUserAge(){
        this.UserAge = UserAge;
    }

    public String getUserWeight(){
        return UserWeight;
    }

    public void setUserWeight(){
        this.UserWeight = UserWeight;
    }

    public String getUserHeight(){
        return UserHeight;
    }

    public void setUserHeight(){
        this.UserHeight = UserHeight;
    }

    public String getUser_NumOfTraining(){
        return User_NumOfTraining;
    }

    public void setUser_NumOfTraining(){
        this.User_NumOfTraining = User_NumOfTraining;
    }
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
        this.category = category;
    }

    public void setValue(String s) {
        this.value = value;
    }
}




class ExcelScrapper {

    public static Object mContext;
    public ArrayList<exData> list= new ArrayList<exData>();
    public void readExcel(){

        //String path = Objects.requireNonNull(ExcelScrapper.class.getResource("")).getPath();

        try {
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


        //Intent intent = new Intent(, MainActivity.class);
        //Intent.putExtra("개인정보",list);

    }



    public void writeExcel(){
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");
    }

}








