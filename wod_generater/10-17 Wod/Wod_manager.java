package Wod;

import java.util.ArrayList;

public class Wod_manager{
	private Wod wod;
	
	
	//���� �� wod �� �޴� �κ�
	public Wod_manager(Wod input) {
		this.wod =input;	
	}
	
	
	
	// wod movement�� ���� name,rep,kg ������
	
	
	
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
	
	// get �Լ��� ������. movement�� �̸��� ��� ���
	
	
	public  String[] get_movement_name_string() {
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 0 ;i<wod.get_movement_Arraylist().size(); i++) {
			output.add(wod.get_movement_Arraylist().get(i).output_name());
		}
		return output.toArray(new String[output.size()]);
	}
	
	public  ArrayList<String> get_movement_name_ArrayList() {
		ArrayList<String> output = new ArrayList<String>();
		for(int i = 0 ;i<wod.get_movement_Arraylist().size(); i++) {
			output.add(wod.get_movement_Arraylist().get(i).output_name());
		}
		return output;
	}
	
	public String get_movement_name(int index) {
		return wod.get_movement_Arraylist().get(index).output_name();
	}
	
	public int get_movement_index(String input) {
		Data_Movement data = new Data_Movement();
		return data.get_index(input);
		
	}
	
	///////////////////////////////////////////////////////////////////////
	// 1�� �з� �ⱸ ����
	public ArrayList<String> equipment_remove(ArrayList<String> equipment){
		ArrayList<String> output = new ArrayList<String>();
		Data_Movement data = new Data_Movement();
		for(int i = 0 ; i < data.get_Data_length(); i++) {
			for(int j = 0; j < equipment.size(); j++) {
				if(!data.get_equiment_list_ArrayList().get(i).equals(equipment)) {
					output.add(data.get_movement(i));
				}
			}
		}
		
		return output;
	}
	
	// 2�� �з� �ڱغ��� / ���� �� � ����
	
	
	
	// ���� �� � ����
	public ArrayList<String> stimulation(){
		Wod_Algorithm algorithm = new Wod_Algorithm();
		ArrayList<String> output = new ArrayList<String>();
		algorithm.get_stimulation_week();
		
		
		
		return output;
	}
	public ArrayList<String> stimulation(ArrayList<Wod> wod){
		ArrayList<String> output = new ArrayList<String>();
		Wod_Algorithm algorithm = new Wod_Algorithm(wod);
		algorithm.get_stimulation_week();
		return output;
		
	}
	
	
	
	
	
	// ��õ movement�� ����
	
	
	
	public void fortime() {}
	public void amrep() {}
	
	
	// wod���� �ʿ��� ��..?
	// ��õ ���� {1-10} x
	// ��õ �з� {true , ture , ture} o
	// 1 ���� wod �� movement  1. wod�� ���´�  2.movement ���� �з��Ѵ�. 3.�װ� ������ o 
	// 3.1 Wod algorithm ���� ������ ���� �Ҳ� ã�ƺ���. o
	// 3.2 Wod learning ���� ������ ���� �� movement ��õ�� �޴´�. x
	// Wod ������ ���? fortime �����̶� �Ϸ� emom�� �ֳ� -> wod_data�� ���� �־ ����.
	// 2 ������� ���
	// movement�� ���� �κ� ������
	// movement ����ϴ� �κ�
	// 
	
	
	// �Ϸ�Ȱ� movement�� ������ ��� �κ� wod
	
	
	
	
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
