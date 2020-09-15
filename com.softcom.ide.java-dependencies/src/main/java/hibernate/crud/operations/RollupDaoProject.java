package hibernate.crud.operations;

import java.util.List;

public abstract class RollupDaoProject {
	
    // PERSIST NEW PROJECT IN DB. FALL IF ALREADY EXISTS
	static void persist(Project newP) {
	    DaoProject dp = new DaoProject();	
	    dp.openFactory();
	    dp.createManager();
	    
	    dp.persist(newP);
	    
	    dp.closeManager();
	    dp.closeFactory();
	}
	
	// UPDATE BY MERGE WITH CHANGED ELSEWHERE OBJECT
	static void update(Project upP) {
		
	    DaoProject dp = new DaoProject();	
	    
	    dp.openFactory();
	    dp.createManager();
	    
	    dp.update(upP);
	    
	    dp.closeManager();
	    dp.closeFactory();		
	}
	
	// UPDATE EXISTING ROW BY ID AND NEW NAME VALUE
	static void updateRename(int id, String newName) {
		
	    DaoProject dp = new DaoProject();	
	    
	    dp.openFactory();
	    dp.createManager();
	    
	    Project upP = dp.findById(id);
	    upP.setName(newName);
	    dp.update(upP);
	    
	    dp.closeManager();
	    dp.closeFactory();		
	}
	
	// DELETE EXISTING ROW FROM DB
	static void delete(int id) {
	    
	    DaoProject dp = new DaoProject();	
	    dp.openFactory();
	    dp.createManager();
	    
	    dp.delete(id);
	    
	    dp.closeManager();
	    dp.closeFactory();	
	}
	
	
	// SELECT EXISTING ROW FROM TABLE BY ID
	
	static Project find(int id) {
		
	    DaoProject dp = new DaoProject();	
	    dp.openFactory();
	    dp.createManager();
	    
	    Project pfind = dp.findById(id);
	 
	    dp.closeManager();
	    dp.closeFactory();	
		
	    return pfind;
	}
	
	// SELECT ALL EXISTING ROW FROM TABLE
	
	static List<Project> findAll() {
		
	    DaoProject dp = new DaoProject();	
	    dp.openFactory();
	    dp.createManager();
	    
	    List<Project> l = dp.findAll();
	    
	    dp.closeManager();
	    dp.closeFactory();	
	    
	    return l;
	}
}
