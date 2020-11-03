package wod;

import java.util.ArrayList;

public class Read_movement {
	ArrayList<int[]> exercise_area = new ArrayList<int[]>();
	
	
	
	String[] movement = {"air squat",
            "pull up",
            "push up",
            "dips",
            "handstand push up",
            "rope climb",	                            
            "muscle up",
            "handstand press",
            "back extension",
            "sit up",
            "jump",
            "runge",
            "run",
            "bicycle",
            "rowing",
            "jump rope",
            "dead lift",
            "clean",
            "bench press",
            "snatch",
            "clean and jerk",
            "medicine ball",
            "kettlebell swing",
            "Bench dips",
            "thruster"};
	
	String[] equipment = {
			"body",
			"pull up bar",
			"body",
			"dips bar",
			"body",
			"rope climb",
			"pull up bar",
			"dumbbell",
			"body",
			"body",
			"body",
			"body",
			"body",
			"bicycle",
			"rowing machine",
			"rope",
			"barbell",
			"barbell",
			"barbell",
			"barbell",
			"barbell",
			"medicine ball",
			"kettlebell",
			"bench",
			"barbell"};
	
	int[][] exercise_area_double = {
			{0,0,0,0,0,0,3,10},
			{5,3,0,10,0,5,0,0},
			{5,7,5,10,0,0,0,0},
			{5,7,5,10,0,0,0,0},
			{10,10,10,0,0,0,0,0},
			{10,0,0,10,0,5,5,0},
			{10,10,7,10,0,5,0,0},
			{10,10,10,0,0,0,0,0},
			{0,0,0,0,0,3,10,0},
			{0,0,0,0,0,0,3,10},
			{0,0,0,0,0,0,10,10},
			{0,0,0,0,0,0,10,10},
			{0,0,0,0,0,0,10,10},
			{0,0,0,0,0,0,10,10},
			{10,10,0,10,0,10,10,10},
			{0,0,0,0,0,0,10,10},
			{10,0,0,10,0,10,10,10},
			{10,10,10,5,5,10,10,5},
			{10,10,10,0,10,0,7,0},
			{10,3,10,5,0,10,10,10},
			{10,10,10,10,0,10,10,10},
			{10,10,10,10,10,10,10,10},
			{5,7,10,3,3,7,10,3},
			{5,7,5,10,0,0,0,0},
			{10,10,10,10,5,10,10,10},

	};
	
	int[] stimulate = {0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			1,
			1,
			1,
			1,
			2,
			2,
			2,
			2,
			2,
			2,
			2,
			1,
			2

			
	};
	
	double[] score = {
			0,
			2,
			1,
			2,
			2,
			2,
			3,
			2,
			0,
			0,
			0,
			0,
			0,
			0,
			2,
			0,
			2,
			3,
			3,
			3,
			3,
			1,
			2,
			0,
			3

	};
	
	double[] weight = {
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			0,
			100,
			60,
			60,
			60,
			55,
			10,
			30,
			0,
			40,
			0,


	};
	
	int[] rep = {
			100,
			20,
			100,
			20,
			20,
			3,
			10,
			50,
			25,
			100,
			100,
			100,
			800,
			1500,
			650,
			300,
			10,
			20,
			10,
			20,
			10,
			50,
			20,
			20,
			20,
			180
	
	};
	
	
	
	
	Read_movement(){
		for(int i = 0; i < movement.length; i++){
			this.exercise_area.add(this.exercise_area_double[i]);
		}
		
	}		
			
}
	
	
