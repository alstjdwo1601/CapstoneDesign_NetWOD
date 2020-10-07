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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;

public class MainActivity extends AppCompatActivity {

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    UserInfo user;

    ExcelScrapper excelscrapper;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // 4개의 메뉴에 들어갈 Fragment들
    public Menu1Fragment menu1Fragment = new Menu1Fragment();
    private Menu2Fragment menu2Fragment = new Menu2Fragment();
    private Menu3Fragment menu3Fragment = new Menu3Fragment();
    private Menu4Fragment menu4Fragment = new Menu4Fragment();
    private WodselectFragment wodselectFragment = new WodselectFragment(); //이건 필요 없는거임지금은
    private WodlistFragment wodlistFragment = new WodlistFragment();
    private WodgenerateFragment wodgenerateFragment = new WodgenerateFragment();
    private HelpFragment helpFragment = new HelpFragment();
    public ChangeinfoFragment changeinfoFragment = new ChangeinfoFragment();
    public ArrayList<String> list = new ArrayList<String>();

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
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, menu1Fragment).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, menu2Fragment).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, menu3Fragment).commit();
                break;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, menu4Fragment).commit();
                break;
            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, wodlistFragment).commit();
                break;
            case 6:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, wodgenerateFragment).commit();
                break;
            case 7:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, helpFragment).commit();
                break;
            case 8:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, changeinfoFragment).commit();
                break;
            case 9:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, wodselectFragment).commit();
                break;
            case 10:

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, wodselectFragment).commit();
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        user = new UserInfo();
        excelscrapper=new ExcelScrapper();
excelscrapper.readExcel();
        //testexcel();

        //a.list.add(ff);
        //ExcelScrapper a= new ExcelScrapper();
        //a.readExcel();
        //testexcel();

        user.setUserName(excelscrapper.user_info.get(0));
        user.setUserWeight(excelscrapper.user_info.get(1));
        user.setUserHeight(excelscrapper.user_info.get(2));
        System.out.println(excelscrapper.user_info.get(0));

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

    public void testexcel() {
        AssetManager am = getResources().getAssets();
        InputStream is = null;

        try {
            System.out.println(am);
            is = am.open("tem a.xls");

            // TODO : use is(InputStream).
            Workbook workbook = null;

            Sheet sheet;
            String p = System.getProperty("user.dir");


            workbook = Workbook.getWorkbook(is);
            sheet = workbook.getSheet(1);
            String ctgy = sheet.getCell(13, 5).getContents();
            String weight = sheet.getCell(13, 7).getContents();
            String height = sheet.getCell(13, 8).getContents();

            this.list.add(ctgy);
            this.list.add(weight);
            this.list.add(height);
            System.out.println("액셀스크래퍼에서 사이즈:" + this.list.size());


        } catch (Exception e) {
            e.printStackTrace();
        }

        if (is != null) {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


public void readuserprofile(){





}











    class ExcelScrapper {
        //변수들 특히 어레이리스트 1.동적할당 2.private썼으면 게터세터
        //어플 키면 excelscrapper가 엑셀 읽고 Userinfo를 하나 줌. 난 그 userinfo.리스트 이걸로만 접근할거임
        
        class UserInfo {
            private WODrecord wodrecord; //템플릿에 있는 개인이 실제로 한 기록
            private ArrayList<WOD> userwodlist; //와드 선택할때 리스트(뭐 할지 고를지)
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
        class WOD{
            String WODname;//ex) FRAN
            String WODtype; //포타임, 암랩 등등
            //데드21,월볼21 + 데드15,월볼15 와드 예시
            ArrayList movement;//{데드,월볼,데드,월볼,데드,월볼}
            ArrayList movementnum;//={21,21,21,15,15,15};


        }
        class WODrecord{
            ArrayList<WOD> wodlist; //{프란,신디,민성재,김정훈}
            ArrayList<String> scorelist; //{"70","80","75","60"}
            ArrayList<String> recordlist; //{"4:32","3:53","2:10","6:34"}
        }
        class Player{



        }



        //dfsd
        public ArrayList<String> user_info= new ArrayList<String>();
        public ArrayList<String> equipment = new ArrayList<String>();
        public ArrayList<ArrayList<String>> schedule = new ArrayList<ArrayList<String>>();
        public ArrayList<ArrayList<String>> record = new ArrayList<ArrayList<String>>();
        public void readExcel(){
            AssetManager am = getResources().getAssets();
            InputStream is = null;

            try {
                System.out.println(am);
                is = am.open("tem a.xls");

                // TODO : use is(InputStream).
                Workbook workbook = null;

                Sheet sheet;
                String p = System.getProperty("user.dir");

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

}





