package com.example.netwod;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WodgenerateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WodgenerateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ViewGroup rootView;
    private CardView wodlistcard;
    private CardView wodgeneratecard;
    private CardView helpcard;
    MainActivity activity;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WodgenerateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WodgenerateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WodgenerateFragment newInstance(String param1, String param2) {
        WodgenerateFragment fragment = new WodgenerateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //이 메소드가 호출될떄는 프래그먼트가 엑티비티위에 올라와있는거니깐 getActivity메소드로 엑티비티참조가능
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //이제 더이상 엑티비티 참초가안됨
        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //프래그먼트 메인을 인플레이트해주고 컨테이너에 붙여달라는 뜻임
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_wodgenerate , container, false);

        wodlistcard = rootView.findViewById(R.id.GenerataWODcard);
        wodlistcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, activity.createwodFragment).commit();

            }
        });
        wodgeneratecard = rootView.findViewById(R.id.CustomWODcard);
        wodgeneratecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, activity.userwodgenerateFragment).commit();



            }
        });
        helpcard = rootView.findViewById(R.id.FamousWODcard);
        helpcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(12);
            }
        });
        /*
        LinearLayout selectwodlayout = rootView.findViewById(R.id.SelectWODlayout);
        selectwodlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(5);
            }
        });

         */
        return rootView;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


}