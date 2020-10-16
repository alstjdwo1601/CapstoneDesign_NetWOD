package Wod;

import java.util.ArrayList;

public class Wod_Algorithm { 
	private ArrayList<boolean[]> stimulation = new ArrayList<boolean[]>(); // 0 = 체조 , 1 = 메타볼릭컨디셔닝 , 2 = 역도 
	
	public Wod_Algorithm() {}
	public Wod_Algorithm(ArrayList<Wod> wods) {
			set_wods(wods);
		}
		
		

	
	public void set_wods(ArrayList<Wod> wods){
		for(int i = 0 ; i < wods.size(); i++) {
			String[] input = wods.get(i).manage_wod().get_movement_name_string();
			input_stuimulation(output_decision_stimulation_inString(input));
		}
		
	}
		
	
	public void input_stuimulation(boolean[] input){
		this.stimulation.add(input);
	} 
	
	public boolean[] output_stimulation() {
		
		return output_temp();
		
	}
	
	public boolean[] output_decision_stimulation(String[] movement) {
		
		boolean[] output = {false,false,false};
		Data_Movement data = new Data_Movement();
		for(int i = 0; i<movement.length; i++) {
			output[data.search_movement_index(movement[i])] = true;
		}
		return output;
		
		
	}
	
	public boolean[] output_decision_stimulation_inArray(ArrayList<String> movement_arraylist) {
		String[] movement = movement_arraylist.toArray(new String[movement_arraylist.size()]);
		boolean[] output = {false,false,false};
		Data_Movement data = new Data_Movement();
		for(int i = 0; i<movement.length; i++) {
			output[data.search_movement_index(movement[i])] = true;
		}
		return output;
		
		
	}
	public boolean[] output_decision_stimulation_inString(String[] movement) {
		boolean[] output = {false,false,false};
		Data_Movement data = new Data_Movement();
		for(int i = 0; i<movement.length; i++) {
			output[data.search_movement_index(movement[i])] = true;
		}
		return output;
		
		
	}
	
	
	public boolean[] output_temp(){
		boolean[] output = {true,true,true};
		
		if (this.stimulation.size() == 0) {
			return output;
		}
		
		if (this.stimulation.size() >= 1) {
			return recommend(get_stimulation_num((stimulation.get(stimulation.size()-1))));
		}
		return output;
	}
	
	public int get_stimulation_num(boolean[] input){
		int output =0;
		if (input[0])
			output++;
		if (input[1])
			output++;
		if (input[2])
			output++;
		
		return output;
	}
	
	//통계적으로 가장 지금 무얼 해야하는지 선택한다.
	public int get_stimulation_week() {
		int output;
		int[] num = {0,0,0};
		for (int i = 0 ; i < this.stimulation.size(); i++){
			if(this.stimulation.get(i)[0]) {
				if(!this.stimulation.get(i)[1])
					if(!this.stimulation.get(i)[2])
						num[0]++;
			}
			else{
				if(this.stimulation.get(i)[1]) {
					if(!this.stimulation.get(i)[2])
						num[1]++;
				}
				else {
					if(this.stimulation.get(i)[2])
						num[2]++;
				}
					
			}
				
			
		}
		
		
		
		if (num[0] < num[1]) {
			output = 1;
		}
		else {
			output = 0;
		}
		
		if(num[output] <= num[2])
			output = 2;
		
		return output; // 동 순위 일시 역도/체조/메타볼릭 순
	}
	
	
	
	public boolean[] reversal(boolean[] input) {
		for(int i = 0 ; i < 3 ; i++) {
			input[i] = !input[i];
			
		}
		return input;
	}
	
	public boolean[] recommend(int num) {
		boolean[] output = {true,true,true};
		
		if (3 < num) {
			num = 3;
		} 
		
		if (num < 0){
			num = 0;
		}
		
		if (num == 0) {
			return output;}
		if(num == 1) {
			return reversal(output);}
		if(num ==2) {
			 output[get_stimulation_week()] = !output[get_stimulation_week()]; 
			return output;}
		if(num == 3) {
			output[get_stimulation_week()] = !output[get_stimulation_week()];
			return reversal(output);
		}
		return output;
	}
		
	public ArrayList<String> movement_recommend(){
		ArrayList<String> output = new ArrayList<String>();
		Data_Movement data = new Data_Movement();
		boolean[] temp = output_temp();
		for(int i = 0; i < data.get_Data_length(); i++) {
			if(temp[0]){
				if(data.get_stimulation(i)==0) {
					output.add(data.get_movement(i));
				}
			}
			if(temp[1]) {
				if(data.get_stimulation(i)==1) {
					output.add(data.get_movement(i));
				}
			}
			if(temp[2]) {
				if(data.get_stimulation(i)==2) {
					output.add(data.get_movement(i));
				}
			}
		}
		
		
		return output;
	}	
	public ArrayList<String> movement_recommend(ArrayList<Wod> wods){
		ArrayList<String> output = new ArrayList<String>();
		Data_Movement data = new Data_Movement();
		boolean[] temp = output_temp();
		for(int i = 0; i < data.get_Data_length(); i++) {
			if(temp[0]){
				if(data.get_stimulation(i)==0) {
					output.add(data.get_movement(i));
				}
			}
			if(temp[1]) {
				if(data.get_stimulation(i)==1) {
					output.add(data.get_movement(i));
				}
			}
			if(temp[2]) {
				if(data.get_stimulation(i)==2) {
					output.add(data.get_movement(i));
				}
			}
		}
		
		
		return output;
	}	
	
	
	
	
	
	
}
