package com.example.netwod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;

public class Excelscrapper2 extends AppCompatActivity {
    public static Object mContext;
    public ArrayList<String> list= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AssetManager am = getResources().getAssets() ;
        InputStream is = null ;

        try {
            is = am.open("NETWOD teplate sheet.xls") ;

            // TODO : use is(InputStream).
            Workbook workbook = null;
            System.out.println("1 사이즈:"+this.list.size());
            Sheet sheet;
            String p=System.getProperty("user.dir");
            System.out.println("디레ㄱㄱ토리:"+p);
            System.out.println("try3232에서 사이즈:"+this.list.size());
            //InputStream is = new FileInputStream("C:\\Users\\user\\Documents\\GitHub\\CapstoneDesign_NetWOD\\NETWOD\\app\\src\\main\\java\\com\\example\\netwod\\"+"NetWOD teplate sheet.xls");
            //String p=System.getProperty("user.dir");

            workbook = Workbook.getWorkbook(is);
            sheet = workbook.getSheet(1);
            String ctgy = sheet.getCell(13,5).getContents();


            this.list.add(ctgy);
            System.out.println("액셀스크래퍼에서 사이즈:"+this.list.size());


        } catch (Exception e) {
            e.printStackTrace() ;
        }

        if (is != null) {
            try {
                is.close() ;
            } catch (Exception e) {
                e.printStackTrace() ;
            }
        }

    }//oncrete끝
}