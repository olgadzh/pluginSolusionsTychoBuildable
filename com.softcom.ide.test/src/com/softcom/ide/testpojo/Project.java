package com.softcom.ide.testpojo;

public class Project {

    private int id;
    private String name;
   
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
