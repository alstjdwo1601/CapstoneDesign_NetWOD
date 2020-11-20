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

public class RecyclerViewRank extends RecyclerView.Adapter<RecyclerViewRank.ViewHolder> {
    private String[] type;

    // public MainActivity.ExcelScrapper.activity.excelscrapper.userinfo activity.excelscrapper.userinfo;
    private String[] title;
    public MainActivity activity;
    private String[] content;
    private OnItemClick mCallback;


    public ArrayList<Integer> clickedlist=new ArrayList<Integer>();

    public class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView ranknametextview;
        public TextView rankdatetextview;
        public TextView rankwodnametextview;
        public TextView rankwodtypetextview;
        public TextView rankwodmovementtextview;
        public TextView rankwodrecordtextview;
        public TextView rankwodscoretextview;
        public TextView rankwodranktextview;



        public ViewHolder(View view) {
            super(view);
            this.ranknametextview=view.findViewById(R.id.rankusernametextview);
            this.rankdatetextview=view.findViewById(R.id.rankdatetextview);
            this.rankwodnametextview=view.findViewById(R.id.rankwodnametextview);
            this.rankwodtypetextview=view.findViewById(R.id.rankwodtypetextview);
            this.rankwodmovementtextview=view.findViewById(R.id.rankwodmovementtextview);
            this.rankwodrecordtextview=view.findViewById(R.id.rankwodrecordtextview);
            this.rankwodscoretextview=view.findViewById(R.id.rankwodscoretextview);
            this.rankwodranktextview=view.findViewById(R.id.rankwodranktextview);






        }
    }

    @Override
    public RecyclerViewRank.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rank, parent, false);
        RecyclerViewRank.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    RecyclerViewRank(MainActivity a) {
        //this.activity.excelscrapper.userinfo=new MainActivity.ExcelScrapper.activity.excelscrapper.userinfo();

        this.activity=a;

    }

    @Override
    public void onBindViewHolder(RecyclerViewRank.ViewHolder holder, final int position) {
        //holder.textView.setText(title[position]);

        System.out.println("recyclerView에서 position:" + position);


        //int recordsize =activity.rankwodrecordarraylist.get(position).recordlist.length();
        int rankusernamesize=activity.rankusernamelist.get(position).length(); //끝 ,X
        int rankdate=activity.rankwoddatelist.get(position).length(); //끝,x
        int rankwodnamesize=activity.rankwodrecord.wodlist.get(position).getWODname().length();//끝,x
        int rankwodtypesize=activity.rankwodrecord.wodlist.get(position).getWODtype().length();
        int rankwodmovementsize=activity.rankwodrecord.wodlist.get(position).getMovement().size();//끝,x
        int rankwodrecordsize=activity.rankwodrecord.recordlist.get(position).length();
        int rankwodscoresize=activity.rankwodrecord.scorelist.get(position).length();
        int ranksize=activity.ranklist.get(position).length();




        //System.out.println("리코드와드이름:"+activity.excelscrapper.userinfo.getWodrecord().wodlist.get(position).getWODname());
        String usernamestring="";
        String rankdatestring="";
        String wodtypestring="";
        String scorestring="";
        String namestring="";
        String recordstring="";
        String movementstring="";
        String rankstring="";
        for(int i=0; i<rankusernamesize;i++){
            usernamestring=usernamestring+"\n"+activity.rankusernamelist.get(position).charAt(i);

        }
        for(int i=0; i<rankdate;i++){
           rankdatestring=rankdatestring+"\n"+activity.rankwoddatelist.get(position).charAt(i);

        }
        for(int i=0; i<rankwodtypesize;i++){
           wodtypestring=wodtypestring+"\n"+activity.rankwodrecord.wodlist.get(position).getWODtype().charAt(i);

        }
        for(int i=0; i<rankwodscoresize;i++){
           scorestring=scorestring+"\n"+activity.rankwodrecord.scorelist.get(position).charAt(i);

        }
        for(int i=0; i<rankwodnamesize;i++){
           namestring=namestring+"\n"+activity.rankwodrecord.wodlist.get(position).getWODname().charAt(i);

        }
        if(activity.rankwodrecord.wodlist.get(position).getWODtype().equals("FORTIME")) {
            for (int i = 0; i < rankwodrecordsize; i++) {
                recordstring = recordstring + activity.rankwodrecord.recordlist.get(position).charAt(i);
            }
        }
        else{
            for (int i = 0; i < 2; i++) {
                recordstring = recordstring + activity.rankwodrecord.recordlist.get(position).charAt(i);
            }
            recordstring=recordstring+"rounds";
            for (int i = 3; i < 5; i++) {
                recordstring = recordstring + activity.rankwodrecord.recordlist.get(position).charAt(i);
            }
            recordstring=recordstring+"times";
        }
        for(int i=0; i<ranksize;i++){
           rankstring=rankstring+"\n"+activity.rankusernamelist.get(position).charAt(i);

        }
        for (int i = 0; i < rankwodmovementsize; i++){
            movementstring=movementstring+"\n"+activity.rankwodrecord.getWodlist().get(position).getMovement().get(i);
            if(!activity.rankwodrecord.getWodlist().get(position).getWeightlist().get(i).equals("0")&&!activity.rankwodrecord.getWodlist().get(position).getWeightlist().get(i).equals("")){
                movementstring=movementstring+" "+activity.rankwodrecord.getWodlist().get(position).getWeightlist().get(i)+"kg";
            }
            movementstring=movementstring+" "+activity.rankwodrecord.getWodlist().get(position).getMovementnum().get(i)+"times/meters";
        }


        holder.ranknametextview.setText(usernamestring);
        holder.rankdatetextview.setText(rankdatestring);
        holder.rankwodnametextview.setText(namestring);
        holder.rankwodtypetextview.setText(wodtypestring);
        holder.rankwodmovementtextview.setText(movementstring);
        holder.rankwodrecordtextview.setText(recordstring);
        holder.rankwodscoretextview.setText(scorestring);
        holder.rankwodranktextview.setText(rankstring);
        System.out.println("와드이름스트링:"+namestring);








    }

    @Override
    public int getItemCount() {
        System.out.println("랭크:"+activity.rankwodrecord.wodlist.size());
        return activity.rankwodrecord.wodlist.size();

        //return 3;
    }
}