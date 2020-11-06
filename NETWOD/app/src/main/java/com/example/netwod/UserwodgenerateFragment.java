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
public class UserwodgenerateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button userwodgeneratebutton;
    EditText userwodgeneratename;
    Spinner spinner2;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;







    MainActivity activity;

    private ViewGroup rootView;
    public UserwodgenerateFragment() {
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
    public static UserwodgenerateFragment newInstance(String param1, String param2) {
        UserwodgenerateFragment fragment = new UserwodgenerateFragment();
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
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_userwodgenerate , container, false);


        userwodgeneratebutton=rootView.findViewById(R.id.userwodgeneratebutton);
        userwodgeneratename=rootView.findViewById(R.id.userwodgeneratename);
        spinner2=rootView.findViewById(R.id.userwodgeneratespinner);
        arrayList = new ArrayList<>();
        arrayList.add("FORTIME");
        arrayList.add("AMRAP");
        arrayAdapter = new ArrayAdapter<>(activity.getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,
                arrayList);


        spinner2.setAdapter(arrayAdapter);

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

                if (wodtype.equals("FORTIME")) {

                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, activity.fortimewodgenerateFragment).commit();


                } else {

                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, activity.amrapwodgenerateFragment).commit();


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