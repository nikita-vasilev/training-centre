package edu.trial.itcompany.factory.factories;

import edu.trial.itcompany.factory.jobs.Actor;
import edu.trial.itcompany.factory.jobs.Job;

/**
 * Class describes the actor job factory
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class ActorFactory extends JobFactory {
    /**
     * This method returns the created job actor
     * @return created job actor
     */
    @Override
    public Job createJob() {
        return new Actor();
    }
}
