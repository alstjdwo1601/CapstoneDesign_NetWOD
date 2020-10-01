package com.example.netwod;


import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.FileReader;
import java.util.List;
import com.opencsv.CSVReader;
public class RecyclerViewHelp extends RecyclerView.Adapter<RecyclerViewHelp.ViewHolder> {
    private String[] title={"Thrusters","Overhead Squats","Deadlifts","Hang Power Cleans","Push Jerks","Power Clean","Front Squat","Push Press","Back Squat","Clean-and-Jerks","Deadlift",
            "Bench","Clean","Push Presses","Burpees","Push-Ups","Lunges","Air Squats","Run","Sit-Ups","Walking Lunge Steps","Back Extensions","Burpee",
            "Mountain Climbers","Split Squat Jumps","Squat Jumps","Walking Lunges","Handstand Push-Ups","Jumping Pull-Ups","Pull-Ups",
            "Knees-to-Elbows","Double-Unders","Kettlebell Swings","Wall Ball Shots","Box Jumps",
    };
    private String[] type={};
    //CSVReader reader = new CSVReader(new FileReader("tt.csv"));
    //List myEntries = reader.readAll();

    private String[] content = {"WODmovements","WODmovements2","WODmovement3" };

    public class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView2;
        public ImageView imageView;


        public ViewHolder(View view) {
            super(view);
            this.textView = view.findViewById(R.id.textView);
            this.textView2 = view.findViewById(R.id.textView2);

        }
    }

    @Override
    public RecyclerViewHelp.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.helpitem, parent, false);
        RecyclerViewHelp.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHelp.ViewHolder holder, final int position) {
        holder.textView.setText(title[position]);
        holder.textView2.setText(type[position]);
    /*
    position
    1Thrusters
2Overhead Squarts
3Deadlifts
4Hang Power Cleans
5Push Jerks
6Power Clean
7Front Squat
8Push Press
9Back Squat
10Clean-and-Jerks
11Deadlift
12Bench
13Clean
14Push Presses
15Burpees
16Push-Ups
17Lunges
18Air Squats
19Run
20Sit-Ups
21Walking Lunge Steps
22Back Extensions
23Burpee
24Mountain Climbers
25Split Squat Jumps
26Squat Jumps
27Walking Lunges
28Handstand Push-Ups
29Jumping Pull-Ups
30Pull-Ups
31Knees-to-Elbows
32Double-Unders
33Kettlebell Swings
34Wall Ball Shots
35Box Jumps



     */


        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                v.getContext().startActivity(intent);

                Toast.makeText(v.getContext(), "Test!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String URL;





                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                v.getContext().startActivity(intent);
                Toast.makeText(v.getContext(), position+"번 째!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }
}