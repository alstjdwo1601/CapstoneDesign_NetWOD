package com.example.netwod;

import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class RecyclerViewMovement extends RecyclerView.Adapter<RecyclerViewMovement.ViewHolder> {

    public ArrayList<String> movementarraylist=new ArrayList<String>(Arrays.asList("NAME"));
    public ArrayList<String> repetitionarraylist=new ArrayList<String>(Arrays.asList("REP"));
    public ArrayList<String> weightarraylist=new ArrayList<String>(Arrays.asList("WEIGHT"));
    public String roundnum;
    public MainActivity activity;




    public class ViewHolder extends  RecyclerView.ViewHolder {

        public TextView movementtextview;
        public TextView repetitiontextview;
        public TextView roundnumtextview;
        public TextView weighttextview;
        public Button movementaddbutton;
        public Button generatewodaddbutton;

        public ViewHolder(View view) {
            super(view);
            this.movementtextview=view.findViewById(R.id.recyclermovement);
            this.repetitiontextview=view.findViewById(R.id.recyclerrepetition);
            this.weighttextview=view.findViewById(R.id.recyclerweight);

            this.roundnumtextview=activity.findViewById(R.id.fortimeroundedittext);
            this.movementaddbutton=activity.findViewById(R.id.fortimeaddmovementbutton);
            this.generatewodaddbutton=activity.findViewById(R.id.fortimeaddbutton);

        }
    }
    RecyclerViewMovement(MainActivity a) {

        this.activity=a;

    }

    @Override
    public RecyclerViewMovement.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movementitem, parent, false);

        RecyclerViewMovement.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewMovement.ViewHolder holder, final int position) {


        holder.movementtextview.setText(movementarraylist.get(position));
        holder.repetitiontextview.setText(repetitionarraylist.get(position));
        holder.weighttextview.setText(weightarraylist.get(position));


        holder.movementaddbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Spinner movementname=activity.findViewById(R.id.movementspinner);
                String movementnamestring=movementname.getSelectedItem().toString();


                movementarraylist.add(movementnamestring         );
                EditText repetition=activity.findViewById(R.id.fortimerepetitionedittext);
                String repetitionstring=repetition.getText().toString();
                repetitionarraylist.add(repetitionstring);
                EditText weight= activity.findViewById(R.id.fortimeweightedittext);
                String weightstring=weight.getText().toString();
                weightarraylist.add(weightstring);


                notifyDataSetChanged();


            }
        });
        holder.generatewodaddbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roundnum=holder.roundnumtextview.getText().toString();
                int roundnumint=Integer.parseInt(roundnum);
                for(int j=0;j<roundnumint;j++) {
                    for (int i = 1; i < movementarraylist.size(); i++) {
                        activity.tmpwod.getMovement().add(movementarraylist.get(i));

                        activity.tmpwod.getWeightlist().add(weightarraylist.get(i));
                        activity.tmpwod.getMovementnum().add(repetitionarraylist.get(i));


                    }
                }
                activity.excelscrapper.userinfo.getUserwodlist().add(activity.tmpwod);
                activity.tmpwod=new WOD();
            }
        });


        holder.movementtextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;




                Toast.makeText(v.getContext(), "Test!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {

       return movementarraylist.size();

    }


}