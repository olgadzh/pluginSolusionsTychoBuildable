package hibernate.crud.operations;

import java.util.List;

public abstract class RollupDaoSolution {

    // PERSIST NEW SOLUTION IN DB. FALL IF ALREADY EXISTS
	static void persist(Solution newS) {
	    DaoSolution ds = new DaoSolution();	
	    ds.openFactory();
	    ds.createManager();
	    
	    ds.persist(newS);
	    
	    ds.closeManager();
	    ds.closeFactory();
	}

	// UPDATE BY MERGE WITH CHANGED ELSEWHERE OBJECT
	static void update(Solution upS) {
		
	    DaoSolution ds = new DaoSolution();	
	    
	    ds.openFactory();
	    ds.createManager();
	    
	    ds.update(upS);
	    
	    ds.closeManager();
	    ds.closeFactory();		
	}
	
	// UPDATE EXISTING ROW BY ID AND NEW NAME VALUE
	static void updateRename(int id, String newName) {
		
	    DaoSolution ds = new DaoSolution();	
	    
	    ds.openFactory();
	    ds.createManager();
	    
	    Solution upS = ds.findById(id);
	    upS.setName(newName);
	    ds.update(upS);
	    
	    ds.closeManager();
	    ds.closeFactory();		
	}
	
	
	// DELETE EXISTING ROW FROM DB
	static void delete(int id) {
	    
		DaoSolution ds = new DaoSolution();	
			
	    ds.openFactory();
	    ds.createManager();
	    ds.getTransaction();
	    
	    ds.delete(id);
	    
	    ds.closeFactory();
	}
	
	// SELECT EXISTING ROW FROM TABLE BY ID
	
	static Solution find(int id) {
		
		DaoSolution ds = new DaoSolution();	
		
	    ds.openFactory();
	    ds.createManager(); 
	    
	    Solution sfind = ds.findById(id);
	 
	    ds.closeManager();
	    ds.closeFactory();
		
	    return sfind;
	}
	
	// SELECT ALL EXISTING ROW FROM TABLE
	
	static List<Solution> findAll() {
		
		DaoSolution ds = new DaoSolution();	
		
		ds.openFactory();
	    ds.createManager(); 
	    
	    List<Solution> l = ds.findAll();
	    
	    ds.closeManager();
	    ds.closeFactory();
	    
	    return l;
	}
	
	// SELECT ALL PROJECTS BY SOLUTION ID
	
	static List<Project> findProjectsBySolutionId(int id) {
		
		DaoSolution ds = new DaoSolution();	
		
		ds.openFactory();
	    ds.createManager(); 
	    
	    List<Project> l = ds.findProjectsBySolutionId(id);
	    
	    ds.closeManager();
	    ds.closeFactory();
	    
	    return l;
	}
}
