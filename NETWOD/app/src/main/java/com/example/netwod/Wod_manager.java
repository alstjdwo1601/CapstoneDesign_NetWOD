package wod;

import java.util.ArrayList;

public class Wod_manager{
	private Wod wod;
	private int basic_time = 0;
	
	
	//수정 할 wod 를 받는 부분
	public Wod_manager() {}
	
	public Wod_manager(Wod input) {
		this.wod =input;
//		fortime();
	}
	
	
	
	// wod movement의 수정 name,rep,kg 수정임
	
	
	
	public String[] get_all_movement_list() {
		Data_Movement data = new Data_Movement();
		return data.get_movement();
	}
	public void set_movement_rep(int index,int input) {
		wod.get_movement_Arraylist().get(index).set_name(input);
	}
	
	public void set_movement_weight(int index,int input) {
		wod.get_movement_Arraylist().get(index).set_weight(input);
	}
	
	public void set_movement_name(int index,int input) {
		wod.get_movement_Arraylist().get(index).set_name(input);
		
	}
	
	// get 함수를 만들자. movement의 이름만 출력 등등
	
	
	public  String[] get_movement_name_string() {
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 0 ;i<wod.get_movement_Arraylist().size(); i++) {
			output.add(wod.get_movement_Arraylist().get(i).get_name());
		}
		return output.toArray(new String[output.size()]);
	}
	
	public  ArrayList<String> get_movement_name_ArrayList() {
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 0 ;i<wod.get_movement_Arraylist().size(); i++) {
			output.add(wod.get_movement_Arraylist().get(i).get_name());
		}
		return output;
	}
	
	public String get_movement_name(int index) {
		return wod.get_movement_Arraylist().get(index).get_name();
	}
	
	public int get_movement_index(String input) {
		Data_Movement data = new Data_Movement();
		return data.get_index(input);
		
	}
	
	///////////////////////////////////////////////////////////////////////
	// 1차 분류 기구 유무
	public ArrayList<String> equipment(ArrayList<String> equipment){
		ArrayList<String> output = new ArrayList<String>();
		Data_Movement data = new Data_Movement();
		for(int i = 0 ; i < data.get_equipment_String().length; i++) {
			for(int j = 0; j < equipment.size(); j++) {
				if(data.get_equipment_String()[i].equals(equipment.get(j))) {
					output.add(data.get_movement(i));
				}
			}
		}
		
		return output;
	}
	
	// 2차 분류 자극부위 / 오늘 할 운동 종류
	
	
	
	// 오늘 할 운동 종류
	public ArrayList<String> stimulation(){
		Wod_Algorithm algorithm = new Wod_Algorithm();
		ArrayList<String> output = new ArrayList<String>();
		return algorithm.movement_recommend();
	}
	public ArrayList<String> stimulation(ArrayList<Wod> wod){
		ArrayList<String> output = new ArrayList<String>();
		Wod_Algorithm algorithm = new Wod_Algorithm(wod);
		algorithm.get_stimulation_week();
		return output;
		
	}
	
	
	
	
	
	// 추천 movement로 생성
	
	
	
	
	
	
	// algorithm fortime 생성 , {movement의 개수 , 각 rep을 반복} 
	public void fortime(String[] movements) {
		Data_Wod wod_data = new Data_Wod();
		Data_Movement movement_data = new Data_Movement();
		int[] algorithm = wod_data.Data_type("fortime", movements.length);
		for(int j =0 ; j < algorithm.length -1; j++) {
			for(int i = 0; i < algorithm[0]; i++) {
				int index = movement_data.get_index(movements[i]);
				Movement movement = new Movement(movements[i],movement_data.get_rep(index)*algorithm[i+1],movement_data.get_weight(index),movement_data.get_score(index));
				this.wod.set_movement_add(movement);
			}
		}
	}
		
		
	// AMRAP 생성 {movement의 개수 , 각 rep , time}  time 값은 wod.manager.get_time()	
	public void AMRAP(String[] movements) {
		Data_Wod wod_data = new Data_Wod();
		Data_Movement movement_data = new Data_Movement();
		int[] algorithm = wod_data.Data_type("AMRAP", movements.length);
		for(int i = 0 ; i < algorithm[0]; i++ ) {
			int index = movement_data.get_index(movements[i]);
			Movement movement = new Movement(movements[i],movement_data.get_rep(index)*algorithm[i+1],movement_data.get_weight(index),movement_data.get_score(index));
			this.wod.set_movement_add(movement);
		}
		this.basic_time = algorithm[algorithm.length-1];
	}
	
	public int get_time() {
		return basic_time; // AMRAP 시 시간을 알려줌
	}
	
	// wod에서 필요한 것..?
	// 추천 부위 {1-10} x
	// 추천 분류 {true , ture , ture} o
	// 1 이전 wod 의 movement  1. wod가 들어온다  2.movement 들을 분류한다. 3.그걸 쓸꺼다 o 
	// 3.1 Wod algorithm 으로 보내서 오늘 할껄 찾아본다. o
	// 3.2 Wod learning 으로 보내서 오늘 할 movement 추천을 받는다. x
	// Wod 생성은 어떻게? fortime 형식이랑 암랩 emom도 있네 -> wod_data에 형식 넣어서 받자.
	// 2 사용자의 장비
	// movement의 수정 부분 안했음
	// movement 출력하는 부분
	// 
	
	
	// 완료된것 movement를 제외한 모든 부분 wod
	
	
	
	
	public boolean range(int min , int input, int max) {
		if (input <= max) {
			if(input >= min ) {
				return true;
			}
			else
				return false;
			
		}
		else
			return false;
		
	}


}
