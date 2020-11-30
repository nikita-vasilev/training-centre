package edu.trial.itcompany;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * The class checks the operation of methods of the InformationRecipientImpl class
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class InformationRecipientImplTest extends TestCase {
    /**
     * Object of the InformationRecipientImpl class
     */
    private InformationRecipientImpl informationRecipient = new InformationRecipientImpl();

    /**
     * The initial conditions for the tests
     */
    @Before
    public void setUp() {
        informationRecipient.parse("base.dat");
    }

    /**
     * This method tests the work of searching for employees in a specific project
     */
    public void testGetListOfEmployeeOnProject() {
        List<String> actual = new ArrayList<>();
        List<String> expected = informationRecipient.getListOfEmployeeOnProject("4G");

        actual.add("Sidorov");
        actual.add("Minakov");

        Assert.assertEquals(expected, actual);
    }

    /**
     * This method tests the search of superior for specified employee
     */
    public void testGetListOfManagersForEmployee() {
        List<String> actual = new ArrayList<>();
        List<String> expected = informationRecipient.getListOfManagersForEmployee("Minakov");

        actual.add("Sidorov");
        actual.add("Bill Geits");

        Assert.assertEquals(expected, actual);
    }

    /**
     * This method checks the search for employees who don't have a project
     */
    public void testGetListOfNotBusyEmployees() {
        List<String> actual = new ArrayList<>();
        List<String> expected = informationRecipient.getListOfNotBusyEmployees();

        actual.add("Ivanov");
        actual.add("Petrov");
        actual.add("Studenov");
        actual.add("Finberg");
        actual.add("Surname4");
        actual.add("Surname6");

        Assert.assertEquals(expected, actual);
    }

    /**
     * This method checks the search for the customer's projects
     */
    public void testGetListOfProjectsForCustomer() {
        List<String> actual = new ArrayList<>();
        List<String> expected = informationRecipient.getListOfProjectsForCustomer("Netcracker");

        actual.add("Facebook");
        actual.add("vk.com");

        Assert.assertEquals(expected, actual);
    }
}