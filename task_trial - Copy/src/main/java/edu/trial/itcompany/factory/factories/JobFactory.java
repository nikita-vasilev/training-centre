package edu.trial.itcompany.factory.factories;

import edu.trial.itcompany.factory.jobs.*;

/**
 * Abstract class describes the job factory
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public abstract class JobFactory {
    /**
     * This method returns the created job
     * @return created job
     */
    public abstract Job createJob();
}
