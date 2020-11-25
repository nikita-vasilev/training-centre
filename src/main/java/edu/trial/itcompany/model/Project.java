package edu.trial.itcompany.model;

public class Project {
    String projectName;
    String customer;
    String manager;

    public void setProjectName ( String projectName ) {
        this.projectName = projectName;
    }

    public void setCustomer ( String customer ) {
        this.customer = customer;
    }

    @Override
    public String toString ( ) {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", customer='" + customer + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }

    public void setManager ( String manager ) {
        this.manager = manager;
    }

    public String getProjectName ( ) {
        return projectName;
    }

    public String getCustomer ( ) {
        return customer;
    }

    public String getManager ( ) {
        return manager;
    }
}
