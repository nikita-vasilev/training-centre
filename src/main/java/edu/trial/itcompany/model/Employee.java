package edu.trial.itcompany.model;

import java.util.List;

public class Employee {
    String personName;
    String department;
    List<Project> projects;

    public void setPersonName ( String personName ) {
        this.personName = personName;
    }

    @Override
    public String toString ( ) {
        return "Employee{" +
                "personName='" + personName + '\'' +
                ", department='" + department + '\'' +
                ", projects=" + projects +
                '}';
    }

    public void setDepartment ( String department ) {
        this.department = department;
    }

    public void setProjects ( List<Project> projects ) {
        this.projects = projects;
    }

    public String getPersonName ( ) {
        return personName;
    }

    public String getDepartment ( ) {
        return department;
    }

    public List<Project> getProjects ( ) {
        return projects;
    }
}
