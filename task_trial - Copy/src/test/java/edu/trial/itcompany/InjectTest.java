package edu.trial.itcompany;

import edu.trial.itcompany.di.Inject;
import edu.trial.itcompany.di.JobDI;
import org.junit.Assert;
import org.junit.Test;

/**
 * The class checks the operation of methods of the Inject class
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class InjectTest {
    /**
     * The method tests dependency injection
     * @throws Exception to handle an injection error
     */
    @Test
    public void inject() throws Exception {
        JobDI jobDI = Inject.inject(new JobDI());

        Assert.assertEquals(jobDI.getInfo(), "Actor. Salary 50000");
    }
}