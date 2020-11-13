package com.example.netwod;


import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import androidx.annotation.NonNull;
import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import static android.content.ContentValues.TAG;


public class ExcelDbAdapter {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    UserInfo userinfo=new UserInfo();
    String sdCardPath;
    FileInputStream is=null;
    File file;


    public void ExcelScrapper(String s){
        this.sdCardPath=s;
    }


    //
    // 개인정보받아서 Firebase로 넘기기 (아이디, 비번)
    //
    public void setUserInfoToFirebase(String id , String password){
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("password", password);


        // Add a new document with a generated ID
        db.collection("UserInfo")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }


    //
    // 개인정보 Firebase에서 받아오기 (아이디,비번)
    //
    public void getUserinfoFromFirebase() throws IOException, BiffException {

        //Firestore에서 저장된 값 불러오기
        db.collection("UserInfo")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {

                                document.getString("id");
                                document.getString("password");
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }



    //
    // 랭킹정보 받아서 Firebase로 넘기기 (와드이름, 와드레벨, 와드타입,
    //                                 점수 , 기록, 등수 , 날짜)
    //
    public void setRankInfoToFirebase(WODrecord woDrecord){
        Map<String, Object> rank = new HashMap<>();

        //rank.put("WODname", );
        //rank.put("WODtype", );
        //rank.put("WODlevel", );
        //rank.put("WODscore", );
        //rank.put("WODrecord", );
        //rank.put("Date", );
        //rank.put("Ranking", );

        // Add a new document with a generated ID
        db.collection("RankInfo")
                .add(rank)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }




    //
    // 랭킹정보 Firebase에서 받아오기 (와드이름, 와드레벨, 와드타입,
    //                               점수 , 기록, 등수 , 날짜)
    //
    public void getRankInfoFromFirebase() throws IOException, BiffException {

        //Firestore에서 저장된 값 불러오기
        db.collection("RankInfo")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Log.d(TAG, "와드 레벨 : " + document.getString("WODlevel"));
                                Log.d(TAG, "와드 이름 : " + document.getString("WODname"));
                                Log.d(TAG, "와드 기록 : " + document.getString("WODrecord"));
                                Log.d(TAG, "와드 점수 : " + document.getString("WODscore"));
                                Log.d(TAG, "와드 타입 : " + document.getString("WODtype"));
                                Log.d(TAG, "랭킹 : " + document.getString("Ranking"));
                                Log.d(TAG, "날짜 : " + document.getString("Date"));

                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }



}
