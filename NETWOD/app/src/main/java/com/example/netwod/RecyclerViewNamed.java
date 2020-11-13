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

public class RecyclerViewNamed extends RecyclerView.Adapter<RecyclerViewNamed.ViewHolder> {
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
        private Button namedwodaddbutton;

        public ViewHolder(View view) {
            super(view);

            this.textView = view.findViewById(R.id.namedwodnametextview);
            this.textView2 = view.findViewById(R.id.namedwodtypetextview);
            this.textView3 = view.findViewById(R.id.namedwodmovementtextview);
            this.namedwodaddbutton=activity.findViewById(R.id.namedselectbutton);
      

        }
    }

    @Override
    public RecyclerViewNamed.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.namedwod, parent, false);
        RecyclerViewNamed.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    RecyclerViewNamed(MainActivity a) {
        //this.activity.excelscrapper.userinfo=new MainActivity.ExcelScrapper.activity.excelscrapper.userinfo();

        this.activity=a;

    }

    @Override
    public void onBindViewHolder(RecyclerViewNamed.ViewHolder holder, final int position) {
        //holder.textView.setText(title[position]);


     
        for(int i=0;i<activity.namedwodlist.size();i++){
            clickedlist.add(0);


        }
        holder.namedwodaddbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int namedwodindex=activity.namedwodindex;
                activity.excelscrapper.userinfo.getUserwodlist().add(activity.namedwodlist.get(namedwodindex));


                notifyDataSetChanged();
            }
        });
        int msize = activity.namedwodlist.get(position).getMovement().size();
        int titlesize = activity.namedwodlist.get(position).getWODname().length();
        int typesize = activity.namedwodlist.get(position).getWODtype().length();
        String movementstring="";
        String titlestring="";
        String typestring="";
        for(int i=0; i<titlesize;i++){

            titlestring=titlestring+"\n"+activity.namedwodlist.get(position).getWODname().charAt(i);


        }
        for(int i=0; i<typesize;i++){

            typestring=typestring+"\n"+activity.namedwodlist.get(position).getWODtype().charAt(i);


        }

        for (int i = 0; i < msize; i++){
            movementstring=movementstring+"\n"+activity.namedwodlist.get(position).getMovement().get(i);
            if(!activity.namedwodlist.get(position).getWeightlist().get(i).equals("")&&!activity.namedwodlist.get(position).getWeightlist().get(i).equals("0")){
                movementstring=movementstring+" "+activity.namedwodlist.get(position).getWeightlist().get(i)+"kg";
            }
            movementstring=movementstring+" "+activity.namedwodlist.get(position).getMovementnum().get(i)+"times";
        }
        holder.textView.setText(titlestring);

        holder.textView2.setText(typestring);
        //movementstring=activity.namedwodlist.get(position).getMovement().get(0);

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
                    activity.namedwodindex=position;
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
        System.out.println("유저와드리스트사이즈:"+activity.namedwodlist.size());
        return activity.namedwodlist.size();

        //return 3;
    }
}