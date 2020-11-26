package com.example.netwod;

import java.util.ArrayList;
import java.util.Collections;


public class WodManager {
	ArrayList<WOD> wodList = new ArrayList<WOD>();
	ArrayList<String> err = new ArrayList<String>();
	Data_Movement data;
	UserInfo info;
	public WodManager() {
		
	}
	
	
	public WodManager(Data_Movement _data,UserInfo _info) {
		data=_data;
		info=_info;
	}
	
	
	
	
	
	
	/* WodManager
	 * wodList�� �Է� ������ �����ϰų� ���ο� �͵带 �������
	 * 
	 *
	 * ���� �ʿ�
	 * - Arraylist ���� ü���� ���� o
	 * - �αױ�� o
	 * - �� wodList�� ������ ä��� �Լ� o
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
	 *  ����ڰ� �ߴ� wodList�� ���� (1/2)  - ����
	 *  stimulation o
	 *  area x
	 *  
	 *  +�͵嵥���͸� ���ؼ� �н��ϰ� ��õ(0/0) // ����
	 *	//�͵� �����Ͱ� ���ϸ��� ���� �׷���
	 *  data collection x
	 *  lerning tool x
	 *  
	 *  WodLearning
	 *  
	 *  11/20
	 *  
	 */
	
	
	public WOD makeWod(WOD wod) {
		WodAlgorithm algorithm = new WodAlgorithm(data,info);
		algorithm._makeWod("FORTIME", 0);
		return algorithm.getWod();
	}
	
	public WOD makeWod() {
		WodAlgorithm algorithm = new WodAlgorithm(data,info);
		algorithm._makeWod("FORTIME", 0);
		return algorithm.getWod();
	}
	
	
	
	public ArrayList<WOD> _getWod(){
		return wodList;
	}
	
	
	public WOD _getWod(int index) {
	
		if(rangeArray(index,wodList.size())) {
			return wodList.get(index);}
		else {
			err.add("getWod/ wodList / out of index ");
			return null;}
	}
	
	
	public int _getWodSize() {
		return this.wodList.size();
	}
	
	
	
	
	public boolean _addWod(WOD input) {
		if(input != null) {
			this.wodList.add(input);
			return true;
		}
		else {
			err.add("addWod/ wodList / input is null ");
			return false;
		}
		
	}
	
	




	public void _addWod(ArrayList<WOD> inputs){
		for(int i = 0; i < inputs.size(); i++){
				this._addWod(inputs.get(i));}
		
	}
	
	
	
	
	public boolean _delWod(int index) {
		if(rangeArray(index,wodList.size())) {
			wodList.remove(index);
			return true;
		}
		else {
			err.add("delWod/ wodList / out of size ");
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
		if(rangeArray(index,wodList.size())){
			wodList.remove(index);
			wodList.add(index,input);
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
