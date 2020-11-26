package com.example.netwod;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FortimeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    final static int Init =0;
    final static int Run =1;
    final static int Pause =2;

    int cur_Status = Init; //현재의 상태를 저장할변수를 초기화함.
    int myCount=1;
    long myBaseTime;
    long myPauseTime;
    Button fortimestartbutton;
    Button fortimerecordbutton;
    Button fortimeaddbutton;
    TextView fortimetextview;
    TextView fortimerecordtextview;
    TextView fortimewodnametextview;
    TextView fortimewodtypetextview;
    TextView fortimewodmovementtextview;
    MainActivity activity;

    private ViewGroup rootView;
    public FortimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Menu1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FortimeFragment newInstance(String param1, String param2) {
        FortimeFragment fragment = new FortimeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_fortime , container, false);

        fortimestartbutton=rootView.findViewById(R.id.fortimestartbutton);
        fortimerecordbutton=rootView.findViewById(R.id.fortimerecordbutton);
        fortimetextview=rootView.findViewById(R.id.fortimetext);
        fortimerecordtextview=rootView.findViewById(R.id.fortimerecord);
        fortimewodnametextview=rootView.findViewById(R.id.fortimewodname);
        fortimewodtypetextview=rootView.findViewById(R.id.fortimewodtype);
        fortimewodmovementtextview=rootView.findViewById(R.id.fortimewodmovement);
        fortimeaddbutton=rootView.findViewById(R.id.fortimeaddbutton);
        int currentindex=activity.excelscrapper.userinfo.getCurrentwodindex();

        int msize = activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getMovement().size();
        int titlesize = activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getWODname().length();
        int typesize = activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getWODtype().length();
        String movementstring="";
        String titlestring="";
        String typestring="";
        for(int i=0; i<titlesize;i++){

            titlestring=titlestring+"\n"+activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getWODname().charAt(i);


        }
        for(int i=0; i<typesize;i++){

            typestring=typestring+"\n"+activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getWODtype().charAt(i);


        }

        for (int i = 0; i < msize; i++){
            movementstring=movementstring+"\n"+activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getMovement().get(i);
            if(activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getWeightlist().get(i)!=""){
                movementstring=movementstring+" "+activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getWeightlist().get(i)+"kg";
            }
            movementstring=movementstring+" "+activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getMovementnum().get(i)+"times";
        }
        fortimewodnametextview.setText(titlestring);

        fortimewodtypetextview.setText(typestring);
        //movementstring=activity.excelscrapper.userinfo.getUserwodlist().get(currentindex).getMovement().get(0);

        fortimewodmovementtextview.setText(movementstring);

        fortimeaddbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = fortimetextview.getText().toString().substring(0,5);
                activity.tmpwod=new WOD();
                activity.tmpwod=activity.excelscrapper.userinfo.getUserwodlist().get(currentindex);
                activity.excelscrapper.userinfo.getWodrecord().wodlist.add(activity.tmpwod);
                activity.excelscrapper.userinfo.getWodrecord().recordlist.add(result);
                activity.excelscrapper.userinfo.getWodrecord().scorelist.add("TE");

            }
        });



        fortimestartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (cur_Status) {
                    case Init:
                        myBaseTime = SystemClock.elapsedRealtime();

                        //myTimer이라는 핸들러를 빈 메세지를 보내서 호출
                        myTimer.sendEmptyMessage(0);
                        fortimestartbutton.setText("멈춤"); //버튼의 문자"시작"을 "멈춤"으로 변경
                        fortimerecordbutton.setEnabled(true); //기록버튼 활성
                        cur_Status = Run; //현재상태를 런상태로 변경
                        break;
                    case Run:
                        myTimer.removeMessages(0);
                        myPauseTime = SystemClock.elapsedRealtime();
                        fortimestartbutton.setText("시작");
                        fortimerecordbutton.setText("리셋");
                        cur_Status = Pause;
                        break;
                    case Pause:
                        long now = SystemClock.elapsedRealtime();
                        myTimer.sendEmptyMessage(0);
                        myBaseTime += (now - myPauseTime);
                        fortimestartbutton.setText("멈춤");
                        fortimerecordbutton.setText("기록");
                        cur_Status = Run;
                        break;


                }
            }
        });
        fortimerecordbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (cur_Status) {
                    case Run:

                        String str = fortimerecordtextview.getText().toString();
                        str += String.format("%d. %s\n", myCount, getTimeOut());
                        fortimerecordtextview.setText(str);
                        myCount++; //카운트 증가

                        break;
                    case Pause:
                        //핸들러를 멈춤
                        myTimer.removeMessages(0);

                        fortimestartbutton.setText("시작");
                        fortimerecordbutton.setText("기록");
                        fortimetextview.setText("00:00:00");

                        cur_Status = Init;
                        myCount = 1;
                        fortimerecordtextview.setText("");
                        fortimerecordbutton.setEnabled(false);
                        break;


                }

            }

        });




        return rootView;
    }
    Handler myTimer = new Handler(){
        public void handleMessage(Message msg){
            fortimetextview=rootView.findViewById(R.id.fortimetext);
            fortimetextview.setText(getTimeOut());

            //sendEmptyMessage 는 비어있는 메세지를 Handler 에게 전송하는겁니다.
            myTimer.sendEmptyMessage(0);
        }
    };


    String getTimeOut(){
        long now = SystemClock.elapsedRealtime(); //애플리케이션이 실행되고나서 실제로 경과된 시간(??)^^;
        long outTime = now - myBaseTime;
        String easy_outTime = String.format("%02d:%02d:%02d", outTime/1000 / 60, (outTime/1000)%60,(outTime%1000)/10);
        return easy_outTime;

    }
    public void onAttach(Context context) {
        super.onAttach(context);
        //이 메소드가 호출될떄는 프래그먼트가 엑티비티위에 올라와있는거니깐 getActivity메소드로 엑티비티참조가능
        activity = (MainActivity) getActivity();
    }
}