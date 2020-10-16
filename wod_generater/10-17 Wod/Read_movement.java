package Wod;

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
			"equipment",
			"",
			"pull up bar",
			"",
			"dips bar",
			"",
			"rope climb",
			"pull up bar",
			"dumbbell",
			"",
			"",
			"",
			"",
			"",
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
	
	double[] Kg_average = {
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
			102.040816326531,
			61.2244897959184,
			61.2244897959184,
			61.2244897959184,
			61.2244897959184,
			9.0702947845805,
			31.7460317460317,
			0,
			43.0839002267574,
			0,


	};
	
	int[] rep = {
			300,
			60,
			300,
			60,
			60,
			9,
			30,
			100,
			50,
			300,
			300,
			300,
			2400,
			4800,
			2000,
			1000,
			30,
			60,
			30,
			60,
			30,
			150,
			60,
			60,
			60,
			500
	
	};
	
	
	
	
	Read_movement(){
		for(int i = 0; i < movement.length; i++){
			this.exercise_area.add(this.exercise_area_double[i]);
		}
		
	}		
			
}
	
	
