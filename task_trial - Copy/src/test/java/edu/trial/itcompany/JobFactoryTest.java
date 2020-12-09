package edu.trial.itcompany;

import edu.trial.itcompany.factory.factories.AccountingFactory;
import edu.trial.itcompany.factory.factories.ActorFactory;
import edu.trial.itcompany.factory.factories.JobFactory;
import edu.trial.itcompany.factory.factories.ManagerFactory;
import edu.trial.itcompany.factory.jobs.Job;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The class checks the operation of methods of the JobFactory class
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class JobFactoryTest extends TestCase {
    /**
     * Factory job
     */
    private JobFactory jobFactory;

    /**
     * The method tests factory method
     */
    @Test
    public void testGetJob() {
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();

        actual.add("Actor. Salary 50000");
        actual.add("Accounting. Salary 60000");
        actual.add("Manager. Salary 100000");

        jobFactory = new ActorFactory();
        Job actor = jobFactory.createJob();
        expected.add(actor.getInfo());

        jobFactory = new AccountingFactory();
        Job accounting = jobFactory.createJob();
        expected.add(accounting.getInfo());

        jobFactory = new ManagerFactory();
        Job manager = jobFactory.createJob();
        expected.add(manager.getInfo());

        Assert.assertEquals(expected, actual);
    }
}