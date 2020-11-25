package edu.trial.itcompany.recipient;

import edu.trial.itcompany.model.Employee;
import edu.trial.itcompany.model.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InformationRecipientImpl implements InformationRecipient {
    private List<Employee> employees;

    public InformationRecipientImpl ( List<Employee> employees ) {
        this.employees = employees;
    }

    @Override
    public List<String> getListOfEmployeeOnProject ( String project ) {
        return this.employees.stream ( )
                .filter ( e -> e.getProjects ( ).
                        stream ( )
                        .anyMatch ( p -> p.getProjectName ( ).equals ( project ) ) )
                .map ( Employee::getPersonName )
                .collect ( Collectors.toList ( ) );
    }

    @Override
    public List<String> getListOfManagersForEmployee ( String empName ) {
        var employee = this.employees.stream ( )
                .filter ( e -> e.getPersonName ( ).equals ( empName ) )
                .findAny ( )
                .get ( );
        return employee.getProjects ( )
                .stream ( )
                .map ( Project::getManager )
                .filter ( m->!m.equals ( employee.getPersonName () ) )
                .distinct ()
                .collect ( Collectors.toList ( ) );
    }

    @Override
    public List<String> getListOfNotBusyEmployees ( ) {
        return this.employees.stream ( )
                .filter ( e -> e.getProjects ( ).isEmpty ( ) )
                .map ( Employee::getPersonName )
                .collect ( Collectors.toList ( ) );
    }

    @Override
    public List<String> getListOfProjectsForCustomer ( String customerName ) {
        List<String> projects = new ArrayList<> ( );
        return this.employees.stream ( )
                .map ( Employee::getProjects )
                .flatMap ( List::stream )
                .filter ( p -> p.getCustomer ( ).equals ( customerName ) )
                .map ( Project::getProjectName )
                .distinct ()
                .collect ( Collectors.toList ( ) )
                ;

    }
}
