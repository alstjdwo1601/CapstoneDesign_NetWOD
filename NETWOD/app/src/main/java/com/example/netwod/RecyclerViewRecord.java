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

public class RecyclerViewRecord extends RecyclerView.Adapter<RecyclerViewRecord.ViewHolder> {
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

            this.textView = view.findViewById(R.id.recordwodnametextview);
            this.textView2 = view.findViewById(R.id.recordwodrecordtextview);
            this.textView3 = view.findViewById(R.id.recordwodscoretextview);

            this.listdeletebutton=activity.findViewById(R.id.recorddeltebutton);

        }
    }

    @Override
    public RecyclerViewRecord.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userrecord, parent, false);
        RecyclerViewRecord.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    RecyclerViewRecord(MainActivity a) {
        //this.activity.excelscrapper.userinfo=new MainActivity.ExcelScrapper.activity.excelscrapper.userinfo();

        this.activity=a;

    }

    @Override
    public void onBindViewHolder(RecyclerViewRecord.ViewHolder holder, final int position) {
        //holder.textView.setText(title[position]);

        System.out.println("recyclerView에서 position:" + position);
        //holder.textView2.setText(type[position]);

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

        int recordsize =activity.excelscrapper.userinfo.getWodrecord().recordlist.get(position).length();
        int namesize = activity.excelscrapper.userinfo.getWodrecord().wodlist.get(position).getWODname().length();
        int scoresize = activity.excelscrapper.userinfo.getWodrecord().scorelist.get(position).length();
        //System.out.println("리코드와드이름:"+activity.excelscrapper.userinfo.getWodrecord().wodlist.get(position).getWODname());
        String scorestring="";
        String namestring="";
        String recordstring="";
        for(int i=0; i<namesize;i++){
            namestring=namestring+activity.excelscrapper.userinfo.getWodrecord().wodlist.get(position).getWODname().charAt(i);

        }
        for(int i=0; i<scoresize;i++){
            scorestring=scorestring+activity.excelscrapper.userinfo.getWodrecord().scorelist.get(position).charAt(i);
        }
        for (int i = 0; i < recordsize; i++){
            recordstring=recordstring+activity.excelscrapper.userinfo.getWodrecord().recordlist.get(position).charAt(i);
             }
        holder.textView.setText(namestring);
        holder.textView2.setText(recordstring);
        holder.textView3.setText(scorestring);
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
                System.out.println(position+"번째클릭됨");



            }
        });




    }

    @Override
    public int getItemCount() {
        System.out.println("유저와드리스트사이즈:"+activity.excelscrapper.userinfo.getUserwodlist().size());
        return activity.excelscrapper.userinfo.getWodrecord().wodlist.size();

        //return 3;
    }
}