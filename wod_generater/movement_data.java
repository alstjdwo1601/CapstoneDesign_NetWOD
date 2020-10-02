package project;

public class movement_data {

	private String[] equipment = new String[] {
	"Barbell" // 0~13
	,"Body" // 14 ~
	,"Pull-Up Bar"
	,"Jump Rope"
	,"Kettlebell"
	,"Wall Ball"
	,"Box"	
	};
	
	private String[] movement_name = new String[]{"Thrusters" // 0 barbell start
			,"Overhead Squarts"
			,"Deadlifts"
			,"Hang Power Cleans"
			,"Push Jerks"
			,"Power Clean"
			,"Front Squat"
			,"Push Press"
			,"Back Squat"
			,"Clean-and-Jerks"
			,"Deadlift"
			,"Bench"
			,"Clean"
			,"Push Presses" // 13 barbell end
			,"Burpees" // 14 body start
			,"Push-Ups"
			,"Lunges"
			,"Air Squats"
			,"Run"
			,"Sit-Ups"
			,"Walking Lunge Steps"
			,"Back Extensions"
			,"Burpee"
			,"Mountain Climbers"
			,"Split Squat Jumps"
			,"Squat Jumps"
			,"Walking Lunges"
			,"Handstand Push-Ups"//27 body end
			,"Jumping Pull-Ups" // 28 Pull-up bar start
			,"Pull-Ups"
			,"Knees-to-Elbows" // 30 Pull-up bar end
			,"Double-Unders" // 31Jump Rope
			,"Kettlebell Swings" // Kettle bell 
			,"Wall Ball Shots" // Wall Ball
			,"Box Jumps"};  // Box

	
	
	public String return_equip(String a) {
		for (int i = 0; i < movement_name.length ;i++) {
			if (movement_name[i].equals(a)) {
				if(i < 14)
					return equipment[0];
				else if(i < 28)
					return equipment[1];
				else if(i < 31)
					return equipment[2];
				else if(i == 31 )
					return equipment[3];
				else if(i == 32 )
					return equipment[4];
				else if(i == 33 )
					return equipment[5];
				else if(i == 34 )
					return equipment[6];
			} 
			
		}
		
		
		return "No answer"; // equitment add or movement add
	}
	
	public int return_score(String a) {
		for (int i = 0; i < movement_name.length ;i++) {
			if (movement_name[i].equals(a)) {
				if(i < 14)
					return 5;
				else if(i < 28)
					return 1;
				else if(i < 31)
					return 4;
				else if(i == 31 )
					return 2;
				else if(i == 32 )
					return 2;
				else if(i == 33 )
					return 2;
				else if(i == 34 )
					return 1;
			} 
			
		}
		
		
		return -1; // equitment add or movement add
	}
	

	
	
}
