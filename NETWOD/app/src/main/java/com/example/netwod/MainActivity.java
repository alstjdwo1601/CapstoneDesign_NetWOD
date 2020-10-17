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
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class MainActivity extends AppCompatActivity {

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    //UserInfo user;

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
    public FortimeFragment fortimeFragment=new FortimeFragment();
    public AmrapFragment amrapFragment=new AmrapFragment();
    public NamedwodFragment namedwodFragment=new NamedwodFragment();
    public ArrayList<WOD> namedwodlist=new ArrayList<WOD>();
    int namedwodindex;
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

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fortimeFragment).commit();
                break;
            case 11:

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,amrapFragment).commit();
                break;
            case 12:

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,namedwodFragment).commit();
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);


        //에뮬레이터 내부 sdcard 경로 받기
        String sdCardPath = null;
        sdCardPath = Environment.getExternalStorageDirectory().getAbsolutePath();


        excelscrapper=new ExcelScrapper(sdCardPath);
        
        //netwodtemplate.xls 읽기
        excelscrapper.readExcel();

        //wodlist.xls 읽기(유명한 와드 리스트들)
        excelscrapper.readExcel3();

        //userwodlist.xls 읽기(나만의 와드 리스트들)

        excelscrapper.readExcel2();







        //user.setPullUpBar(false);
        //user.setBarbell(true);
        //user.setKettlebell(false);
        //user.setBody(true);
        //user.setDumbbell(false);
        //user.setPullUpBar(false);
        //user.setBox(true);
        //user.setJumprope(false);
        //user.setWallBall(false);
        //System.out.println("메인엑티비티에서"+excelscrapper.userinfo.wodrecord.wodlist.get(0).getWODname());

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







    class ExcelScrapper {


        UserInfo userinfo=new UserInfo();
        String sdCardPath;
        FileInputStream is=null;
        File file;


        public ExcelScrapper(String s){
            this.sdCardPath=s;
        }






        //
        // 개인 정보  , 운동기구 보유여부 수정 (홈화면에서 쓰는것)
        //
        public void editUserInfo() throws IOException, BiffException, WriteException {
            file=new File(sdCardPath+"/Download/netwodtemplate.xls" );


            try {
                is = new FileInputStream(file);
                System.out.println("editUserInfo에서 인풋스트림 생성 성공");
            } catch (FileNotFoundException e) {
                System.out.println("editUserInfo에서 인풋스트림 생성 불가");
                e.printStackTrace();
            }

            Workbook originworkbook = null;
            originworkbook = Workbook.getWorkbook(is);
            WritableWorkbook wworkbook = null;

            try {
                wworkbook = Workbook.createWorkbook(new File(sdCardPath+"/Download/netwodtemplate.xls" ),originworkbook);
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert wworkbook != null;
            WritableSheet sheet = wworkbook.getSheet(1);


            // 유저 정보 이름 변경
            WritableCell namecell= sheet.getWritableCell(13,5);

            if (namecell.getType() == CellType.LABEL) {
                Label namelabel = (Label) namecell;
                namelabel.setString(this.userinfo.getUserName());
                System.out.println("수정유저이름:" + this.userinfo.getUserName());

            }

            // 유저 정보 키 변경
            WritableCell heightcell= sheet.getWritableCell(13,8);

            if (heightcell.getType() == CellType.NUMBER) {
                jxl.write.Number n=(jxl.write.Number) heightcell;
                n.setValue(Integer.parseInt(userinfo.getUserHeight()));
                System.out.println("수정 키:" + this.userinfo.getUserHeight());
            }


            //유저 정보 몸무게 변경
            WritableCell weightcell= sheet.getWritableCell(13,7);

            if (weightcell.getType() == CellType.NUMBER) {
                jxl.write.Number n=(jxl.write.Number) weightcell;
                n.setValue(Integer.parseInt(userinfo.getUserWeight()));
                System.out.println("수정 몸무게:" + this.userinfo.getUserWeight());
            }

            // 바벨 Y / N 여부 수정
            WritableCell barbellcell= sheet.getWritableCell(13,14);

            if (barbellcell.getType() == CellType.LABEL) {
                Label barbelllabel = (Label) barbellcell;

                if(this.userinfo.isDumbbell()) { barbelllabel.setString("Y"); }
                else {barbelllabel.setString("N");}
                System.out.println("수정된 바벨:" + this.userinfo.isBarbell());
            }

            // 맨몸 Y / N 여부 수정
            WritableCell bodycell= sheet.getWritableCell(13,15);

            if (bodycell.getType() == CellType.LABEL) {
                Label bodylabel = (Label) bodycell;

                if(this.userinfo.isBody()) { bodylabel.setString("N"); }
                else {bodylabel.setString("Y");}
                System.out.println("수정된 맨몸:" + this.userinfo.isBody());
            }

            // 풀업 바 Y / N 여부 수정
            WritableCell pullupbarcell= sheet.getWritableCell(13,16);

            if (pullupbarcell.getType() == CellType.LABEL) {
                Label pullupbarlabel = (Label) pullupbarcell;

                if(this.userinfo.isPullUpBar()) { pullupbarlabel.setString("N"); }
                else {pullupbarlabel.setString("Y");}
                System.out.println("수정된 풀업바:" + this.userinfo.isPullUpBar());
            }

            // 줄넘기 줄 Y / N 여부 수정
            WritableCell jumpropecell= sheet.getWritableCell(13,17);

            if (jumpropecell.getType() == CellType.LABEL) {
                Label jumpropelabel = (Label) jumpropecell;

                if(this.userinfo.isJumprope()) { jumpropelabel.setString("N"); }
                else {jumpropelabel.setString("Y");}
                System.out.println("수정된 줄넘기 줄:" + this.userinfo.isJumprope());
            }

            // 케틀벨 Y / N 여부 수정
            WritableCell kettlebellcell= sheet.getWritableCell(13,18);

            if (kettlebellcell.getType() == CellType.LABEL) {
                Label kettlebelllabel = (Label) kettlebellcell;

                if(this.userinfo.isKettlebell()) { kettlebelllabel.setString("N"); }
                else {kettlebelllabel.setString("Y");}
                System.out.println("수정된 케틀벨:" + this.userinfo.isKettlebell());
            }

            // 월볼 Y / N 여부 수정
            WritableCell wallballcell= sheet.getWritableCell(13,19);

            if (wallballcell.getType() == CellType.LABEL) {
                Label wallballlabel = (Label) wallballcell;

                if(this.userinfo.isWallBall()) { wallballlabel.setString("N"); }
                else {wallballlabel.setString("Y");}
                System.out.println("수정된 월볼:" + this.userinfo.isWallBall());
            }

            // 박스 Y / N 여부 수정
            WritableCell boxcell= sheet.getWritableCell(13,20);

            if (boxcell.getType() == CellType.LABEL) {
                Label boxlabel = (Label) boxcell;

                if(this.userinfo.isBox()) { boxlabel.setString("N"); }
                else {boxlabel.setString("Y");}
                System.out.println("수정된 박스:" + this.userinfo.isBox());
            }

            // 덤벨 Y / N 여부 수정
            WritableCell dumbbellcell= sheet.getWritableCell(13,21);

            if (dumbbellcell.getType() == CellType.LABEL) {
                Label dumbbelllabel = (Label) dumbbellcell;

                if(this.userinfo.isDumbbell()) { dumbbelllabel.setString("N"); }
                else {dumbbelllabel.setString("Y");}
                System.out.println("수정된 덤벨:" + this.userinfo.isDumbbell());
            }



            try {
                wworkbook.write();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                wworkbook.close();
            } catch (IOException | WriteException e) {
                e.printStackTrace();
            }
            is.close();
            originworkbook.close();

        }


        //
        // 개인 기록 수정
        //
        public void editUserRecord(WODrecord woDrecord) throws IOException, BiffException, WriteException {
            file = new File(sdCardPath + "/Download/netwodtemplate.xls");

            try {
                is = new FileInputStream(file);
                System.out.println("editUserRecord에서 인풋스트림 생성 성공");
            } catch (FileNotFoundException e) {
                System.out.println("editUserRecord에서 인풋스트림 생성 불가");
                e.printStackTrace();
            }

            Workbook originworkbook = null;
            originworkbook = Workbook.getWorkbook(is);
            WritableWorkbook wworkbook = null;

            try {
                wworkbook = Workbook.createWorkbook(new File(sdCardPath + "/Download/netwodtemplate.xls"), originworkbook);
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert wworkbook != null;
            WritableSheet sheet = wworkbook.getSheet(1);

            jxl.write.WritableCellFormat  format= new WritableCellFormat();
            jxl.write.WritableCellFormat  format0= new WritableCellFormat();
            jxl.write.Label label = null;
            jxl.write.Blank blank = null;

            // 유저 정보 점수 변경
            WritableCell scorecell= sheet.getWritableCell(16,9);

            if (scorecell.getType() == CellType.LABEL) {
                Label scorelabel = (Label) scorecell;
                scorelabel.setString(this.userinfo.getAvg_score());
                System.out.println("수정된 스코어:" + this.userinfo.getAvg_score());

            }

            // 유저 정보 평균 시간 변경
            WritableCell timecell= sheet.getWritableCell(16,7);

            if (timecell.getType() == CellType.LABEL) {
                Label timelabel = (Label) timecell;
                timelabel.setString(this.userinfo.getAvg_time());
                System.out.println("수정된 시간:" + this.userinfo.getAvg_time());

            }

            // 유저 정보 평균 와드 레벨 변경
            WritableCell wodlevelcell= sheet.getWritableCell(16,5);

            if (wodlevelcell.getType() == CellType.LABEL) {
                Label wodlevellabel = (Label) wodlevelcell;
                wodlevellabel.setString(this.userinfo.getAvg_WODlevel());
                System.out.println("수정된 와드레벨:" + this.userinfo.getAvg_WODlevel());

            }

            try {
                wworkbook.write();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                wworkbook.close();
            } catch (IOException | WriteException e) {
                e.printStackTrace();
            }
            is.close();
            originworkbook.close();



        }


        //
        // 사용자 와드를 새로 쓰기
        //
        public void editUserWodList(WOD wod) throws IOException, BiffException, WriteException{
            file=new File(sdCardPath+"/Download/userwodlist.xls" );


            try {
                is = new FileInputStream(file);
                System.out.println("editUserWodList에서 인풋스트림 생성 성공");
            } catch (FileNotFoundException e) {
                System.out.println("editUserWodList에서 인풋스트림 생성 불가");
                e.printStackTrace();
            }

            Workbook originworkbook = null;
            originworkbook = Workbook.getWorkbook(is);
            WritableWorkbook wworkbook = null;

            try {
                wworkbook = Workbook.createWorkbook(new File(sdCardPath+"/Download/userwodlist.xls" ),originworkbook);
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert wworkbook != null;
            WritableSheet sheet = wworkbook.getSheet(0);


            //
            // 새로 와드에 쓰는 부분
            //
            if(sheet != null) {
                int nRowStartIndex = 1;
                int nColumnStartIndex = 0;
                int wodrow;
                int wodcol;


                while(sheet.getCell(nColumnStartIndex, nRowStartIndex).getContents()!=""){ //와드 두당한번씩돈다
                    WOD wod2 =new WOD();

                    wodrow=nRowStartIndex;
                    wodcol=2; //movement

                    // 와드네임 변경
                    WritableCell wodnamecell= sheet.getWritableCell(0,nRowStartIndex);

                    if (wodnamecell.getType() == CellType.LABEL) {
                        Label wodnamelabel = (Label) wodnamecell;
                        wodnamelabel.setString(wod.getWODname());
                        System.out.println("수정된 와드네임:" + wod.getWODname());

                    }

                    // 와드타입 변경
                    WritableCell wodtypecell= sheet.getWritableCell(1,nRowStartIndex);

                    if (wodtypecell.getType() == CellType.LABEL) {
                        Label wodtypelabel = (Label) wodtypecell;
                        wodtypelabel.setString(wod.getWODtype());
                        System.out.println("수정된 와드타입:" + wod.getWODtype());

                    }



                    while(sheet.getCell(wodcol, wodrow).getContents()!=""){

                        wod2.getMovement().add(sheet.getCell(2, wodrow).getContents());
                        wod2.getEquipment().add(sheet.getCell(3, wodrow).getContents());
                        wod2.getMovementnum().add(sheet.getCell(4, wodrow).getContents());
                        wod2.getWeightlist().add(sheet.getCell(5, wodrow).getContents());

                        // 무브먼트 변경
                        WritableCell movementcell= sheet.getWritableCell(2,nRowStartIndex);

                        if (movementcell.getType() == CellType.LABEL) {
                            Label movementlabel = (Label) movementcell;
                            movementlabel.setString(wod.getMovement().get(wodrow));
                            System.out.println("수정된 무브먼트:" + wod.getMovement().get(wodrow));

                        }

                        // 장비 변경
                        WritableCell equipmentcell= sheet.getWritableCell(3,nRowStartIndex);

                        if (equipmentcell.getType() == CellType.LABEL) {
                            Label equipmentlabel = (Label) equipmentcell;
                            equipmentlabel.setString(wod.getEquipment().get(wodrow));
                            System.out.println("수정된 장비:" + wod.getEquipment().get(wodrow));

                        }

                        // reps 변경
                        WritableCell movementnumcell= sheet.getWritableCell(4,nRowStartIndex);

                        if (movementnumcell.getType() == CellType.LABEL) {
                            Label movementnumlabel = (Label) movementnumcell;
                            movementnumlabel.setString(wod.getMovementnum().get(wodrow));
                            System.out.println("수정된 수행횟수:" + wod.getMovementnum().get(wodrow));

                        }

                        // 장비 무게 변경
                        WritableCell weightlistcell= sheet.getWritableCell(5,nRowStartIndex);

                        if (weightlistcell.getType() == CellType.LABEL) {
                            Label weightlistlabel = (Label) weightlistcell;
                            weightlistlabel.setString(wod.getWeightlist().get(wodrow));
                            System.out.println("수정된 장비 무게:" + wod.getWeightlist().get(wodrow));

                        }



                        wodrow+=1;
                    }


                    this.userinfo.getUserwodlist().add(wod2);
                    nRowStartIndex+=50;
                }
            }
            else{
                System.out.println("Sheet is null");
            }




            try {
                wworkbook.write();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                wworkbook.close();
            } catch (IOException | WriteException e) {
                e.printStackTrace();
            }
            is.close();
            originworkbook.close();
        }










        //
        //netwodtemplate.xls 읽기
        //
        public void readExcel(){
            file=new File(sdCardPath+"/Download/netwodtemplate.xls" );
            //File file = new File(sdCardPath+"/Download/netwodtemplate.xls" );

            try {
                is = new FileInputStream(file);
                System.out.println("netwodtemplate에서 인풋스트림 생성 성공");
            } catch (FileNotFoundException e) {
                System.out.println("netwodtemplate에서 인풋스트림 생성 불가");
                e.printStackTrace();
            }

            try {

                 // TODO : use is(InputStream).
                Workbook workbook = null;
                Sheet sheet;
                workbook = Workbook.getWorkbook(is);

                if(workbook==null){
                System.out.println("워크북이 NULL");
                }

                // TODO : use is(InputStream).


                //netwodtemplate.xls 읽기
                if(workbook != null){
                    System.out.println("워크북이 있다");
                    sheet = workbook.getSheet(1);

                    if(sheet != null) {


                        // 유저 정보 엑셀에서 읽어오는 부분
                        String name = sheet.getCell(13, 5).getContents();
                        String weight = sheet.getCell(13, 7).getContents();
                        String height = sheet.getCell(13, 8).getContents();


                        this.userinfo.setUserName(name);
                        this.userinfo.setUserWeight(weight);
                        this.userinfo.setUserHeight(height);



                        // equipment boolean 형식으로 반환하기
                        // Y 이면 true , N이면 false
                        String barbell = sheet.getCell(13,14).getContents();
                        String body = sheet.getCell(13,15).getContents();
                        String pullupbar = sheet.getCell(13,16).getContents();
                        String jumprope = sheet.getCell(13,17).getContents();
                        String kettlebell = sheet.getCell(13,18).getContents();
                        String wallball = sheet.getCell(13,19).getContents();
                        String box = sheet.getCell(13,20).getContents();
                        String dumbbell = sheet.getCell(13,21).getContents();

                        if(barbell.equals("Y")){ this.userinfo.setBarbell(true); }
                        else{ this.userinfo.setBarbell(false); }

                        System.out.println(userinfo.isBarbell());

                        if(body.equals("Y")){ this.userinfo.setBody(true); }
                        else{ this.userinfo.setBody(false); }

                        if(pullupbar.equals("Y")){ this.userinfo.setPullUpBar(true); }
                        else{ this.userinfo.setPullUpBar(false); }

                        if(jumprope.equals("Y")){ this.userinfo.setJumprope(true); }
                        else{ this.userinfo.setJumprope(false); }

                        if(kettlebell.equals("Y")){ this.userinfo.setKettlebell(true); }
                        else{ this.userinfo.setKettlebell(false); }

                        if(wallball.equals("Y")){ this.userinfo.setWallBall(true); }
                        else{ this.userinfo.setWallBall(false); }

                        if(box.equals("Y")){ this.userinfo.setBox(true); }
                        else{ this.userinfo.setBox(false); }

                        if(dumbbell.equals("Y")){ this.userinfo.setDumbbell(true); }
                        else{ this.userinfo.setDumbbell(false); }






                        //운동 스케줄 엑셀에서 읽어오는 부분
                        int nRowStartIndex = 9;
                        int nColumnStartIndex = 2;
                        int wodrow;
                        int wodcol;

                        int cnt = 0;
                        int cnt_fortime = 0;
                        int cnt_amrep = 1;
                        float temp_score = 0;
                        float temp_level = 0;
                        int temp_record_fortime = 0;
                        int temp_record_amrep = 0;
                        int minute = 0;
                        int second = 0;


                        while(sheet.getCell(nColumnStartIndex, nRowStartIndex).getContents()!=""){ //와드 두당한번씩돈다

                        this.userinfo.wodrecord.recordlist.add(sheet.getCell(9, nRowStartIndex).getContents());
                        this.userinfo.wodrecord.scorelist.add(sheet.getCell(10, nRowStartIndex).getContents());



                            wodrow=nRowStartIndex;
                            wodcol=4; //movement
                            WOD wod=new WOD();

                            wod.setWODname(sheet.getCell(2, nRowStartIndex).getContents()    );
                            wod.setWODtype(sheet.getCell(3, nRowStartIndex).getContents()    );
                            wod.setWODlevel(sheet.getCell(8, nRowStartIndex).getContents()   );

                            temp_level += Float.parseFloat(sheet.getCell(8, nRowStartIndex).getContents() );

                            minute = Integer.parseInt(sheet.getCell(9, nRowStartIndex).getContents().substring(0,2));
                            second = Integer.parseInt(sheet.getCell(9, nRowStartIndex).getContents().substring(3,5));

                            //FORTIME
                            if(sheet.getCell(3, nRowStartIndex).getContents().equals("FORTIME")){
                                temp_record_fortime += minute * 60 + second;
                                cnt_fortime++;
                            }

                            //AMRAP
                            else if (sheet.getCell(3, nRowStartIndex).getContents().equals("AMLAP")){
                                temp_record_amrep = minute*Integer.parseInt(sheet.getCell(6, wodrow).getContents()) + second;
                                cnt_amrep++;
                            }

                            temp_score += Float.parseFloat(sheet.getCell(10,nRowStartIndex).getContents());

                            while(sheet.getCell(4, wodrow).getContents()!=""){
                                //System.out.println("NULL인가"+sheet.getCell(2, nRowStartIndex).getContents() );
                                wod.getMovement().add(sheet.getCell(4, wodrow).getContents());
                                wod.getEquipment().add(sheet.getCell(5, wodrow).getContents());
                                wod.getMovementnum().add(sheet.getCell(6, wodrow).getContents());
                                wod.getWeightlist().add(sheet.getCell(7, wodrow).getContents());


                                wodrow+=1;
                            }

                            this.userinfo.wodrecord.wodlist.add(wod);
                            cnt ++;

                        nRowStartIndex+=50;
                        }


                        // 개인 평균 기록
                        // 평균 와드 레벨 , 평균 스코어는 소수점 2자리까지 출력
                        // 평균 기록은 FORTIME 인 경우 xx분 yy초 형식으로 출력
                        // 평균 기록은 APRAP 인 경우 xx Round yy 형식으로 출력
                        float level_wod = (temp_level / (float)cnt);
                        float score = (temp_score / (float)cnt) ;
                        int record = (temp_record_fortime / cnt_fortime) ;
                        int record2 = (temp_record_amrep / cnt_amrep);

                        @SuppressLint("DefaultLocale") String s_level_wod = String.format("%.2f", level_wod);
                        @SuppressLint("DefaultLocale") String s_score = String.format("%.2f", score);
                        String s_record = Integer.toString(record/60) +"분 "+Integer.toString(record%60)+"초";
                        String s_record2 = Integer.toString(record2/15) +"Round "+Integer.toString(record2%15);

                        System.out.println("평균 와드 레벨은 : "+ s_level_wod);
                        System.out.println("평균 스코어는 : "+s_score);
                        System.out.println("평균 기록시간은 : "+s_record);
                        System.out.println("평균 암랩기록은 : "+s_record2);

                        this.userinfo.setAvg_WODlevel(s_level_wod);
                        this.userinfo.setAvg_score(s_score);
                        this.userinfo.setAvg_time(s_record);
                        this.userinfo.setAvg_time_amrep(s_record);




                    }
                    else{
                        System.out.println("Sheet is null");
                    }
                }
                else{
                    System.out.println("Workbook is null");
                }

            workbook.close();
                is.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }




        //
        //userwodlist.xls 읽기
        //
        public void readExcel2(){
            file = new File(sdCardPath+"/Download/userwodlist.xls" );
            try {
                is = new FileInputStream(file);

            } catch (FileNotFoundException e) {

                e.printStackTrace();
            }

            try {

                // TODO : use is(InputStream).
                Workbook workbook = null;
                Sheet sheet;
                workbook = Workbook.getWorkbook(is);

                if(workbook==null){

                }

                // TODO : use is(InputStream).
                if(workbook != null){

                    sheet = workbook.getSheet(0);

                    if(sheet != null) {
                        int nRowStartIndex = 1;
                        int nColumnStartIndex = 0;
                        int wodrow;
                        int wodcol;


                        while(sheet.getCell(nColumnStartIndex, nRowStartIndex).getContents()!=""){ //와드 두당한번씩돈다
                            WOD wod2 =new WOD();

                            wodrow=nRowStartIndex;
                            wodcol=2; //movement


                            wod2.setWODname(sheet.getCell(0, nRowStartIndex).getContents()    );
                            wod2.setWODtype(sheet.getCell(1, nRowStartIndex).getContents()    );


                            while(sheet.getCell(wodcol, wodrow).getContents()!=""){

                                wod2.getMovement().add(sheet.getCell(2, wodrow).getContents());
                                wod2.getEquipment().add(sheet.getCell(3, wodrow).getContents());
                                wod2.getMovementnum().add(sheet.getCell(4, wodrow).getContents());
                                wod2.getWeightlist().add(sheet.getCell(5, wodrow).getContents());

                                wodrow+=1;
                            }

                            //this.userinfo.wodrecord.wodlist.add(wod2);
                                this.userinfo.getUserwodlist().add(wod2);
                            nRowStartIndex+=50;
                        }
                    }
                    else{
                        System.out.println("Sheet is null");
                    }
                }
                else{
                    System.out.println("Workbook is null");
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }



        //
        //wodlist.xls 읽기
        //
        public void readExcel3(){
            file = new File(sdCardPath+"/Download/wodlist.xls" );
            try {
                is = new FileInputStream(file);

            } catch (FileNotFoundException e) {

                e.printStackTrace();
            }

            try {

                // TODO : use is(InputStream).
                Workbook workbook = null;
                Sheet sheet;
                workbook = Workbook.getWorkbook(is);

                if(workbook==null){
                    System.out.println("워크북이 NULL");
                }

                // TODO : use is(InputStream).
                if(workbook != null){
                    System.out.println("워크북이 있다");

                    sheet = workbook.getSheet(0);

                    if(sheet != null) {
                        int nRowStartIndex = 1;
                        int nColumnStartIndex = 0;
                        int wodrow;
                        int wodcol;


                        while(sheet.getCell(nColumnStartIndex, nRowStartIndex).getContents()!=""){ //와드 두당한번씩돈다
                            WOD wod3 =new WOD();

                            wodrow=nRowStartIndex;
                            wodcol=2; //movement


                            wod3.setWODname(sheet.getCell(0, nRowStartIndex).getContents()    );
                            wod3.setWODtype(sheet.getCell(1, nRowStartIndex).getContents()    );


                            while(sheet.getCell(wodcol, wodrow).getContents()!=""){

                                wod3.getMovement().add(sheet.getCell(2, wodrow).getContents());
                                wod3.getEquipment().add(sheet.getCell(3, wodrow).getContents());
                                wod3.getMovementnum().add(sheet.getCell(4, wodrow).getContents());
                                wod3.getWeightlist().add(sheet.getCell(5, wodrow).getContents());

                                wodrow+=1;
                            }
                            namedwodlist.add(wod3);
                            //this..add(wod3);

                            nRowStartIndex+=50;
                        }
                    }
                    else{
                        System.out.println("Sheet is null");
                    }
                }
                else{
                    System.out.println("Workbook is null");
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}





