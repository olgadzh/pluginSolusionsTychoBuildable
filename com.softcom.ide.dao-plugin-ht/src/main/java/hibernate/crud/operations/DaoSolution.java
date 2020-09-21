package hibernate.crud.operations;

import hibernate.crud.operations.Solution;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class DaoSolution {

    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    
    public DaoSolution() {
    }
    
    public EntityManagerFactory openFactory() {
    	factory = Persistence.createEntityManagerFactory("solutiondb");
        return factory;
    }
    
    public EntityManager createManager() {
    	entityManager = factory.createEntityManager();
        return entityManager;
    }
    
    public EntityTransaction getTransaction() {
    	transaction = entityManager.getTransaction();
        return transaction;
    }
    
    public void closeManager() {
        entityManager.close();
    }
    
    public void closeFactory() {
        factory.close();
    }
    
    public void commitTransaction() {
        transaction.commit();
    }

    public void persist(Solution s) {
        entityManager.getTransaction().begin();	
        entityManager.persist(s);
        entityManager.getTransaction().commit();  
    }
    
    public void update(Solution s) {
        entityManager.getTransaction().begin();	
    	entityManager.merge(s);
        entityManager.getTransaction().commit();
    }
 
    public Solution findById(int id) {
    	Solution s = entityManager.find(Solution.class, id);
        return s; 
    }
 
    public void delete(int id) {
    	 try
    	  {
    		 transaction.begin();	
    		 Solution finds = entityManager.find(Solution.class, id);
    		 entityManager.remove(finds);
    		 entityManager.flush();
    		 transaction.commit();
    	  }
    	  catch(Exception e)
    	  {
    	    System.out.println("Unable to delete :" + entityManager.find(Solution.class, id).toString() + " there are references to it.");
    	  }
    	  finally
    	  {
    	    if (transaction.isActive()) transaction.rollback();
    	    entityManager.close();
    	  }
    }
    
 /*   @SuppressWarnings("unchecked")
	public List<Project> findProjectsBySolutionId(int id){
    	TypedQuery<Project> query = (TypedQuery<Project>) entityManager.createQuery("SELECT p FROM Project p WHERE p.solution = :id");
    	List<Project> results = query.setParameter("id", entityManager.find(Solution.class, id)).getResultList();
    	return results;
    }
*/
    public List<Project> findProjectsBySolutionId(int id){
    	Solution finds = entityManager.find(Solution.class, id);
    	List<Project> results = finds.getProjects();
    	return results;
    }
 
    @SuppressWarnings("unchecked")
    public List<Solution> findAll() {
    	Query q = entityManager.createQuery ("SELECT x FROM Solution x");
    	List<Solution> s = q.getResultList ();
        return s;
    }    
	
}
