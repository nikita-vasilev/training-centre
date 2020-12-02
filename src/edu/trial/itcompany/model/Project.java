package edu.trial.itcompany.model;

public class Project {
    private String projectName;
    private String customer;
    private String manager;

    public Project(String projectName, String customer, String manager) {
        this.projectName = projectName;
        this.customer = customer;
        this.manager = manager;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", customer='" + customer + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
