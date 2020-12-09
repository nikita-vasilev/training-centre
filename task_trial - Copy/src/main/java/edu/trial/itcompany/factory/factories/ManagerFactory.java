package edu.trial.itcompany.factory.factories;

import edu.trial.itcompany.factory.jobs.Job;
import edu.trial.itcompany.factory.jobs.Manager;

/**
 * Class describes the manager job factory
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class ManagerFactory extends JobFactory {
    /**
     * This method returns the created job manager
     * @return created job manager
     */
    @Override
    public Job createJob() {
        return new Manager();
    }
}
