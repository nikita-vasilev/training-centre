package edu.trial.itcompany.recipient;

import edu.trial.itcompany.model.Employee;
import edu.trial.itcompany.model.Project;

import java.util.ArrayList;
import java.util.List;

public class InformationRecipientImpl implements InformationRecipient {

    private List<Employee> employees;

    @Override
    public List<String> getListOfEmployeeOnProject(String project) {
        List<String> employeeList = new ArrayList<>();

        for (Employee employee : employees) {
            for (Project p : employee.getProjects()) {
                if (p.getProjectName().equals(project)) {
                    employeeList.add(employee.getPersonName());
                    break;
                }
            }
        }
        return employeeList;
    }

    @Override
    public List<String> getListOfManagersForEmployee(String empName) {
        List<String> managers = new ArrayList<>();
        boolean found = false;

        for (Employee employee : employees) {
            if (employee.getPersonName().equals(empName)) {
                for (Project p : employee.getProjects()) {
                    if (!p.getManager().equals(employee.getPersonName())) {
                        for (String emp : managers) {
                            if (emp.equals(p.getManager())) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            managers.add(p.getManager());
                        }
                    }
                }
                break;
            }
        }
        return managers;
    }

    @Override
    public List<String> getListOfNotBusyEmployees() {
        List<String> employeeList = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getProjects().size() == 0) {
                employeeList.add(employee.getPersonName());
            }
        }
        return employeeList;
    }

    @Override
    public List<String> getListOfProjectsForCustomer(String customerName) {
        List<String> projects = new ArrayList<>();
        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                if (project.getCustomer().equals(customerName)) {
                    projects.add(project.getProjectName());
                }
            }
        }
        return projects;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
