package edu.trial.itcompany.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class describes the project
 * @author Maksim Shcherbakov
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    /**
     * Project name
     */
    private String projectName;

    /**
     * Project customer
     */
    private String customer;

    /**
     * Project manager
     */
    private String manager;

    /**
     * This method returns all information about the project
     * @return information about the project
     */
    @Override
    public String toString() {
        return  "projectName: " + projectName + "\n"+
                "customer: " + customer + "\n"+
                "manager: " + manager + "\n";
    }
}
