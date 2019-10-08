package com.ww.javatasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GetSmallestFromList {
	
	
	public static Integer getSmallestNum(List<Integer>list) {
		
		Collections.sort(list);
		return list.get(0);
		
	}
	
	//Due to limited time frame to finish task i use Collections.sort
	
	public static void main(String[] args) {
		
		List<Integer>numList = new ArrayList<Integer>();
		Random r=new Random();
		
		for(int i=0;i<500;i++) {
			numList.add(r.nextInt());
			}
		
		
		System.out.println(getSmallestNum(numList));
		
	}
	
	
	

}
