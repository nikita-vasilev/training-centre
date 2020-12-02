package edu.trial.itcompany;

import edu.trial.itcompany.model.Employee;
import edu.trial.itcompany.recipient.InformationRecipientImpl;
import edu.trial.itcompany.utils.FileParser;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InformationRecipientImpl recipient = new InformationRecipientImpl();
        recipient.setEmployees(FileParser.parse(new File("D:/base.dat")));
        showEmployees(recipient.getEmployees());
        System.out.println("ListOfEmployeeOnProject Windows 300:\n"+recipient.getListOfEmployeeOnProject("Windows 300")+'\n');
        System.out.println("ListOfManagersForEmployee Minakov:\n"+recipient.getListOfManagersForEmployee("Minakov")+'\n');
        System.out.println("ListOfNotBusyEmployees:\n"+recipient.getListOfNotBusyEmployees()+'\n');
        System.out.println("ListOfProjectsForCustomer Sun:\n"+recipient.getListOfProjectsForCustomer("Sun")+'\n');
    }

    private static void showEmployees(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println("-----");
    }
}