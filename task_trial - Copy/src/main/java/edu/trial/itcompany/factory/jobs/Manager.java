package edu.trial.itcompany.factory.jobs;

/**
 * Class describes the manager job
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class Manager implements Job {
    /**
     * This method returns information about the manager job
     * @return information about the manager job
     */
    @Override
    public String getInfo() {
        return "Manager. Salary 100000";
    }
}
