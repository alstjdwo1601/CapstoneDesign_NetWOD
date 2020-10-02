package project;

import java.util.ArrayList;

public class wod_data{  // data type  .xlsx form
	public String name;
    public ArrayList<String> movement_list = new ArrayList<>();
	public ArrayList<Integer> weight = new ArrayList<Integer>();
	public ArrayList<Integer> Reps = new ArrayList<Integer>();
	public int wodtype;
    public wod_data(){ // 
    
    wod_reader();


    }
    
    public void wod_reader() { // read xlsx form sample
    	String first_col = "fortime";
    	String[] Second_col = {"Thrusters"
    			,"Pull-Ups"
    			,"Thrusters"
    			,"Pull-Ups"
    			,"Thrusters"
    			,"Pull-Ups"};
    	String[] third_col = {"21"
    			,"21"
    			,"15"
    			,"15"
    			,"9"
    			,"9"};
    	String[] fourth_col = {"42"
    			,"0" // NULL
    			,"42"
    			,"0"
    			,"42"
    			,"0"};
    	
    	int list_length = Second_col.length; 
    	// start 
    	
    	name = "Test_WOD"; // after modify
    	wodtype = checktype(first_col); // fortime = 0 , AMRAP =1 else =2
    	
    	for (int i = 0 ; i < list_length; i++) { // just 1 wod after modify
    		movement_list.add(Second_col[i]);
    		weight.add(Integer.parseInt(fourth_col[i]));
    		Reps.add(Integer.parseInt(third_col[i]));
    		
    		
    	} 
    	
    	
    	
    	
	}

	private int checktype(String first_col) {
		if (first_col.equals("Fortime"))
			return 0;
		else if (first_col.equals("AMRAP"))
			return 1;
		else
			return 2;
	}
    
    

}
