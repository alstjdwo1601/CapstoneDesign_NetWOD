package com.example.netwod;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WOD wod = new WOD();
		main ma = new main();
		UserInfo info = new UserInfo();
		info.setBarbell(true);
		info.setBody(true);
		info.setBox(true);
		info.setDumbbell(true);
		info.setJumprope(true);
		info.setKettlebell(true);
		info.setPullUpBar(true);
		Data_Movement data = new Data_Movement();
		ma.ExcelReader4(data);
		WodManager manager = new WodManager(data ,info);
		WodAlgorithm al= new WodAlgorithm(data,info);
		wod = manager.makeWod();
		
		
		
		System.out.println(wod.getMovement());
		System.out.println(wod.getEquipment());
		System.out.println(wod.getMovementnum());
		System.out.println(wod.getWeightlist());
		
		
		
		
	}

}
