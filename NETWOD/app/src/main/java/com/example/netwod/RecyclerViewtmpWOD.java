package com.example.netwod;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecyclerViewtmpWOD extends RecyclerView.Adapter<RecyclerViewtmpWOD.ViewHolder> {
    private String[] type;

    // public MainActivity.ExcelScrapper.activity.excelscrapper.userinfo activity.excelscrapper.userinfo;
    private String[] title;
    public MainActivity activity;
    private String[] content;
    private OnItemClick mCallback;


    public ArrayList<Integer> clickedlist=new ArrayList<Integer>();

    public class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView2;
        public ImageView imageView;
        public TextView textView3;
        public Button refreshbutton;

        public ViewHolder(View view) {
            super(view);

            this.textView = view.findViewById(R.id.textView);
            this.textView2 = view.findViewById(R.id.textView2);
            this.textView3 = view.findViewById(R.id.textview3);

            this.refreshbutton=activity.findViewById(R.id.createnewwodbutton);

        }
    }

    @Override
    public RecyclerViewtmpWOD.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        RecyclerViewtmpWOD.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    RecyclerViewtmpWOD(MainActivity a) {
        //this.activity.excelscrapper.userinfo=new MainActivity.ExcelScrapper.activity.excelscrapper.userinfo();

        this.activity=a;

    }

    @Override
    public void onBindViewHolder(RecyclerViewtmpWOD.ViewHolder holder, final int position) {
        //holder.textView.setText(title[position]);



        holder.refreshbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wodtype=activity.tmpwod.getWODtype();
                String wodname=activity.tmpwod.getWODname();
                //System.out.println("새로고침 눌렀을때 와드타입:"+wodtype);
              activity.tmpwod=new WOD(activity.excelscrapper.userinfo,wodtype);
              activity.tmpwod.setWODname(wodname);
              System.out.println("새로고침 눌러서 갱신되었을때 와드타입:"+activity.tmpwod.getWODtype());
                notifyDataSetChanged();
            }
        });
        /* 이거필요없으려나?
        for(int i=0;i<activity.excelscrapper.userinfo.getUserwodlist().size();i++){
            clickedlist.add(0);


        }
*/
        int msize =    activity.tmpwod.getMovement().size();
        int titlesize = activity.tmpwod.getWODname().length();
        int typesize = activity.tmpwod.getWODtype().length();
        String movementstring="";
        String titlestring="";
        String typestring="";
        for(int i=0; i<titlesize;i++){
            titlestring=titlestring+"\n"+activity.tmpwod.getWODname().charAt(i);
        }
        for(int i=0; i<typesize;i++){
            typestring=typestring+"\n"+activity.tmpwod.getWODtype().charAt(i);
        }
        for (int i = 0; i < msize; i++){
            movementstring=movementstring+"\n"+activity.tmpwod.getMovement().get(i);
            if(activity.tmpwod.getWeightlist().get(i)!=""){
                movementstring=movementstring+" "+activity.tmpwod.getWeightlist().get(i)+"kg";
            }
            movementstring=movementstring+" "+activity.tmpwod.getMovementnum().get(i)+"times";
        }
        holder.textView.setText(titlestring);
        holder.textView2.setText(typestring);
        holder.textView3.setText(movementstring);









    }

    @Override
    public int getItemCount() {

        return 1;

        //return 3;
    }
}