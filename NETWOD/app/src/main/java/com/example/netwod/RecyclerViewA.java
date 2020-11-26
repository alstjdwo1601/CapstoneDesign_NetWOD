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

public class RecyclerViewA extends RecyclerView.Adapter<RecyclerViewA.ViewHolder> {
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
        public Button listdeletebutton;

        public ViewHolder(View view) {
            super(view);

            this.textView = view.findViewById(R.id.textView);
            this.textView2 = view.findViewById(R.id.textView2);
            this.textView3 = view.findViewById(R.id.textview3);

            this.listdeletebutton=activity.findViewById(R.id.listdeletebutton);

        }
    }

    @Override
    public RecyclerViewA.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        RecyclerViewA.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    RecyclerViewA(MainActivity a) {
        //this.activity.excelscrapper.userinfo=new MainActivity.ExcelScrapper.activity.excelscrapper.userinfo();

        this.activity=a;

    }

    @Override
    public void onBindViewHolder(RecyclerViewA.ViewHolder holder, final int position) {
        //holder.textView.setText(title[position]);


        
        holder.listdeletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                activity.excelscrapper.userinfo.getUserwodlist().remove(activity.excelscrapper.userinfo.getCurrentwodindex());

                notifyDataSetChanged();
            }
        });
        for(int i=0;i<activity.excelscrapper.userinfo.getUserwodlist().size();i++){
            clickedlist.add(0);


        }

        int msize = activity.excelscrapper.userinfo.getUserwodlist().get(position).getMovement().size();
        int titlesize = activity.excelscrapper.userinfo.getUserwodlist().get(position).getWODname().length();
        int typesize = activity.excelscrapper.userinfo.getUserwodlist().get(position).getWODtype().length();
        String movementstring="";
        String titlestring="";
        String typestring="";
        for(int i=0; i<titlesize;i++){
            titlestring=titlestring+"\n"+activity.excelscrapper.userinfo.getUserwodlist().get(position).getWODname().charAt(i);
        }
        for(int i=0; i<typesize;i++){
            typestring=typestring+"\n"+activity.excelscrapper.userinfo.getUserwodlist().get(position).getWODtype().charAt(i);
        }
        for (int i = 0; i < msize; i++){
            movementstring=movementstring+"\n"+activity.excelscrapper.userinfo.getUserwodlist().get(position).getMovement().get(i);
            if(!activity.excelscrapper.userinfo.getUserwodlist().get(position).getWeightlist().get(i).equals("0")&&!activity.excelscrapper.userinfo.getUserwodlist().get(position).getWeightlist().get(i).equals("")){
                movementstring=movementstring+" "+activity.excelscrapper.userinfo.getUserwodlist().get(position).getWeightlist().get(i)+"kg";
            }
            movementstring=movementstring+" "+activity.excelscrapper.userinfo.getUserwodlist().get(position).getMovementnum().get(i)+"times/meters";
    }
        holder.textView.setText(titlestring);
        holder.textView2.setText(typestring);
        holder.textView3.setText(movementstring);
        if(clickedlist.get(position)==1) {
            holder.textView.setBackgroundColor(Color.YELLOW);
        }
        else holder.textView.setBackgroundColor(Color.WHITE);

        holder.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(v.getContext(), position+"번 째 이미지!", Toast.LENGTH_SHORT).show();

            }
        });

        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(v.getContext(), "Test!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), position+"번 째!", Toast.LENGTH_SHORT).show();
               if(clickedlist.get(position)==0) {
                   holder.textView.setBackgroundColor(Color.YELLOW);
                   activity.excelscrapper.userinfo.setCurrentwodindex(position);
                   clickedlist.set(position, 1);


               }
               else {
                   holder.textView.setBackgroundColor(Color.WHITE);

                   clickedlist.set(position, 0);
               }




            }
        });




    }

    @Override
    public int getItemCount() {

        return activity.excelscrapper.userinfo.getUserwodlist().size();

        //return 3;
    }
}