package hibernate.crud.operations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class DaoProject {
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    
    public DaoProject() {
    }
    
    public EntityManagerFactory openFactory() {
    	factory = Persistence.createEntityManagerFactory("solutiondb");
        return factory;
    }
    
    public EntityManager createManager() {
    	entityManager = factory.createEntityManager();
        return entityManager;
    }
    
    public void closeManager() {
        entityManager.close();
    }
    
    public void closeFactory() {
        factory.close();
    }

    public void persist(Project p) {
        entityManager.getTransaction().begin();	
        entityManager.persist(p);
        entityManager.getTransaction().commit();	
    }
    
    
    public void update(Project p) {
        entityManager.getTransaction().begin();	
    	entityManager.merge(p);
        entityManager.getTransaction().commit();
    }
 
    public Project findById(int id) {
    	Project p = entityManager.find(Project.class, id);
        return p; 
    }
 
    public void delete(int id) {
        entityManager.getTransaction().begin();	
        Project findp = entityManager.find(Project.class, id);
    	entityManager.remove(findp);
    	entityManager.flush();
        entityManager.getTransaction().commit(); 
    }
    
    @SuppressWarnings("unchecked")
	public Solution findSolutionByProjectId(int id){
    	TypedQuery<Solution> query = (TypedQuery<Solution>) entityManager.createNamedQuery("SELECT s FROM Project p JOIN Solution s WHERE p.id = :id");
    	Solution result = query.getSingleResult();
    	return result;
    	}
    	
    @SuppressWarnings("unchecked")
    public List<Project> findAll() {
    	Query q = entityManager.createQuery ("SELECT x FROM Project x");
        List<Project> p = q.getResultList ();
        return p;
    }
 

}
