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
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

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
    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
        activity.dashboardwodlist.clear();

        activity.dashboardusernamelist.clear();
        activity.dashboardboardcommentlist.clear();


        super.onDestroyView();
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_dashboard , container, false);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("WODdashboard")
                .limit(10)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                activity.dashboardusernamelist.add(document.getString("Username"));
                                System.out.println("데쉬보드와드이름:"+document.getString("Username"));
                                activity.dashboardboardcommentlist.add(document.getString("Description"));
                                System.out.println("데쉬보드코멘트:"+document.getString("Description"));
                                WOD wod=new WOD();
                                HashMap a=(HashMap)document.get("WOD");
                                wod.setWODname(a.get("wodname").toString());
                                wod.setWODtype(a.get("wodtype").toString());
                                wod.setEquipment((ArrayList<String>) a.get("equipment"));
                                wod.setMovement((ArrayList<String>) a.get("movement"));
                                wod.setMovementnum((ArrayList<String>) a.get("movementnum"));
                                wod.setWeightlist((ArrayList<String>) a.get("weightlist"));
                                wod.setWODlevel(a.get("wodlevel").toString()                   );
                                //WOD wod=(WOD)document.getData().get("WOD");
                                activity.dashboardwodlist.add(wod);




                            }
                            recyclerView = rootView.findViewById(R.id.recycler_view);
                            recyclerView.setHasFixedSize(true);
                            layoutManager = new LinearLayoutManager(activity);



                            recyclerView.setLayoutManager(layoutManager);

                            adapter = new RecyclerViewDashboard(activity);
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