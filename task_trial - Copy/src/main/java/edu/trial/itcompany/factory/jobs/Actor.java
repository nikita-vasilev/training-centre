package edu.trial.itcompany.factory.jobs;

/**
 * Class describes the actor job
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class Actor implements Job {
    /**
     * This method returns information about the actor job
     * @return information about the actor job
     */
    @Override
    public String getInfo() {
        return "Actor. Salary 50000";
    }
}
