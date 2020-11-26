package com.example.netwod;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WodlistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WodlistFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ViewGroup rootView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    public Button listselectbutton;
    public Button listadddashboardbutton;
    MainActivity activity;
    public WodlistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WodlistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WodlistFragment newInstance(String param1, String param2) {
        WodlistFragment fragment = new WodlistFragment();
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
        activity = (MainActivity) getActivity();
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_wodlist , container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(activity);


       listselectbutton= rootView.findViewById(R.id.listselectbutton);
       listadddashboardbutton=rootView.findViewById(R.id.listadddashboardbutton);
      // listdeletebutton=rootView.findViewById(R.id.listdeletebutton);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewA(activity);
        recyclerView.setAdapter(adapter);
        listselectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(activity.excelscrapper.userinfo.getUserwodlist().get(activity.excelscrapper.userinfo.getCurrentwodindex()).getWODtype().equals("FORTIME")) {


                    activity.onFragmentChange(10);
                }
                else {
                    activity.onFragmentChange(11);
                 
                }
            }
        });
        listadddashboardbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(activity);

                ad.setTitle("Comment");       // 제목 설정
                ad.setMessage("Description for WOD");   // 내용 설정

// EditText 삽입하기
                final EditText et = new EditText(activity);

                ad.setView(et);

// 확인 버튼 설정
                ad.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        // Text 값 받아서 로그 남기기
                        String value = et.getText().toString();

                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                        Map<String, Object> user = new HashMap<>();
                        user.put("WOD", activity.excelscrapper.userinfo.userwodlist.get(activity.excelscrapper.userinfo.getCurrentwodindex()));
                       user.put("Username",activity.excelscrapper.userinfo.getUserName());
                        user.put("Description",value);
                        db.collection("WODdashboard").document()
                                .set(user)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                    }
                                });
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });

// 취소 버튼 설정
                ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();     //닫기
                        // Event
                    }
                });

// 창 띄우기
                ad.show();




                    //

            }
        });


        return rootView;
    }
}