package com.softcom.ide.testpojo;

import java.util.List;

public class Solution {
    private int id;
    private String name;
    
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