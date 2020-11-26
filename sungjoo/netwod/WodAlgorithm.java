package com.example.netwod;

import java.util.ArrayList;
import java.util.Random;

public class WodAlgorithm {
	private Data_Movement data;
	private WOD wod = new WOD();
	private UserInfo info;
	
	private ArrayList<String> movement = new ArrayList<String>();
	private ArrayList<String> equipment= new ArrayList<String>();
	private ArrayList<String> rep = new ArrayList<String>();
	private ArrayList<String> weight = new ArrayList<String>();
	
	
	
	/*   userdata
	 *   1. equipement o
	 *  	무조건 1순위 
	 *   2. exercise x
	 *   우선 순위 순으로 movement 정렬 
	 *    
	 *   3. stimulation x
	 *   wod 를 통해서 stimulation 을 알아내는 것 (wod 넣으면 stimulation boolean type [3]) o
	 *   stimulation 을 통해서 movement 추출하는 것 (전체에서 , 주어진 list에서  int type[size])
	 *   
	 * 
	 */
	
	
	
	public WodAlgorithm() {
		
		
	}
	
	
	public WodAlgorithm(Data_Movement Data,UserInfo info) {
		this.data = Data;
		this.info = info;
	}
	
	
	
	
	public WodAlgorithm(Data_Movement Data, WOD Wod,UserInfo info) {
		this.wod = Wod;
		this.data = Data;
		this.info = info;
	}
	
	
	public void _addMovement(int index, int Level, int part) {
		
		// level 0 = 100%
		// level 1 = 110%
		// level 2 = 125%
		// level 3 = 150%
		// level 4 = 200%
		movement.add(data.getMovement(index));
		equipment.add(data.getEquipment(index));
		rep.add(_setMovementnum(index,part));
		weight.add(_setWeightlist(index,Level));
		
	}
	
	public String _setMovementnum(int index, int part){
		return numberToString(data.getRep(index)*part);
	}
	
	
	public String _setWeightlist(int index,int level){
		return numberToString(data.getWeight(index));
	}
	
	
	
	
	
	public String numberToString(int number) {
		return Integer.toString(number);
	}
	public String numberToString(double number) {
		return Double.toString(number);
	}
	public double StringToDouble(String string) {
		return Double.parseDouble(string);
	}
	public int StringToInt(String string) {
		return Integer.parseInt(string);
	}
	
	
	
	public void _makeWod(String type,int level) {
		ArrayList<Integer> movement = new ArrayList<Integer>();
		
		// movement 받는 부분
		movement = _seleteMovement();
		//fortime 구현해야하고
		if(type.equals("FORTIME")) {
			_FORTIME(movement);
			wod.setMovement(this.movement);
			wod.setEquipment(this.equipment);
			wod.setMovementnum(this.rep);
			wod.setWeightlist(this.weight);
			
		}
		//AMRAP 구현도 해야하네 
	

		
		
		
		
	}
	
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
	
	
	
	public void _FORTIME(ArrayList<Integer> indexList){
		WodType type = new WodType();
		int[] count = type.getType("FORTIME", indexList);
		
		
		for(int i = 1; i < count.length; i++) {
		for(int mNum = 0; mNum < indexList.size(); mNum++) {
			_addMovement(indexList.get(mNum), 0, count[i]);
		}
		}
		
		
	}
	
	
	
	
	
	public void _AMRAP(ArrayList<Integer> movement) {
		
		
		
	}
	
	
	
	
	
	
	
	
	public ArrayList<Integer> _seleteMovement(){
		
		boolean area = false;
		ArrayList<Integer> movement;
		// area 로 정렬하고
		
		
		// equipment 로 분류하고
		movement = _getEquipementList();
		if(movement.isEmpty()) {return null;}
		// stimulation 으로 분류하고
		movement = _WODstimulation(movement, area);
		if(movement.isEmpty()) {
			return _randomMovement(2,movement);
		}
		
		return movement;
	}
	
	
	public ArrayList<Integer> _randomMovement(int i,ArrayList<Integer> movement){
		ArrayList<Integer> output = new ArrayList<Integer>();
		Random rand = new Random();
		output.add(movement.get(rand.nextInt(movement.size())));
		output.add(movement.get(rand.nextInt(movement.size())));
		
		while(output.get(0) == output.get(1)) {
			output.set(1,movement.get(rand.nextInt(movement.size())));
			
		}
		
		return output;
	}
	
	
	
	// Equipement
	
	
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
	
	
	public ArrayList<Integer> _getEquipementList(ArrayList<Integer> DataList){
		ArrayList<Integer> movements = new ArrayList<Integer>();
		ArrayList<String> list = _getUserEquipementList();
		for(int i = 0; i < DataList.size();i++) {
			if(_ArrayincludeString(data.getEquipment(DataList.get(i)), list)) {
				movements.add(DataList.get(i));
			}
		}
		return movements; 
	}
	
	
	
	
	
	
	
	
	
