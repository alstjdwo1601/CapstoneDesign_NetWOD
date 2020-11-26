package com.example.netwod;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewDashboard extends RecyclerView.Adapter<RecyclerViewDashboard.ViewHolder> {
    private String[] type;

    // public MainActivity.ExcelScrapper.activity.excelscrapper.userinfo activity.excelscrapper.userinfo;
    private String[] title;
    public MainActivity activity;
    private String[] content;
    private OnItemClick mCallback;


    public ArrayList<Integer> clickedlist=new ArrayList<Integer>();

    public class ViewHolder extends  RecyclerView.ViewHolder {
      public TextView dashboardusertextview;
      public TextView dashboardwodnametextview;
      public TextView dashboardwodtypetextview;
      public TextView dashboardmovementtextview;
      public TextView dashboardwodlelveltextview;




        public ViewHolder(View view) {
            super(view);
            this.dashboardusertextview=view.findViewById(R.id.dashboardusername);
            this.dashboardwodnametextview=view.findViewById(R.id.dashboardwodname);
            this.dashboardwodtypetextview=view.findViewById(R.id.dashboardwodtype);
            this.dashboardmovementtextview=view.findViewById(R.id.dashboardmovement);
            this.dashboardwodlelveltextview=view.findViewById(R.id.dashboardwodlevel);







        }
    }

    @Override
    public RecyclerViewDashboard.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard, parent, false);
        RecyclerViewDashboard.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    RecyclerViewDashboard(MainActivity a) {
        //this.activity.excelscrapper.userinfo=new MainActivity.ExcelScrapper.activity.excelscrapper.userinfo();

        this.activity=a;

    }

    @Override
    public void onBindViewHolder(RecyclerViewDashboard.ViewHolder holder, final int position) {
        //holder.textView.setText(title[position]);

/*
            this.dashboardusertextview=view.findViewById(R.id.dashboardusername);
            this.dashboardwodnametextview=view.findViewById(R.id.dashboardwodname);
            this.dashboardwodtypetextview=view.findViewById(R.id.dashboardwodtype);
            this.dashboardmovementtextview=view.findViewById(R.id.dashboardmovement);
            this.dashboardwodlelveltextview=view.findViewById(R.id.dashboardwodlevel);
 */
int dashboardusernamesize=activity.dashboardusernamelist.get(position).length();
int dashboardwodnamesize=activity.dashboardwodlist.get(position).getWODname().length();
int dashboardwodtypesize=activity.dashboardwodlist.get(position).getWODtype().length();
int dashboardwodmovementsize=activity.dashboardwodlist.get(position).getMovement().size();
int dashboardwodlevelsize=activity.dashboardwodlist.get(position).getWODlevel().length();






        String usernamestring="";

        String namestring="";
        String wodtypestring="";




        String movementstring="";
        String wodlevelstring="";
        for(int i=0; i<dashboardusernamesize;i++){
            usernamestring=usernamestring+"\n"+activity.dashboardusernamelist.get(position).charAt(i);

        }

        for(int i=0; i<dashboardwodtypesize;i++){
            wodtypestring=wodtypestring+"\n"+activity.dashboardwodlist.get(position).getWODtype().charAt(i);

        }

        for(int i=0; i<dashboardwodnamesize;i++){
            namestring=namestring+"\n"+activity.dashboardwodlist.get(position).getWODname().charAt(i);

        }
        wodlevelstring=activity.dashboardwodlist.get(position).getWODlevel();

        for (int i = 0; i < dashboardwodmovementsize; i++){
            movementstring=movementstring+"\n"+activity.dashboardwodlist.get(position).getMovement().get(i);
            if(!activity.dashboardwodlist.get(position).getWeightlist().get(i).equals("0")&&!activity.dashboardwodlist.get(position).getWeightlist().get(i).equals("")){
                movementstring=movementstring+" "+activity.dashboardwodlist.get(position).getWeightlist().get(i)+"kg";
            }
            movementstring=movementstring+" "+activity.dashboardwodlist.get(position).getMovementnum().get(i)+"times/meters";
        }


        holder.dashboardusertextview.setText(usernamestring);

        holder.dashboardwodnametextview.setText(namestring);
        holder.dashboardwodtypetextview.setText(wodtypestring);
        holder.dashboardmovementtextview.setText(movementstring);
      holder.dashboardwodlelveltextview.setText(wodlevelstring);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(activity);
                String usercomment;
                usercomment=activity.dashboardboardcommentlist.get(position);
                ad.setTitle("USER'S COMMENT");       // 제목 설정
                ad.setMessage(usercomment);   // 내용 설정

                // 확인 버튼 설정
                ad.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        WOD wod=new WOD();
                        wod=activity.dashboardwodlist.get(position);
                        activity.excelscrapper.userinfo.getUserwodlist().add(wod);
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });



                // 취소 버튼 설정
                ad.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();     //닫기
                        // Event
                    }
                });

                // 창 띄우기
                ad.show();


                Toast.makeText(v.getContext(), position+"번 째!", Toast.LENGTH_SHORT).show();
            }
        });







    }

    @Override
    public int getItemCount() {

        return activity.dashboardwodlist.size();

        //return 3;
    }
}