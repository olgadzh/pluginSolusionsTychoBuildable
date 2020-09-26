package hibernate.crud.operations;

import hibernate.crud.operations.Solution;

import java.util.List;
import java.util.Map;

import hibernate.crud.operations.RollupDaoSolution;

public class AppSimulation {
	
    public static void main(String[] args) {    	
 
    // CREATE SOLUTION
    
    Solution newS = new Solution();
    
    newS.setName("One Solution");
    RollupDaoSolution.persist(newS);
    
    int newId = newS.getId();
    System.out.println("Created New Solution. ID: " + newId + " New Solution name: " + newS.getName());
    
    //UPDATE SOLUTION RENAME BY ID AND NEW NAME

    RollupDaoSolution.updateRename(newId, "Renamed Solution");
    
    System.out.println("Updated New Solution new name: " + RollupDaoSolution.find(newId).getName()); // если использовать newS.getName(), то имя будет старое, так как объект воссоздается из БД 
    
    //UPDATE SOLUTION WITH EDITED OBJECT
    
    newS.setName("Again renamed Solution"); 
    RollupDaoSolution.update(newS);
    System.out.println("Updated again New Solution new name: " + RollupDaoSolution.find(newId).getName());
    
    //FIND ALL SOLUTIONS
    System.out.println("All found Solution names: ");
    
    List<Solution> l = RollupDaoSolution.findAll();
    		for (Solution s : l) {
    	    	System.out.println(s.getName());
    	    }
    
    Map<Integer, Solution> m = RollupDaoSolution.mapAll();		
    m.forEach((key, value) -> System.out.println(key + ":" + value));
    
    //FIND ONE SOLUTION BY ID
    System.out.println("Found New Solution ID: " + newId + " and name: " + RollupDaoSolution.find(newId).getName());

    
    // CREATE PROJECT
    
    Project newP = new Project();
    
    newP.setName("One Project");
    newP.setSolution(newS);
    
    RollupDaoProject.persist(newP);
    
    int newpId = newP.getId();
    
    System.out.println("Created New Project ID: " + newP.getId() + " New Project name: " + newP.getName());   
    
    //UPDATE PROJECT

    RollupDaoProject.updateRename(newpId, "Renamed Project");
    
    System.out.println("Updates New Project new name: " + newP.getName()); // в объекте лежит старое значение имени, так как редактировалась его копия, восстановленная из БД
    
    //FIND ALL
    System.out.println("All found Project names: ");
    
    List<Project> lp = RollupDaoProject.findAll();
    		for (Project p : lp) {
    	    	System.out.println(p.getName());
    	    }
    		
    //FIND PROJECTS BY SOLUTION ID
    System.out.println("All found by Solution Id Project names: ");
    	    
    List<Project> lps = RollupDaoSolution.findProjectsBySolutionId(newId);
    	    for (Project p : lps) {
    	    	   System.out.println(p.getName());
    	    }    
    		
    //FIND ONE BY ID
    System.out.println("Found New Project ID: " + newpId + " and name: " + RollupDaoProject.find(newpId).getName());
    
     //DELETE
     System.out.println("Deleting new Project and Solution");
        
     RollupDaoProject.delete(newpId);
     RollupDaoSolution.delete(newId);
 

    
    /*    //READ ALL
    ds.openFactory();
    ds.createManager(); 
    
    List<Solution> l = ds.findAll();
    for (Solution s : l) {
    	System.out.println(s.getName());
    }
 
    ds.closeManager();
    ds.closeFactory();
    
    
    //UPDATE
    ds.openFactory();
    ds.createManager();
    
    newS.setName("Changed Solution");
    
    ds.update(17);
    
    ds.closeManager();
    ds.closeFactory();
    
    //READ ONE
    
    ds.openFactory();
    ds.createManager(); 
    
    Solution sfind2 = ds.findById(newS.getId());
    	System.out.println(sfind2.getName());
 
    ds.closeManager();
    ds.closeFactory();
    
    //DELETE
    ds.openFactory();
    ds.createManager();
    
    ds.delete(11);
    
    ds.closeManager();
    ds.closeFactory();
    */
    }
}
