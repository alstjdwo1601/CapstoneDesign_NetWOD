package com.example.netwod;
import java.util.ArrayList;

public class Data_Movement {
    private ArrayList<String> movement = new ArrayList<String>();
    private ArrayList<String> equipment = new ArrayList<String>();
    private ArrayList<int[]> exercise = new ArrayList<int[]>();
    private ArrayList<Integer> stimulation = new ArrayList<Integer>(); // 0 = 체조 , 1 = 메타볼릭컨디셔닝 , 2 = 역도
    private ArrayList<Double> score = new ArrayList<Double>();
    private ArrayList<Double> weight = new ArrayList<Double>();
    private ArrayList<Integer> rep = new ArrayList<Integer>();
    private int ArraySize = movement.size();
    
    
    public Data_Movement(){
    	
    }
    
    public int getArraySize(){
    	setArraySize();
    	return this.ArraySize;
    }
    
    public int getArrayIndex(String movementName) {
    	setArraySize();
    	for(int i = 0; i < ArraySize; i++) {
    		if(movement.get(i).equals(movementName)) {
    			return i;
    		}	
    	}
    	return -1;
    }
    
    public ArrayList<String> getMovement() {
    	return movement;
    }
    public ArrayList<String> getEquipment() {
    	return equipment;
    }
    public ArrayList<int[]> getExercise() {
    	return exercise;
    }
    public ArrayList<Integer> getStimulation() {
    	return stimulation;
    }
    public ArrayList<Double> getScore() {
    	return score;
    }
    public ArrayList<Double> getWeight() {
    	return weight;
    }
    public ArrayList<Integer> getRep() {
    	return rep;
    }
    public String getMovement(int index) {
    	if(rangeArray(index, ArraySize)) {
    		return movement.get(index);
    	}
    	else {
    		return null;
    	}
    }
    public String getEquipment(int index) {
    	if(rangeArray(index, ArraySize)) {
    		return equipment.get(index);
    	}
    	else {
    		return null;
    	}
    }
    public int[] getExercise(int index) {
    	if(rangeArray(index, ArraySize)) {
    		return exercise.get(index);
    	}
    	else {
    		return null;
    	}
    }
    public int getStimulation(int index) {
    	if(rangeArray(index, ArraySize)) {
    		return stimulation.get(index);
    	}
    	else {
    		return -1;
    	}
    }
    public double getScore(int index) {
    	if(rangeArray(index, ArraySize)) {
    		return score.get(index);
    	}
    	else {
    		return -1;
    	}
    }
    public double getWeight(int index) {
    	if(rangeArray(index, ArraySize)) {
    		return weight.get(index);
    	}
    	else {
    		return -1;
    	}
    }
    public int getRep(int index) {
    	if(rangeArray(index, ArraySize)) {
    		return rep.get(index);
    	}
    	else {
    		return -1;
    	}
    }
    
    
    
    
    
    
    
    public boolean rangeArray(int index,int max) {
    	if(index > max) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    public boolean rangeArray(int index,int min,int max) {
    	if((index < max )&&(index >= min)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void setArraySize() {
    	ArraySize = movement.size();
    }
    
}