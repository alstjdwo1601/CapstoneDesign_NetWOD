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

public class RecyclerViewHelp extends RecyclerView.Adapter<RecyclerViewHelp.ViewHolder> {
    private String[] title={"Air Squats","Back Extensions","Back Squat","Bench Press","Box Jumps","Burpee",
            "Clean","Clean-and-Jerks","Deadlift","Double-Unders","Front Squat","Handstand Push-Ups",
            "Hang Power Cleans","Jumping Pull-Ups","Kettlebell Swings","Knees-to-Elbows",
            "Lunges","Mountain Climbers","Overhead Squats","Power Clean","Pull-Ups",
            "Push Jerks","Push Press","Push-Ups","Run","Sit-Ups","Snatch","Split Squat Jumps",
            "Squat Jumps","Thrusters","Walking Lunges","Wall Ball Shots",

    };
    private String[] type={"Body","Body","Barbell","Barbell","Box","Body","Barbell",
            "Barbell","Barbell","Jump Rope","Barbell","Body","Barbell","Pull-Up Bar",
            "Kettlebell","Pull-Up Bar","Body","Body","Barbell","Barbell","Pull-Up Bar",
            "Barbell","Barbell","Body","Body","Body","Barbell","Body","Body","Barbell","Body","Wall Ball"

    };
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


                Intent intent;
                /*
                for(int i=0;i<title.length;i++){





                }
*/




                switch (title[position]){
                    case "Air Squats":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=rMvwVtlqjTE"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Back Extensions":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=DDJtB8Zgyow"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Back Squat":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ultWZbUMPL8"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Bench Press":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=SCVCLChPQFY"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Box Jumps":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=NBY9-kTuHEk"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Burpee":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=auBLPXO8Fww"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Clean":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Ty14ogq_Vok"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Clean-and-Jerks":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=PjY1rH4_MOA"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Deadlift":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1ZXobu7JvvE"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Double-Unders":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=82jNjDS19lg"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Front Squat":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=uYumuL_G_V0"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Handstand Push-Ups":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=qbRbM6d5ddM"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Hang Power Cleans":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=0aP3tgKZcHQ"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Jumping Pull-Ups":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=fKe5S1dd0fw"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Kettlebell Swings":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=mKDIuUbH94Q"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Knees-to-Elbows":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=mxemkaycS44"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Lunges":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6SFgE2_og_s"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Mountain Climbers":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=zT-9L3CEcmk"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Overhead Squats":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=pn8mqlG0nkE"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Power Clean":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=KwYJTpQ_x5A"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Pull-Ups":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=EihD_pt2AFA"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Push Jerks":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=VrHNJXoSyXw"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Push Press":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=iaBVSJm78ko"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Push-Ups":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=0pkjOk0EiAk"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Run":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=bVpH4jkR0N4"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Sit-Ups":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_HPfXutjB1s"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Snatch":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=9xQp2sldyts"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Split Suqat Jumps":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=IrhbjZc3ka0"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Squat Jumps":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=U4s4mEQ5VqU"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Thrusters":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=L219ltL15zk"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Walking Lunges":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=L8fvypPrzzs"));
                        v.getContext().startActivity(intent);
                        break;
                    case "Wall Ball Shots":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=EqjGKsiIMCE"));
                        v.getContext().startActivity(intent);
                        break;


                    default:
                        break;

                }



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