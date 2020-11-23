package com.example.netwod;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class main {
	public void ExcelReader4(Data_Movement data) {
		File fname = new File("movement_data.xls");
		//file=new File(sdCardPath+"/Download/netwodtemplate.xls" );
		try{
			Workbook wb = Workbook.getWorkbook(new File("movement_data.xls"));  //test ¿ë
			//Workbook wb = Workbook.getWorkbook(new File(sdCardPath+"/Download/netwodtemplate.xls"));  //test ¿ë
			Sheet s = wb.getSheet(0); 
			int i = 5;
			while(true){
				try{
					Cell cmovement= s.getCell(0,i);
 					Cell cequipment = s.getCell(1, i);
					//Cell cexercise_area_double = s.getCell(2, i);
					Cell cstimulate = s.getCell(3, i);
					Cell cscore = s.getCell(4, i);
					Cell crep = s.getCell(5, i);
					Cell cweight = s.getCell(6, i);
				/*	Cell cexercise[] = {s.getCell(7,i),
							s.getCell(8,i),
							s.getCell(9,i),
							s.getCell(10,i),
							s.getCell(11,i),
							s.getCell(12,i),
							s.getCell(13,i),
							s.getCell(14,i),};*/
					int[] exercise = new int[8];
					for(int count = 0; count < 8; count++ ) {
 					Cell cexercise = s.getCell(7+count,i);
					String S = cexercise.getContents();
					exercise[count] = Integer.parseInt(S);

					
				}
		
					data.getMovement().add(cmovement.getContents());
					data.getEquipment().add(cequipment.getContents());
					data.getExercise().add(exercise);
					data.getStimulation().add(Integer.parseInt(cstimulate.getContents()));
					data.getScore().add(Double.parseDouble(cscore.getContents()));
					data.getRep().add(Integer.parseInt(crep.getContents()));
					data.getWeight().add(Double.parseDouble(cweight.getContents()));

					i++;
					
				} catch(Exception e){
					break;
				}	
			}

			
 			wb.close();
		}catch(Exception e){
			System.out.println("Err : " + e.getMessage());
		}
	}
}
