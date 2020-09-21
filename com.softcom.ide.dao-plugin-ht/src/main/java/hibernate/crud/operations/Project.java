package hibernate.crud.operations;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
   
    @ManyToOne
    @JoinColumn(name="solution_id")
    private Solution solution;

    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public Solution getSolution() {
        return solution;
    }
 
    public void setSolution(Solution solution) {
        this.solution = solution;
    }
    
    @Override
    public String toString() {
       return "Project [id=" + id + ", name=" + name + "]";
    }
}
