package com.example.netwod;

import java.util.ArrayList;
import java.util.Collections;


public class WodManager {
	ArrayList<WOD> wod = new ArrayList<WOD>();
	ArrayList<String> err = new ArrayList<String>();
	
	public WodManager() {
		
	}
	
	
	
	
	
	
	/* WodManager
	 * wod�� �Է� ������ �����ϰų� ���ο� �͵带 �������
	 * 
	 *
	 * ���� �ʿ�
	 * - Arraylist ���� ü���� ���� o
	 * - �αױ�� o
	 * - �� wod�� ������ ä��� �Լ� o
	 *
	 *
	 * Data_Movement
	 * ���� �����͸� Ŭ������ ���� ������ ����
	 * 
	 * ���� �ʿ�
	 * - Ŭ���� �ܺο��� �����ϴ� �Լ� o
	 * - ���� �д� ��� x
	 * 
	 * WodAlgorithm
	 * ��͵带 ������ �˾Ƽ� �´� Wod �ֵ��� 
	 * 
	 * ���� �ʿ�
	 *  
	 *  ����� ������ ���� Wod ���� (1/5)
	 *  ����� ��� o
	 *  ����� ���� x
	 *  ����� ��ŷ x
	 *  ����� ���� x
	 *  
	 *  ����ڰ� �ߴ� wod�� ���� (0/2)
	 *  stimulation x
	 *  area x
	 *  
	 *  +�͵嵥���͸� ���ؼ� �н��ϰ� ��õ(0/2) 
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
