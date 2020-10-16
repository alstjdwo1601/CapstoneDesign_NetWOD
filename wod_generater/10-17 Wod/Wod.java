package Wod;

import java.util.ArrayList;

public class Wod {
	private String name;
	private int level;  //
	private ArrayList<Movement> movement_list = new ArrayList<Movement>();
	private String type;
	private Wod_manager manager = new Wod_manager(this);

public Wod() {} // 추천 와드 생성하기
public Wod(String name) {} // 몰라 ..
public Wod(double score) {}

// 정보를 얻는 부분


public Wod_manager manage_wod() {
	return this.manager;
}

public String get_name() {
		return this.name;
}
public String get_type() {
	return this.type;
}
public int get_level() {
	return this.level;
}

public ArrayList<Movement> get_movement_Arraylist(){
	return this.movement_list;
}

// 정보를 저장하는 부분분
public void set_name(String input) {
	this.name = input;
}
public void set_type(String input) {
	this.type = input;
}
public void set_level(int input) {
	this.level = input;
}



public void set_movement_add(Movement input) {
	this.movement_list.add(input);
}
public void set_movement_remove(int index) {
	this.movement_list.remove(index);
}





}