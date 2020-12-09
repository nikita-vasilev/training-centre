package edu.trial.itcompany.factory.jobs;

/**
 * Class describes the accounting job
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class Accounting implements Job{
    /**
     * This method returns information about the accounting job
     * @return information about the accounting job
     */
    @Override
    public String getInfo() {
        return "Accounting. Salary 60000";
    }
}
