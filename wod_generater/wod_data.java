package project;

import java.util.ArrayList;

public class wod_data{  // data type  .xlsx form
	public String name;
    public ArrayList<String> movement_list = new ArrayList<>();
	public ArrayList<Integer> weight = new ArrayList<Integer>();
	public ArrayList<Integer> Reps = new ArrayList<Integer>();
	public String wodtype;
	
	
	
	
    public wod_data(){ // 
    
    wod_exaple();


    }
    
    public void wod_reader(){
    	
    	
    	
    	
    	
    	
    }
    
    public void wod_exaple() { // read xlsx form sample
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
    	wod_reader("test",first_col,Second_col,third_col,fourth_col); 	
	}
    
  
    public void wod_reader(String name,String type,String[] movements,String[] reps,String[] kg) { // read xlsx form sample

    	
    	int list_length = movements.length;
    	// start 
    	
    	this.name = name; // after modify
    	this.wodtype = type; // fortime = 0 , AMRAP =1 else =2
    	
    	for (int i = 0 ; i < list_length; i++) { // just 1 wod after modify
    		this.movement_list.add(movements[i]);
    		this.weight.add(Integer.parseInt(reps[i]));
    		this.Reps.add(Integer.parseInt(kg[i]));
    			
    	} 
    	
    
    	
    	
	}
    
    public void wod_fortime(String[] movements) {}
    public void wod_AMRAP(String[] movements) {}
    public void wod_EMON(String[] movements) {}
    
    

}