	// exercise area 
	
	
	public ArrayList<Integer> _sortExerciseArea(){
		ArrayList<Integer> movements = new ArrayList<Integer>();
		return movements;
	}
	
	
	
	
	
	
	
	
	
	
	// stimulation
	/*
	 *  1. wod 를 통해서 stimulation 을 알아내는 것 (wod 넣으면 stimulation boolean type [3])
	 *  2. stimulation 을 통해서 movement 추출하는 것 (전체에서 , 주어진 list에서  int type[size])
	 *  3. 
	 */

	public ArrayList<Integer>_WODstimulation(WOD yesterday,ArrayList<Integer> movementList, boolean sorted) {
		ArrayList<Boolean> stimulation = _stimulationRecommand(yesterday);
		return _stimulationMain(stimulation,movementList,sorted);
	}

	public ArrayList<Integer>_WODstimulation(ArrayList<WOD> wodlist,ArrayList<Integer> movementList, boolean sorted) {
		ArrayList<Boolean> stimulation = _stimulationRecommand(wodlist);
		return _stimulationMain(stimulation,movementList,sorted);
	}

	public ArrayList<Integer>_WODstimulation(ArrayList<Integer> movementList, boolean sorted){
		ArrayList<Boolean> stimulation = _stimulationRecommand();
		return _stimulationMain(stimulation,movementList,sorted);
	}
	
	
	
	
	public ArrayList<Boolean> _getStimulaion(WOD wod){
		// wod 의 movement를 통해서 stimulation을 알아낸다.
		ArrayList<Boolean> stimulation = new ArrayList<Boolean>();
		ArrayList<String> movement = wod.getMovement();
		ArrayList<Integer> movementIndex = new ArrayList<Integer>();
		
		for(int i = 0; i < 3; i++) {
			stimulation.add(false);
		}
		
		for(int i = 0; i < movement.size(); i++) {
			movementIndex.add(data.getArrayIndex(movement.get(i)));
		}
		
		for(int i = 0; i < movementIndex.size(); i++) {
			int index = movementIndex.get(i);
			
			if(data.getStimulation(index) == 0) {
				stimulation.set(0, true);
			}

			else if(data.getStimulation(index) == 1) {
				stimulation.set(1, true);
			}

			else if(data.getStimulation(index) == 2) {
				stimulation.set(2, true);
			}
		}
		return stimulation;
	}
	
	
	public ArrayList<Integer> _stimulationBooltoInt(ArrayList<Boolean> input){
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++) {
			output.add(0);
		}
		for(int i = 0; i < 3; i++) {
			if(input.get(i)) {
				output.set(i, 1);
			}
		}
		return output;
		
	} 
	
	// WOD.. 전날 했던 wod 아니면 user 추천
	public ArrayList<Boolean> _stimulationRecommand(){
		Random rand = new Random();
		ArrayList<Boolean> output = new ArrayList<Boolean>();
		int SettingValue = rand.nextInt(100);
		if(SettingValue < 60) {
			for(int i = 0; i < 3; i++) {
			output.add(true);}
			
		}
		else if(SettingValue <80) {
			for(int i = 0; i < 3; i++) {
			output.add(true);}
			output.set(rand.nextInt(3), false);
			
		}
		else {
			for(int i = 0; i < 3; i++) {
			output.add(false);}
			output.set(rand.nextInt(3), true);
			
			
		}
		
		return output;
		
		
	}
	
	
	
	
	
	
	
	public ArrayList<Boolean> _stimulationRecommand(WOD yesterday){
		if(yesterday == null) {
			return null;
		}
		
		Random rand = new Random();
		
		ArrayList<Boolean> output = _getStimulaion(yesterday);
		if(output.get(0))
			if(output.get(1))
				if(output.get(2)) {
					output.set(rand.nextInt(output.size()), false);
					return output;
				}
		for(int i = 0; i < output.size(); i++) {
			if(!output.get(i)) {
				output.set(i, true);
				return output;
			}
			
		}
		
		return output;
		
	}
	
	
	
	
	
	
	public ArrayList<Boolean> _stimulationRecommand(ArrayList<WOD> wodlist){
		ArrayList<Boolean> output = new ArrayList<Boolean>();
		ArrayList<Integer> SumStimulation = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++) {
			SumStimulation.add(0);
		}
		
		
		
		
		for(int i = 0; i < wodlist.size(); i++) {
			ArrayList<Boolean> stimulation_bool = _getStimulaion(wodlist.get(i));
			ArrayList<Integer> stimulation_int = _stimulationBooltoInt(stimulation_bool);			
			
			for(int j = 0; j < 3; j++) {
				stimulation_bool.add(false);
				int temp = SumStimulation.get(j) + stimulation_int.get(j);
				SumStimulation.set(j, temp);
			}
		}
			
			
			
		// 비교 sum	
		if(SumStimulation.get(0) > SumStimulation.get(1)) {
			if(SumStimulation.get(1) > SumStimulation.get(2)){
				output.set(2, true);
				return output;
			}
			else if(SumStimulation.get(1) == SumStimulation.get(2)) {
				output.set(1, true);
				output.set(2, true);
				return output;
			}
			else {
				output.set(1, true);
				return output;
				
			}
			
		}
		else if(SumStimulation.get(0) == SumStimulation.get(1)) {
			if(SumStimulation.get(1) > SumStimulation.get(2)){
				output.set(2, true);
				return output;
			}
			else if(SumStimulation.get(1) == SumStimulation.get(2)) {
				
				output.set(0, true);
				output.set(1, true);
				output.set(2, true);
				
				return output;
			}
			else {
				output.set(0, true);
				output.set(1, true);
				return output;
				
			}			
		}
		else{
			if(SumStimulation.get(0) > SumStimulation.get(2)){
				output.set(2, true);
				return output;
			}
			else if(SumStimulation.get(0) == SumStimulation.get(2)) {
				
				output.set(0, true);
				output.set(2, true);
				
				return output;
			}
			else {
				output.set(0, true);
				return output;
				
			}
		}
	}
	
	
	
	public ArrayList<Integer> _stimulation(ArrayList<Boolean> stimulation){
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i = 0; i < data.getArraySize(); i++) {
			if(stimulation.get(data.getStimulation(i))) {
				output.add(i);
			}
		}
		return output;
		
	}
	
	
	
	
	public ArrayList<Integer> _stimulation(ArrayList<Boolean> stimulation,ArrayList<Integer> movementList){
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i = 0; i < movementList.size(); i++) {
			if(stimulation.get(data.getStimulation(movementList.get(i)))) {
				output.add(movementList.get(i));				
			}
		}
		return output;
	}
	
	public ArrayList<Integer> _stimulationMain(ArrayList<Boolean> stimultaion, ArrayList<Integer> movementList,boolean sorted){
		if(sorted) { // exercise area  적용된 movement list

			ArrayList<Integer> output = new ArrayList<Integer>();
			ArrayList<Integer> SubList_0 =_stimulationSub(0,movementList);
			ArrayList<Integer> SubList_1 =_stimulationSub(1,movementList);
			ArrayList<Integer> SubList_2 =_stimulationSub(2,movementList);
			output.add(_MovementSelectUpper(SubList_0));
			output.add(_MovementSelectUpper(SubList_1));
			output.add(_MovementSelectUpper(SubList_2));
			for(int i = output.size()-1; i >= 0 ; i--) {
				if(output.get(i) == -1) {
					output.remove(i);
				}
			}
			return output;

		}
		
		else { //  exercise area 적용 안되었을 때

			ArrayList<Integer> output = new ArrayList<Integer>();
			ArrayList<Integer> SubList_0 =_stimulationSub(0,movementList);
			ArrayList<Integer> SubList_1 =_stimulationSub(1,movementList);
			ArrayList<Integer> SubList_2 =_stimulationSub(2,movementList);
			output.add(_MovementSelectRandom(SubList_0));
			output.add(_MovementSelectRandom(SubList_1));
			output.add(_MovementSelectRandom(SubList_2));
			
			for(int i = output.size()-1; i >= 0 ; i--) {
				if(output.get(i) == -1) {
					output.remove(i);
				}
			}
			return output;
			}
	}
	
	
	public ArrayList<Integer> _stimulationMain(ArrayList<Boolean> stimultaion){
		ArrayList<Integer> output = new ArrayList<Integer>();
		ArrayList<Integer> SubList_0 =_stimulationSub(0);
		ArrayList<Integer> SubList_1 =_stimulationSub(1);
		ArrayList<Integer> SubList_2 =_stimulationSub(2);
		output.add(_MovementSelectRandom(SubList_0));
		output.add(_MovementSelectRandom(SubList_1));
		output.add(_MovementSelectRandom(SubList_2));
		
		for(int i = output.size()-1; i >= 0 ; i--) {
			if(output.get(i) == -1) {
				output.remove(i);
			}
		}
		return output;
	}
	
	
	public ArrayList<Integer> _stimulationSub(int stimulation){
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i = 0; i < data.getArraySize(); i++) {
			if(data.getStimulation(i)==stimulation) {
				output.add(i);
			}
		}
		return output;
	}
	
	
	
	
	
	
	public ArrayList<Integer> _stimulationSub(int stimulation, ArrayList<Integer> movementList){
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int i = 0; i < movementList.size(); i++) {
			if(data.getStimulation(movementList.get(i))==stimulation) {
				output.add(movementList.get(i));
			}
		}
		return output;
	}
	
// stimulation end	
	
	
	
	
	
	
	
	
	
	
// 내부 function	
	
	
	public int _MovementSelectRandom(ArrayList<Integer> movementList) {
		if(movementList.isEmpty()) {
			return -1;
			
		}
		Random rand = new Random();
		int output = rand.nextInt(movementList.size());
		return movementList.get(output);
	}
	
	
	
	
	public int _MovementSelectUpper(ArrayList<Integer> movementList) {
		if(movementList.isEmpty()) {
			return -1;
		}
		return movementList.get(0);
	}
	
	
	
	public WOD getWod() {
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


