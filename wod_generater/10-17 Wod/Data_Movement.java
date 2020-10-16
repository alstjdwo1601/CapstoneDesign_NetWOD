package Wod;

import java.util.ArrayList;
import java.util.Arrays;


public class Data_Movement {
	private ArrayList<String> movement = new ArrayList<String>();
	private ArrayList<String> equipment = new ArrayList<String>();
	private ArrayList<int[]> exercise_area = new ArrayList<int[]>();
	private ArrayList<Integer> stimulation = new ArrayList<Integer>(); // 0 = ü�� , 1 = ��Ÿ��������Ŵ� , 2 = ����
	private ArrayList<Double> score = new ArrayList<Double>();
	private ArrayList<Double> weight = new ArrayList<Double>();
	private ArrayList<Integer> rep = new ArrayList<Integer>();
	private ArrayList<String> equipment_list = new ArrayList<String>();
	
	
	
	// �����͸� �ٷ� �о �ѱ�� ���
	// T�� ���Ŀ� ������ ����� �̺�Ʈ�����ʷ� �ѱ�� �ȴ� (������ ������ F) .
	
	public Data_Movement() {
		Read_movement Data = new Read_movement();
		boolean T = (input_Data_Movement(Data.movement,Data.equipment,Data.exercise_area,Data.stimulate,Data.score,Data.Kg_average,Data.rep));
		
		
		
	} 
	
	
	
	
	// equipment ������ �д� �۾�
	public void input_equipment_list(String[] input) {
		this.equipment_list = new ArrayList<>(Arrays.asList(input));
	}
	
	
	
	// input_Data_Movement  �����͸� �о��� �� �ϳ� �� �ִ� �κ� 
	public boolean input_Data_Movement(String name,String equipment, int[] exercise_area,int stimulation ,double score,double weight,int rep) {
		this.movement.add(name);
		this.equipment.add(equipment);
		this.exercise_area.add(exercise_area);
		this.stimulation.add(stimulation);
		this.score.add(score);
		this.weight.add(weight);
		this.rep.add(rep);
		return true;
	}
	
	
	
	// input_Data_Movement ������ �迭�� �о��� �� �ִ� �κ�
	public boolean input_Data_Movement(String[] name,String[] equipment, ArrayList<int[]> exercise_area,int[] stimulation ,double[] score,double[] weight,int[] rep) {
		
		if(name.length != equipment.length) {
			return false;
		}
		if(name.length != exercise_area.size()) {
			return false;
		}
		if(name.length != stimulation.length) {
			return false;
		}
		if(name.length != score.length) {
			return false;
		}

		
		for(int i = 0 ; i< name.length; i++) {
		input_Data_Movement(name[i], equipment[i], exercise_area.get(i),stimulation[i], score[i],weight[i],rep[i]);
		}
		return true;
		
	}
	
	
	
	
	
	 
	
	
	// ���� 
	public int search_movement_index(String name){
		for (int i = 0 ; i < this.movement.size(); i++) {
			if(this.movement.get(i).equals(name)){
				return i;
			}
		}
		return -1;
	}
	

	
	public String[] get_equipment_list() {
		String[] output = equipment_list.toArray(new String[equipment_list.size()]); 
		return output;

	}
	// �����ʼ�
	public String[] get_exercise_area() {
		String[] output =new String[2];
		return output;

	}
	
	public int get_index(String movement) {
		for(int i = 0 ; i < this.movement.size(); i++) {
			movement.equals(this.movement.get(i));
			return i;
		
		}
		return -1;
		
		
	}
	
	public String[] get_movement() {
		return this.movement.toArray(new String[this.movement.size()]);
	}
	
	public String get_movement(int index) {
		return this.movement.get(index);
	}
	public ArrayList<String> get_movement_ArrayList() {
		return this.movement;
	}
	public String[] get_movement_String() {
		return this.movement.toArray(new String[this.movement.size()]);
	}
	
	public String get_equipment(int index) {
		return this.equipment.get(index);
	}
	public ArrayList<String> get_equipment_ArrayList() {
		return this.equipment;
	}
	public String[] get_equipment_String() {
		return this.equipment.toArray(new String[equipment.size()]);
	}
	
	public ArrayList<String> get_equiment_list_ArrayList() {
		return this.equipment_list;
	}
	
	public String[] get_equiment_list_Array() {
		return this.equipment_list.toArray(new String[this.equipment_list.size()]);
	}
	
	
	public int[] get_exercise_area(int index) {
		return this.exercise_area.get(index);
	}
	
	public int get_stimulation(int index) {
		return this.stimulation.get(index);
	}
	
	public double get_score(int index) {
		return this.score.get(index);
	}
	
	public int get_rep(int index) {
		return this.rep.get(index);
	}
	
	public int get_weight(int index) {
		double cast = (this.weight.get(index));
		int output = (int)cast;
		return output;
	}
	public int get_Data_length() {
		return this.movement.size();
	}
	
	
	//��� �������� ������ ���� ���� �Լ� �� �����صּ� �ٷιٷ� for������ 10�ʸ� ������
	public void output_Data_Movement() {
		
	}
	
	
	
	
}









