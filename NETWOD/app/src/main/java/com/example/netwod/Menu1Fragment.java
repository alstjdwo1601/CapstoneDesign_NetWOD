package com.example.netwod;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
    TextView tv_fragment;
    Button btn_fragment;
    MainActivity activity;
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

        //activity.onFragmentChange(5);이위치에서 됨
        tv_fragment= rootView.findViewById(R.id.NametextView);
        btn_fragment=(Button)rootView.findViewById(R.id.Editbutton);


        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_fragment.setText("섹스");

            }
        });




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