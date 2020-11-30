package edu.trial.itcompany.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * Class describes the person
 * @author Maksim Shcherbakov
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
public class Person {
    /**
     * Person name
     */
    private String personName;

    /**
     * Department person
     */
    private String department;

    /**
     * Projects person
     */
    private Project[] projects;

    /**
     * This method returns all information about the person
     * @return information about the person
     */
    @Override
    public String toString() {
        return "personName: " + personName + "\n" +
                "department: " + department + "\n" +
                "projects: " + Arrays.toString(projects) + "\n";
    }
}
