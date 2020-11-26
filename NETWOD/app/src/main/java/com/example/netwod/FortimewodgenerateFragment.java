package com.example.netwod;

import android.content.Context;
import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


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
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FortimewodgenerateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button addmovementbutton;
    Button addwodlistbutton;
    EditText fortimerepetition;
    EditText fortimeweight;
    EditText fortimeround;
    Spinner spinner2;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    private RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;






    MainActivity activity;

    private ViewGroup rootView;
    public FortimewodgenerateFragment() {
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
    public static FortimewodgenerateFragment newInstance(String param1, String param2) {
        FortimewodgenerateFragment fragment = new FortimewodgenerateFragment();
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
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_fortimewodgenerate , container, false);
        Button addmovementbutton;
        Button addwodlistbutton;
        EditText fortimerepetition;
        EditText fortimeweight;
        EditText fortimeround;
        addmovementbutton=rootView.findViewById(R.id.fortimeaddmovementbutton);
        addwodlistbutton=rootView.findViewById(R.id.fortimeaddbutton);
        fortimerepetition=rootView.findViewById(R.id.fortimerepetitionedittext);
        fortimeweight=rootView.findViewById(R.id.fortimeweightedittext);
        fortimeround=rootView.findViewById(R.id.fortimeroundedittext);
        spinner2=rootView.findViewById(R.id.movementspinner);
        /*
        "Air Squats","Back Extensions","Back Squat","Bench Press","Box Jumps","Burpee",
            "Clean","Clean-and-Jerks","Deadlift","Double-Unders","Front Squat","Handstand Push-Ups",
            "Hang Power Cleans","Jumping Pull-Ups","Kettlebell Swings","Knees-to-Elbows",
            "Lunges","Mountain Climbers","Overhead Squats","Power Clean","Pull-Ups",
            "Push Jerks","Push Press","Push-Ups","Run","Sit-Ups","Snatch","Split Squat Jumps",
            "Squat Jumps","Thrusters","Walking Lunges","Wall Ball Shots",
        */
        arrayList = new ArrayList<>(Arrays.asList("Air Squats","Back Extensions","Back Squat","Bench Press","Box Jumps","Burpee",
                "Clean","Clean-and-Jerks","Deadlift","Double-Unders","Front Squat","Handstand Push-Ups",
                "Hang Power Cleans","Jumping Pull-Ups","Kettlebell Swings","Knees-to-Elbows",
                "Lunges","Mountain Climbers","Overhead Squats","Power Clean","Pull-Ups",
                "Push Jerks","Push Press","Push-Ups","Run","Sit-Ups","Snatch","Split Squat Jumps",
                "Squat Jumps","Thrusters","Walking Lunges","Wall Ball Shots")    );


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
//여기서
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(activity);



        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewMovement(activity);
        recyclerView.setAdapter(adapter);








        return rootView;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        //이 메소드가 호출될떄는 프래그먼트가 엑티비티위에 올라와있는거니깐 getActivity메소드로 엑티비티참조가능
        activity = (MainActivity) getActivity();
    }




}