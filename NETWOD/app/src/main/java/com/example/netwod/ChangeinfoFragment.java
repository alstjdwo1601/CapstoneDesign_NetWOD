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

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChangeinfoFragment extends Fragment {

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
    Button changeinfobutton;
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
    public ChangeinfoFragment() {
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
    public static ChangeinfoFragment newInstance(String param1, String param2) {
        ChangeinfoFragment fragment = new ChangeinfoFragment();
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
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_changeinfo , container, false);

        //activity.onFragmentChange(5);이위치에서 됨

        changeinfobutton=(Button)rootView.findViewById(R.id.Changeinfobutton);
        bodycheckbox=(CheckBox)rootView.findViewById(R.id.BodycheckBox);
        dumbbellcheckbox=(CheckBox)rootView.findViewById(R.id.DumbbellcheckBox);
        tv_username= rootView.findViewById(R.id.editTextName);

        tv_userheight= rootView.findViewById(R.id.editTextTextHeight);
        tv_userweight= rootView.findViewById(R.id.editTextTextWeight);
        String userName=((MainActivity)getActivity()).excelscrapper.userinfo.getUserName();
        String userHeight=((MainActivity)getActivity()).excelscrapper.userinfo.getUserHeight();
        String userWeight=((MainActivity)getActivity()).excelscrapper.userinfo.getUserWeight();

        //체크박스 바운딩
        boxcheckbox=rootView.findViewById(R.id.changeBoxcheckBox);
        jumpropecheckbox=rootView.findViewById(R.id.changeJumpRopecheckBox);
        barbellcheckbox=rootView.findViewById(R.id.changeBarbellcheckBox);
        dumbbellcheckbox=rootView.findViewById(R.id.changeDumbbellcheckBox);
        bodycheckbox=rootView.findViewById(R.id.changeBodycheckBox);
        kettlebellcheckbox=rootView.findViewById(R.id.changeKettlebellcheckBox);
        pullupbarcheckbox=rootView.findViewById(R.id.changePullUpBarcheckBox);
        wallballcheckbox=rootView.findViewById(R.id.changeWallBallcheckBox);





        tv_username.setText(userName);
        tv_userheight.setText(userHeight);
        tv_userweight.setText(userWeight);
        changeinfobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //이거 엑셀수정으로 바꿔야함

                ((MainActivity)getActivity()).excelscrapper.userinfo.setUserName( tv_username.getText().toString());
                ((MainActivity)getActivity()).excelscrapper.userinfo.setUserWeight(tv_userweight.getText().toString());
                ((MainActivity)getActivity()).excelscrapper.userinfo.setUserHeight( tv_userheight.getText().toString());
                ((MainActivity)getActivity()).excelscrapper.userinfo.setBarbell((boolean)barbellcheckbox.isChecked());
                ((MainActivity)getActivity()).excelscrapper.userinfo.setDumbbell((boolean)dumbbellcheckbox.isChecked());

                ((MainActivity)getActivity()).excelscrapper.userinfo.setBox((boolean)boxcheckbox.isChecked());
                ((MainActivity)getActivity()).excelscrapper.userinfo.setJumprope((boolean)jumpropecheckbox.isChecked());
                ((MainActivity)getActivity()).excelscrapper.userinfo.setBody((boolean)bodycheckbox.isChecked());
                ((MainActivity)getActivity()).excelscrapper.userinfo.setKettlebell((boolean)kettlebellcheckbox.isChecked());
                ((MainActivity)getActivity()).excelscrapper.userinfo.setWallBall((boolean)wallballcheckbox.isChecked());
                ((MainActivity)getActivity()).excelscrapper.userinfo.setPullUpBar((boolean)pullupbarcheckbox.isChecked());
                try {
                     activity.excelscrapper.editUserInfo();

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }


                activity.onFragmentChange(1);

            }
        });
        //bodycheckbox.setOnClickListener();




        //return inflater.inflate(R.layout.fragment_menu1, container, false);
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