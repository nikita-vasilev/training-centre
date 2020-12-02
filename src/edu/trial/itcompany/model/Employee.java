package edu.trial.itcompany.model;

import java.util.List;

public class Employee {
    private String personName;
    private String department;
    private List<Project> projects;

    public Employee(String personName, String department, List<Project> projects) {
        this.personName = personName;
        this.department = department;
        this.projects = projects;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personName='" + personName + '\'' +
                ", department='" + department + '\'' +
                ", projects=" + projects +
                '}';
    }
}
