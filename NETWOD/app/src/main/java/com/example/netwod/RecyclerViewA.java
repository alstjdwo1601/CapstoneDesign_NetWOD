package com.example.netwod;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class RecyclerViewA extends RecyclerView.Adapter<RecyclerViewA.ViewHolder> {
    private String[] type={"FOR TIME","FOR TIME","AMRAP" ,};

    private MainActivity.ExcelScrapper.UserInfo userinfo;
    private String[] title = {"FRAN","CINDY","OPENS10.1", };

    private String[] content = {"WODmovements","WODmovements2","WODmovement3" };
    private OnItemClick mCallback;

    public class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView2;
        public ImageView imageView;
        public TextView textView3;

        public ViewHolder(View view) {
            super(view);

            this.textView = view.findViewById(R.id.textView);
            this.textView2 = view.findViewById(R.id.textView2);
            this.textView3 = view.findViewById(R.id.textview3);


        }
    }

    @Override
    public RecyclerViewA.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        RecyclerViewA.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    RecyclerViewA(MainActivity.ExcelScrapper.UserInfo u) {
        //this.userinfo=new MainActivity.ExcelScrapper.UserInfo();
        this.userinfo=u;
    }

    @Override
    public void onBindViewHolder(RecyclerViewA.ViewHolder holder, final int position) {
        //holder.textView.setText(title[position]);

        System.out.println("recyclerView에서 position:" + position);
        //holder.textView2.setText(type[position]);

        int msize = userinfo.getWodrecord().getWodlist().get(position).getMovement().size();
        int titlesize = userinfo.getWodrecord().getWodlist().get(position).getWODname().length();
        int typesize = userinfo.getWodrecord().getWodlist().get(position).getWODtype().length();
        String movementstring="";
        String titlestring="";
        String typestring="";
        for(int i=0; i<titlesize;i++){

            titlestring=titlestring+"\n"+userinfo.getWodrecord().getWodlist().get(position).getWODname().charAt(i);


        }
        for(int i=0; i<typesize;i++){

            typestring=typestring+"\n"+userinfo.getWodrecord().getWodlist().get(position).getWODtype().charAt(i);


        }

        for (int i = 0; i < msize; i++){
            movementstring=movementstring+"\n"+userinfo.getWodrecord().getWodlist().get(position).getMovement().get(i);
            if(userinfo.getWodrecord().getWodlist().get(position).getWeightlist().get(i)!=""){
                movementstring=movementstring+" "+userinfo.getWodrecord().getWodlist().get(position).getWeightlist().get(i)+"kg";
            }
            movementstring=movementstring+" "+userinfo.getWodrecord().getWodlist().get(position).getMovementnum().get(i)+"times";
    }
        holder.textView.setText(titlestring);
        holder.textView2.setText(typestring);
        //movementstring=userinfo.getWodrecord().getWodlist().get(position).getMovement().get(0);

        holder.textView3.setText(movementstring);



        holder.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), position+"번 째 이미지!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Test!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), position+"번 째!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }
}