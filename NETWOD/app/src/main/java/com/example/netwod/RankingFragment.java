package com.example.netwod;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RankingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RankingFragment extends Fragment {

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

    MainActivity activity;
    public RankingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RankingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RankingFragment newInstance(String param1, String param2) {
        RankingFragment fragment = new RankingFragment();
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
    public void onAttach(Context context) {
        super.onAttach(context);
        //이 메소드가 호출될떄는 프래그먼트가 엑티비티위에 올라와있는거니깐 getActivity메소드로 엑티비티참조가능
        activity = (MainActivity) getActivity();


    }



    @Override
    public void onDestroyView(){
        activity = (MainActivity) getActivity();
        activity.rankwodrecord.wodlist.clear();
        activity.rankwodrecord.scorelist.clear();
        activity.rankwodrecord.recordlist.clear();
        activity.rankusernamelist.clear();
        activity.rankwoddatelist.clear();
        activity.ranklist.clear();
        System.out.println("destroyview");
        super.onDestroyView();
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_ranking , container, false);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("RankInfo")
                .orderBy("SCORE", Query.Direction.DESCENDING).limit(10)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                activity.rankusernamelist.add(document.getString("Username"));
                                activity.rankwoddatelist.add(document.getString("Date"));
                                activity.ranklist.add(document.getString("RANKING"));
                                WOD wod=new WOD();
                                HashMap a=(HashMap)document.get("WOD");
                                wod.setWODname(a.get("wodname").toString());
                                wod.setWODtype(a.get("wodtype").toString());
                                wod.setEquipment((ArrayList<String>) a.get("equipment"));
                                wod.setMovement((ArrayList<String>) a.get("movement"));
                                wod.setMovementnum((ArrayList<String>) a.get("movementnum"));
                                wod.setWeightlist((ArrayList<String>) a.get("weightlist"));

                                //WOD wod=(WOD)document.getData().get("WOD");
                                activity.rankwodrecord.wodlist.add(wod);
                                System.out.println("  activity.rankwodrecord.wodlist.add(wod);:"+activity.rankwodrecord.wodlist.size());

                                activity.rankwodrecord.scorelist.add(document.getString("SCORE"));
                                activity.rankwodrecord.recordlist.add(document.getString("RECORD"));


                            }
                            recyclerView = rootView.findViewById(R.id.recycler_view);
                            recyclerView.setHasFixedSize(true);
                            layoutManager = new LinearLayoutManager(activity);



                            recyclerView.setLayoutManager(layoutManager);

                            adapter = new RecyclerViewRank(activity);
                            recyclerView.setAdapter(adapter);
                        } else {

                        }
                    }
                });



        //Firestore에서 게시판 정보 저장된 값 불러오기

      /*
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(activity);



        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewRank(activity);
        recyclerView.setAdapter(adapter);
*/
//끝



        return rootView;
    }
}