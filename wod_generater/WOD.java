package wod;

import java.util.ArrayList;

public class WOD{

    private String WODname;
    private int WODlevel;
    private ArrayList<Movement> movementlist = new ArrayList<Movement>();
    private String WODtype;


    public WOD(){
    	wod_data sample = new wod_data();
    	WODname = sample.name; 
    	WODlevel = 1;
    	WODtype = sample.wodtype;
    	for(int i = 0 ; i < sample.movement_list.size();i++) {
    		Movement movement_set = new Movement(sample.movement_list.get(i),sample.weight.get(i),sample.Reps.get(i));
    		movementlist.add(movement_set);	
    	}  
    } 

    public WOD wod_generate(int score,String name) {
    	WODname = name;
    	WODlevel = score;
    	wod_data generate = new wod_data(score);
    	
    	return this;
    }
    public void print_wod() {
    	System.out.println("WODname : " +WODname);
    	System.out.println("WOD level : " + WODlevel);
    	for (int i = 0 ; i < movementlist.size(); i++) {
    	System.out.println(movementlist.get(i).getMovementname()+"  " + movementlist.get(i).getWeight()+"kg  " + movementlist.get(i).getMovementnum() +"Reps");
    	}
    	System.out.println("WODtpye : " + WODtype +" (0 : Fortime  1: AMRAP 2: EMON)" );
    	
    }

}



