package com.example.netwod;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView tv_username;
    TextView tv_userheight;
    TextView tv_userweight;
    Button btn_fragment;
    MainActivity activity;
    CheckBox bodycheckbox;
    CheckBox barbellcheckbox;
    CheckBox dumbbellcheckbox;
    CheckBox boxcheckbox;
    CheckBox pullupbarcheckbox;
    CheckBox jumpropecheckbox;
    CheckBox kettlebellcheckbox;
    CheckBox wallballcheckbox;

    private ViewGroup rootView;
    public Menu1Fragment() {
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
    public static Menu1Fragment newInstance(String param1, String param2) {
        Menu1Fragment fragment = new Menu1Fragment();
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
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_menu1 , container, false);

        //텍스트뷰 바운딩

        tv_username= rootView.findViewById(R.id.NametextView);
        tv_userheight= rootView.findViewById(R.id.HeighttextView);
        tv_userweight= rootView.findViewById(R.id.WeightTextView);

        String userName=activity.excelscrapper.userinfo.getUserName();
        String userHeight=activity.excelscrapper.userinfo.getUserHeight();
        String userWeight=activity.excelscrapper.userinfo.getUserWeight();
        //체크박스 바운딩
        boxcheckbox=rootView.findViewById(R.id.BoxcheckBox);
        jumpropecheckbox=rootView.findViewById(R.id.JumpRopecheckBox);
        barbellcheckbox=rootView.findViewById(R.id.BarbellcheckBox);
        dumbbellcheckbox=rootView.findViewById(R.id.DumbbellcheckBox);
        bodycheckbox=rootView.findViewById(R.id.BodycheckBox);
        kettlebellcheckbox=rootView.findViewById(R.id.KettlebellcheckBox);
        pullupbarcheckbox=rootView.findViewById(R.id.PullUpBarcheckBox);
        wallballcheckbox=rootView.findViewById(R.id.WallBallcheckBox);
        //user 와 동기화
        btn_fragment=rootView.findViewById(R.id.Editbutton);




        tv_username.setText(userName);
        tv_userheight.setText(userHeight);
        tv_userweight.setText(userWeight);
        activity.excelscrapper.readExcel();

        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //boxcheckbox.performClick();


                activity.onFragmentChange(8);


            }
        });




        //return inflater.inflate(R.layout.fragment_menu1, container, false);
        //saveuserprofile();
        return rootView;
    }

    //View view = inflater.inflate(R.layout.fragment_menu1, container, false);
    //tv_fragment = (TextView)view.findViewById(R.id.NametextView);
    //btn_fragment = (Button)view.findViewById(R.id.Editbutton);

    public void onAttach(Context context) {
        super.onAttach(context);
        //이 메소드가 호출될떄는 프래그먼트가 엑티비티위에 올라와있는거니깐 getActivity메소드로 엑티비티참조가능
        activity = (MainActivity) getActivity();
    }

}