package wod;

import java.util.ArrayList;
import java.util.Random;

public class Data_Wod {
	private ArrayList<int[]> fortime = new ArrayList<int[]>();
	private ArrayList<int[]> AMRAP = new ArrayList<int[]>();
	// fortime
	// 형식 맨 앞 운동의 갯수 , 반복할 횟수
	// 2 21 15 9  45
	// -> 21 21 15 15 9 9 의 비율
	// 1 -> 30
	// 2 -> 15  * 2
	// 3 -> 10  * 3
	
	
	// 1 30    30
	// 2 10 : 5
	// 2 21 : 15 : 9 
	// 2 5 : 5 : 5 
	// 3 5 : 3 : 2    
	// 3 3 : 3 : 3
	
	
	// AMRAP 
	
	public Data_Wod() {
		// fortime
		int[] input = {1,30};
		this.add_fortime(input);
		input = new int[] {2,10,5};
		this.add_fortime(input);
		input = new int[] {2,7,5,3};
		this.add_fortime(input);
		input = new int[] {2,5,5,5};
		this.add_fortime(input);
		input = new int[] {3,5,3,2};
		this.add_fortime(input);
		input = new int[] {3,3,3,3};
		this.add_fortime(input);
		
		//amrap
		// first = movement kind , 2 ~ n-1 = movement_count , last = time(min)
		input = new int[] {1 , 1, 10};
		this.add_AMRAP(input);
		input = new int[] {2 , 1,1, 10};
		this.add_AMRAP(input);
		input = new int[] {3 , 1,1,1, 10};
		this.add_AMRAP(input);
		}
	
// 추후수정
	public int[] Data_type(String input,int movement_num){
		ArrayList<Integer> save = new ArrayList<Integer>();
		Random rand = new Random();
		if(input.equals("fortime")) {
			for(int i = 0 ; i < fortime.size(); i++) {
				if(fortime.get(i)[0] == movement_num ) {
					save.add(i);
				}
			}
			return this.fortime.get(save.get(rand.nextInt(save.size())));
			
			
		}
		
		
		
		if(input.equals("AMRAP")) {
			for(int i = 0; i < AMRAP.size(); i++) {
				if(AMRAP.get(i)[0] == movement_num) {
					save.add(i);
				}
				
			}
			return this.AMRAP.get(save.get(rand.nextInt(save.size())));
		}
		
		return null;
		
	}
	public void add_fortime(int[] input) {
		this.fortime.add(input);
	}
	
	public void add_AMRAP(int[] input) {
		this.AMRAP.add(input);
	}
	
	
	
	
}


