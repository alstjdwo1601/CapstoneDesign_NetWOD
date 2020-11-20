package com.example.netwod;

import java.util.ArrayList;

public class WodAlgorithm {
	private Data_Movement data;
	private WOD wod;
	private UserInfo info;
	
	
	public WodAlgorithm() {
		
		
	}
	
	public WodAlgorithm(Data_Movement Data, WOD Wod,UserInfo info) {
		this.wod = Wod;
		this.data = Data;
		this.info = info;
	}
	
	public ArrayList<String> _getUserEquipementList() {
		ArrayList<String> list =  new ArrayList<String>();
		if(info.isBarbell()) {
			list.add("Barbell");
		}
		if(info.isBody()) {
			list.add("Body");
		}
		if(info.isBox()) {
			list.add("Box");
		}
		if(info.isDumbbell()) {
			list.add("Dumbbell");
		}
		if(info.isJumprope()) {
			list.add("Jumprope");
		}
		if(info.isKettlebell()) {
			list.add("Kettlebell");
		}
		if(info.isPullUpBar()) {
			list.add("PullUpBar");
		}
		if(info.isWallBall()) {
			list.add("WallBall");
		}
		return list;		
	}
	
	
	
	
	public ArrayList<Integer> _getEquipementList(){
		ArrayList<Integer> movements = new ArrayList<Integer>();
		ArrayList<String> list = _getUserEquipementList();
		for(int i = 0; i < data.getArraySize();i++) {
			if(_ArrayincludeString(data.getEquipment(i), list)) {
				movements.add(i);
			}
		}
		return movements; 
	}
	
	
	
	
	
	
	public WOD returnWod() {
		return this.wod;
	}
	
	
	
	
	
	public boolean _ArrayincludeString(String string,ArrayList<String> list) {
		if(list.size() == 0) {
			return false;
		}
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(string)){
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
}


