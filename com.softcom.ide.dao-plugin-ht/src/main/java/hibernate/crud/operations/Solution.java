package hibernate.crud.operations;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "solution")
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @OneToMany(mappedBy="solution", fetch = FetchType.EAGER) // ÑĞÀÇÓ ÂÛÊÀ×ÈÂÀÅÌ ÈÇ ÁÄ ÂÑÅ ÏĞÎÅÊÒÛ ÏÎ ĞÅØÅÍÈŞ
    private List<Project> projects;
    
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
    
    public List<Project> getProjects() {
        return projects;
    }
    
    @Override
    public String toString() {
       return "Solution [id=" + id + ", name=" + name + "]";
    }
}
