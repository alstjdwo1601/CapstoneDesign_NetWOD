package com.example.netwod;

import java.util.ArrayList;
import java.util.Random;

public class WodType {
	ArrayList<int[]> FORTIME = new ArrayList<int[]>();
	ArrayList<int[]> AMRAP = new ArrayList<int[]>();
	
    // FORTIME
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

	public WodType() {
        // FORTIME
        int[] input = {1,30};
        this._addFORTIME(input);
        input = new int[] {2,10,5};
        this._addFORTIME(input);
        input = new int[] {2,7,5,3};
        this._addFORTIME(input);
        input = new int[] {2,5,5,5};
        this._addFORTIME(input);
        input = new int[] {3,5,3,2};
        this._addFORTIME(input);
        input = new int[] {3,3,3,3};
        this._addFORTIME(input);

        //amrap
        // first = movement kind , 2 ~ n-1 = movement_count , last = time(min)
        input = new int[] {1 , 1, 10};
        this._addAMRAP(input);
        input = new int[] {2 , 1,1, 10};
        this._addAMRAP(input);
        input = new int[] {3 , 1,1,1, 10};
        this._addAMRAP(input);
		
		
		
		
		
	}
	
	
	public int[] getType(String type, ArrayList<Integer> movement) {
		if(type.equals("FORTIME")) {
			return getFortime(movement.size());
		}
		
		if(type.equals("AMRAP")) {
			return getAMRAP(movement.size());
		}
		
		return null;
		
	}
	
	
	
	
	public int[] getFortime(int sizeOfmovement) {
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 0; i < this.FORTIME.size(); i++) {
			if(FORTIME.get(i)[0] == sizeOfmovement) {
				indexList.add(i);
			}
		}
		
		return FORTIME.get(indexList.get(rand.nextInt(indexList.size())));
	}
	
	public int[] getAMRAP(int sizeOfmovement) {
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 0; i < this.AMRAP.size(); i++) {
			if(AMRAP.get(i)[0] == sizeOfmovement) {
				indexList.add(i);
			}
		}
		
		return AMRAP.get(indexList.get(rand.nextInt(indexList.size())));
	}
	
	
	
	
	
    public void _addFORTIME(int[] input) {
        this.FORTIME.add(input);
    }

    public void _addAMRAP(int[] input) {
        this.AMRAP.add(input);
    }

	
	
	
	

}
