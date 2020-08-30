package com.softcom.ide.testpojo;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;


public class PopulateSolutions {
		
	    public static Map<Integer, Solution> populateSolutions() {  
	    	
	    Map<Integer, Solution> solutions = new TreeMap<>();
	 
	    // CREATE SOLUTION
	    
	    Solution newS1 = new Solution();
	    
	    newS1.setName("One Solution");
	    newS1.setId(1);
	    solutions.put(newS1.getId(),newS1);
	    
	    Solution newS2 = new Solution();
	    
	    newS2.setName("Second Solution");
	    newS2.setId(2);
	    solutions.put(newS2.getId(),newS2);


	    // CREATE PROJECT
	    
	    Project newP = new Project();
	    
	    newP.setName("One Project 1");
	    newP.setSolution(newS1);
	    
	    // CREATE PROJECT
	    
	    Project newP2 = new Project();
	    
	    newP2.setName("One Project 2");
	    newP2.setSolution(newS1);
	    
	    // CREATE PROJECT
	    
	    Project newP3 = new Project();
	    
	    newP3.setName("One Project 3");
	    newP3.setSolution(newS1);
	    
	    System.out.println("Model is populated");
		return solutions;
		
	    }	    
}
