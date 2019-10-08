package com.ww.javatasks;

import java.util.Scanner;



import com.ww.utils.Constants;
import com.ww.utils.ExcellReader;

public class Dictionary {
	
	
	public static void doesFileExist(String path) {
		
		ExcellReader ex=new ExcellReader();
		ex.openConnection(Constants.EXCEL_FILEPATH, "Sheet1");
		
		int rownum=ex.getRowNum();
		int cellnum=ex.getCellNum();
		
		boolean flag=false;
			
		for(int i=0;i<=cellnum-1;i++) {
			
			String header=ex.getCellData(0, i).toString().trim();
							
				if(header.equalsIgnoreCase(path)) {
					flag=true;
					break;
				}
						
				
				}
		
		if(flag) {
			System.out.println(path + " :is exist in our library ");
			
			
			
		}else {
			System.out.println(path +" :does not exist in our library");
		}
		
	
		
		
	}
	
	public static void readFile() {
		
		ExcellReader ex=new ExcellReader();
		ex.openConnection(Constants.EXCEL_FILEPATH, "Sheet1");
		
		int rownum=ex.getRowNum();
		int cellnum=ex.getCellNum();
		
		try {
		
		for(int i=0;i<=cellnum-1;i++) {
			
			for(int y=0;y<=rownum-1;y++) {
							
				System.out.println(ex.getCellData(y, i));
							
			}
			System.out.println("------------------------------------------------");
		}
		
		}catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}	
	
			
	}
	
	
	
	public static void main(String[] args) {
		
		//task1
		
		Scanner sc=new Scanner(System.in);
		
		System.err.println("Please enter your word:");
		
		String text=sc.nextLine();
		
		doesFileExist(text);
		
		
		//task2
		System.out.println("-----------------Print all data from library--------------------");
		readFile();
		
	}
	
	

}
