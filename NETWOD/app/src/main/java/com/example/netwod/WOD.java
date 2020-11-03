package wod;

import java.util.ArrayList;

public class Wod {
	private String name;
	private String level;  //
	private ArrayList<Movement> movement_list = new ArrayList<Movement>();
	private String type;
	private Wod_manager manager = new Wod_manager(this);

public Wod() {
	
	
	
} // ��õ �͵� �����ϱ�
public Wod(String name,int level) {} //
public Wod(String name,String[] equipment) {
	boolean count = true;
	this.name = name;
	this.setWODlevel("������");
	this.setWODtype("ARMAP");
	Data_Movement data = new Data_Movement();
	ArrayList<String> equipment_array = new ArrayList<>();
	ArrayList<String> movement_recommend = manager.stimulation();
	for(String item : equipment) {
		equipment_array.add(item);
	}
	for(int i = 0; i < equipment.length ;i++) {
		movement_recommend = manager.stimulation();
		for(int j = 0 ; j < movement_recommend.size(); j++ ) {
			if(!data.get_equipment(data.get_index(movement_recommend.get(j))).equals(equipment[i])) {count =false;}} // ��õ ���� 1~3��
		if(count) {
			continue;
		}
		count = true;
	}
	this.manager.AMRAP(movement_recommend.toArray(new String[movement_recommend.size()]));
	
}

// ������ ��� �κ�



// �ϴ� 11/3 ���⿡ ���� �׽�Ʈ ������ WOD manager�� �ֱ� ����


public ArrayList<String> getMovement(){
	ArrayList<String> output = new ArrayList<String>();
	for(int i = 0; i < movement_list.size(); i++) {
		output.add(this.movement_list.get(i).get_name());
		
	}
	
	return output;  
}
public ArrayList<String> getEquipment(){
	Data_Movement data = new Data_Movement();
	ArrayList<String> output = new ArrayList<String>();
	for(int i = 0; i < movement_list.size(); i++) {
		String name = data.get_equipment(data.get_index(this.movement_list.get(i).get_name()));
		output.add(name);
		
	}
	
	return output;  
}
public ArrayList<String> getMovementnum(){
	ArrayList<String> output = new ArrayList<String>();
	for(int i = 0; i < movement_list.size(); i++) {
		output.add(Integer.toString(this.movement_list.get(i).get_rep()));
		
	}
	
	return output;  
}
public ArrayList<String> getWeightlist(){
	ArrayList<String> output = new ArrayList<String>();
	for(int i = 0; i < movement_list.size(); i++) {
		output.add(Integer.toString((int)this.movement_list.get(i).get_weight()));
		
	}
	
	return output;  
}





public Wod_manager manage_wod() {
	return this.manager;
}

public ArrayList<Movement> get_movement_Arraylist(){
	return this.movement_list;
}

// ������ �����ϴ� �κк�
public void setWODname(String input) {
	this.name = input;
}
public void setWODtype(String input) {
	this.type = input;
}
public void setWODlevel(String input) {
	this.level = input;
}

public String getWODname() {
	return this.name;
}
public String getWODtype() {
	return this.type;
}
public String getWODlevel() {
	return this.level;
}



public void set_movement_add(Movement input) {
	this.movement_list.add(input);
}
public void set_movement_remove(int index) {
	this.movement_list.remove(index);
}





}