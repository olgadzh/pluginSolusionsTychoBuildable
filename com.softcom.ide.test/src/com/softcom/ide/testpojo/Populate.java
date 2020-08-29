package com.softcom.ide.testpojo;

public class Populate {
		
	    public static void main(String[] args) {    	
	 
	    // CREATE SOLUTION
	    
	    Solution newS = new Solution();
	    
	    newS.setName("One Solution");


	    // CREATE PROJECT
	    
	    Project newP = new Project();
	    
	    newP.setName("One Project 1");
	    newP.setSolution(newS);
	    
	    // CREATE PROJECT
	    
	    Project newP2 = new Project();
	    
	    newP2.setName("One Project 2");
	    newP2.setSolution(newS);
	    
	    // CREATE PROJECT
	    
	    Project newP3 = new Project();
	    
	    newP3.setName("One Project 3");
	    newP3.setSolution(newS);
	    }
}
