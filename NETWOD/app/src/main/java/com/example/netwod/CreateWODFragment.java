package com.example.netwod;

import android.content.Context;
import android.os.Bundle;


import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Spinner;

import android.widget.Toast;



import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateWODFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button userwodgeneratebutton;

    Spinner spinner2;
    Spinner wodlevelspinner;
    ArrayList<String> levelarrayList;
    ArrayAdapter<String> levelarrayAdapter;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    EditText createwodname;






    MainActivity activity;

    private ViewGroup rootView;
    public CreateWODFragment() {
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
    public static CreateWODFragment newInstance(String param1, String param2) {
        CreateWODFragment fragment = new CreateWODFragment();
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
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_create_w_o_d , container, false);

        wodlevelspinner=rootView.findViewById(R.id.createwodlevelspinner);
        userwodgeneratebutton=rootView.findViewById(R.id.createwodbutton);
        createwodname=rootView.findViewById(R.id.createwodname);
        spinner2=rootView.findViewById(R.id.createwodspinner);
        arrayList = new ArrayList<>();
        arrayList.add("FORTIME");
        arrayList.add("AMRAP");
        arrayAdapter = new ArrayAdapter<>(activity.getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,
                arrayList);


        levelarrayList = new ArrayList<>();
        levelarrayList.add("0");
        levelarrayList.add("1");
        levelarrayList.add("2");
        levelarrayList.add("3");
        levelarrayList.add("4");
        levelarrayList.add("5");

        levelarrayAdapter = new ArrayAdapter<>(activity.getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,
                levelarrayList);

        spinner2.setAdapter(arrayAdapter);
        wodlevelspinner.setAdapter(levelarrayAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(activity.getApplicationContext(),arrayList.get(i)+"가 선택되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        userwodgeneratebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String wodtype = spinner2.getSelectedItem().toString();
                String wodlevel= wodlevelspinner.getSelectedItem().toString();
                if (wodtype.equals("FORTIME")) {


                    //activity.tmpwod=new WOD(activity.excelscrapper.userinfo,"FORTIME");

                   //  wodManager.make("FORTIME");
                    activity.tmpwod= activity.wodmanger.make("FORTIME",Integer.parseInt(wodlevel));
                    String createdwodname=createwodname.getText().toString();
                    activity.tmpwod.setWODname(createdwodname);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, activity.createwodselectionFragment).commit();


                } else {


                    //  wodManager.make("FORTIME");
                    activity.tmpwod= activity.wodmanger.make("AMRAP",Integer.parseInt(wodlevel));
                    String createdwodname=createwodname.getText().toString();
                    activity.tmpwod.setWODname(createdwodname);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, activity.createwodselectionFragment).commit();

                }
            }
        });







        return rootView;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        //이 메소드가 호출될떄는 프래그먼트가 엑티비티위에 올라와있는거니깐 getActivity메소드로 엑티비티참조가능
        activity = (MainActivity) getActivity();
    }
}