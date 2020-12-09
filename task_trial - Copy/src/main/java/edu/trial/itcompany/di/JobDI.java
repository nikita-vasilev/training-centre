package edu.trial.itcompany.di;

import edu.trial.itcompany.factory.jobs.Job;

/**
 * The class implements injection
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class JobDI {
    /**
     * Field for injection
     */
    @Injection(value = "Actor")
    public Job job;

    /**
     * This method returns information about the job
     * @return information about the job
     */
    public String getInfo(){
        return job.getInfo();
    }
}
