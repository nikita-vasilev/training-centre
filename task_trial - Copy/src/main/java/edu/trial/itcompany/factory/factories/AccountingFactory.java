package edu.trial.itcompany.factory.factories;

import edu.trial.itcompany.factory.jobs.Accounting;
import edu.trial.itcompany.factory.jobs.Job;

/**
 * Class describes the accounting job factory
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class AccountingFactory extends JobFactory {
    /**
     * This method returns the created job accounting
     * @return created job accounting
     */
    @Override
    public Job createJob() {
        return new Accounting();
    }
}
