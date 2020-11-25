package edu.trial.itcompany;

import edu.trial.itcompany.recipient.InformationRecipientImpl;
import edu.trial.itcompany.util.FileParser;

import java.io.IOException;

public class Main {
    public static void main ( String[] args ) throws IOException {
        var parser = new FileParser ( );
        var recipient = new InformationRecipientImpl ( parser.parse ( "base.dat" ) );
        System.out.println ("Employees on project Dos: " );
        System.out.println ( recipient.getListOfEmployeeOnProject ( "Dos" ) );
        System.out.println ("Not busy : " );
        System.out.println ( recipient.getListOfNotBusyEmployees ( ) );
        System.out.println ("Managers for Surname1 : " );
        System.out.println (recipient.getListOfManagersForEmployee ( "Surname1" ) );
        System.out.println ("Projects  for NEC Corporation : " );
        System.out.println (recipient.getListOfProjectsForCustomer ( "NEC Corporation" ) );
    }
}
