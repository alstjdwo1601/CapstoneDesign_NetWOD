package com.example.netwod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;

public class MainActivity extends AppCompatActivity {

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    UserInfo user;

    ExcelScrapper a;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // 4개의 메뉴에 들어갈 Fragment들
    public Menu1Fragment menu1Fragment = new Menu1Fragment();
    private Menu2Fragment menu2Fragment = new Menu2Fragment();
    private Menu3Fragment menu3Fragment = new Menu3Fragment();
    private Menu4Fragment menu4Fragment = new Menu4Fragment();
    private WodselectFragment wodselectFragment= new WodselectFragment(); //이건 필요 없는거임지금은
    private WodlistFragment wodlistFragment= new WodlistFragment();
    private WodgenerateFragment wodgenerateFragment=new WodgenerateFragment();
    private HelpFragment helpFragment= new HelpFragment();
    public ChangeinfoFragment changeinfoFragment= new ChangeinfoFragment();
    public ArrayList<String> list= new ArrayList<String>();

    LinearLayout selectwodlayout;

    /*
    1~4 하단 네비게이션 메뉴 화면
    1:홈화면
    2:와드 시작 화면
    3:기록 화면
    4:커뮤니티 화면
    5:2-와드 목록 화면
    6:2-와드 생성 화면
    7:2-정보 화면









    */
    public void onFragmentChange(int index) {
        switch (index) {
            case 1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, menu1Fragment).commit();
                break;
            case 2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, menu2Fragment).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, menu3Fragment).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, menu4Fragment).commit();
                break;
            case 5 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,wodlistFragment ).commit();
                break;
            case 6 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, wodgenerateFragment).commit();
                break;
            case 7 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, helpFragment).commit();
                break;
            case 8 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, changeinfoFragment).commit();
                break;
            case 9 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, wodselectFragment).commit();
                break;
            case 10 :

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, wodselectFragment).commit();
                break;
        }

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        user=new UserInfo();


        testexcel();
        //a.list.add(ff);
        //ExcelScrapper a= new ExcelScrapper();
        //a.readExcel();
        //testexcel();
        user.setUserName(this.list.get(0));
        user.setUserWeight(this.list.get(1));
        user.setUserHeight(this.list.get(2));
        user.setPullUpBar(false);
        user.setBarbell(true);
        user.setKettlebell(false);
        user.setBody(true);
        user.setDumbbell(false);
        user.setPullUpBar(false);
        user.setBox(true);
        user.setJumprope(false);
        user.setWallBall(false);


        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        // 첫 화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();
        //fragment 요소마다 하나씩
        //fragment 1 홈
        //fragment 2 와드






        // bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_menu1: {
                        //transaction.replace(R.id.frame_layout, menu1Fragment).commitAllowingStateLoss();
                        onFragmentChange(1);

                        break;
                    }
                    case R.id.navigation_menu2: {
                        onFragmentChange(2);
                        break;
                    }
                    case R.id.navigation_menu3: {
                        onFragmentChange(3);
                        break;
                    }
                    case R.id.navigation_menu4: {
                        onFragmentChange(4);
                        break;
                    }
                }

                return true;
            }
        });
    }
    public void testexcel(){
        AssetManager am = getResources().getAssets() ;
        InputStream is = null ;

        try {
            System.out.println(am);
            is = am.open("tem a.xls") ;

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
            String weight=sheet.getCell(13,7).getContents();
            String height=sheet.getCell(13,8).getContents();

            this.list.add(ctgy);
            this.list.add(weight);
            this.list.add(height);
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



    }

}