package com.example.netwod;

import java.util.ArrayList;
import java.util.Collections;


public class WodManager {
	ArrayList<WOD> wod = new ArrayList<WOD>();
	ArrayList<String> err = new ArrayList<String>();
	
	public WodManager() {
		
	}
	
	
	
	
	
	
	/* WodManager
	 * wod를 입력 받으면 저장하거나 새로운 와드를 만들어줌
	 * 
	 *
	 * 구현 필요
	 * - Arraylist 으로 체계적 관리 o
	 * - 로그기능 o
	 * - 빈 wod를 받으면 채우는 함수 o
	 *
	 *
	 * Data_Movement
	 * 엑셀 데이터를 클래스의 내의 변수로 저장
	 * 
	 * 구현 필요
	 * - 클래스 외부에서 접근하는 함수 o
	 * - 엑셀 읽는 기능 x
	 * 
	 * WodAlgorithm
	 * 빈와드를 넣으면 알아서 맞는 Wod 넣도록 
	 * 
	 * 구현 필요
	 *  
	 *  사용자 정보에 따른 Wod 생성 (1/5)
	 *  사용자 장비 o
	 *  사용자 점수 x
	 *  사용자 랭킹 x
	 *  사용자 레벨 x
	 *  
	 *  사용자가 했던 wod에 따라서 (0/2)
	 *  stimulation x
	 *  area x
	 *  
	 *  +와드데이터를 통해서 학습하고 추천(0/2) 
	 *  data collection x
	 *  lerning tool x
	 *  
	 *  WodLearning
	 *  
	 *  
	 */
	
	
	public WOD makeWod(WOD wod) {
		
		return wod;
	}
	
	
	
	
	public ArrayList<WOD> _getWod(){
		return wod;
	}
	
	
	public WOD _getWod(int index) {
	
		if(rangeArray(index,wod.size())) {
			return wod.get(index);}
		else {
			err.add("getWod/ wod / out of index ");
			return null;}
	}
	
	
	public int _getWodSize() {
		return this.wod.size();
	}
	
	
	
	
	public boolean _addWod(WOD input) {
		if(input != null) {
			this.wod.add(input);
			return true;
		}
		else {
			err.add("addWod/ wod / input is null ");
			return false;
		}
		
	}
	
	




	public void _addWod(ArrayList<WOD> inputs){
		for(int i = 0; i < inputs.size(); i++){
				this._addWod(inputs.get(i));}
		
	}
	
	
	
	
	public boolean _delWod(int index) {
		if(rangeArray(index,wod.size())) {
			wod.remove(index);
			return true;
		}
		else {
			err.add("delWod/ wod / out of size ");
			return false;
		}
	}
	
	public void _delWod(ArrayList<Integer> indexs) {
		Collections.sort(indexs,Collections.reverseOrder());
		for(int i =0 ; i < indexs.size(); i++) {
			_delWod(indexs.get(i));
		}
		
		
	}
	
	
	
	public boolean _setWod(int index,WOD input) {
		if(rangeArray(index,wod.size())){
			wod.remove(index);
			wod.add(index,input);
			return true;
		}
		else {
			err.add("setWod / index out of range");
			return false;
		}
	}
	
	
	
	
	
	public ArrayList<String> MgetErr(){
		return err;
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
	
}
