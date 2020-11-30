package edu.trial.itcompany;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.trial.itcompany.model.Person;
import edu.trial.itcompany.model.Project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for parsing a file and working with data
 * @author Maksim Shcherbakov
 * @version 1.0
 */
public class InformationRecipientImpl implements InformationRecipient{
    /**
     * List of employees from the file
     */
    List<Person> personList = new ArrayList<>();

    /**
     * The method parses the file to the list
     * @param file file name
     */
    public void parse (String file){
        Gson gson = new GsonBuilder().create();

        try {
            Person[] persons = gson.fromJson(new FileReader(file), Person[].class);
            personList.addAll(Arrays.asList(persons));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getListOfEmployeeOnProject(String project) {
        List<String> persons = new ArrayList<>();

        for (Person person : personList){
            for(Project projects : person.getProjects()){
                if(projects.getProjectName().equals(project)){
                    persons.add(person.getPersonName());
                }
            }
        }
        return persons;
    }

    @Override
    public List<String> getListOfManagersForEmployee(String empName) {
        List<String> manager = new ArrayList<>();

        for (Person person : personList){
           if(person.getPersonName().equals(empName)){
               for(Project projects : person.getProjects()){
                   if(check(manager, projects.getManager())) {
                       manager.add(projects.getManager());
                   }
               }
           }
        }
        return manager;
    }

    @Override
    public List<String> getListOfNotBusyEmployees() {
        List<String> persons = new ArrayList<>();

        for (Person person : personList){
            if (person.getProjects().length == 0){
                persons.add(person.getPersonName());
            }
        }
        return persons;
    }

    @Override
    public List<String> getListOfProjectsForCustomer(String customerName) {
        List<String> projectsList = new ArrayList<>();

        for (Person person : personList){
            for(Project projects : person.getProjects()){
                if(projects.getCustomer().equals(customerName)){
                    if(check(projectsList, projects.getProjectName())) {
                        projectsList.add(projects.getProjectName());
                    }
                }
            }
        }
        return projectsList;
    }

    /**
     * The method checks for an entry in the list
     * @param list general list
     * @param string string to check
     * @return true - the string is missing from the list, false - the string is in the list
     */
    private boolean check(List<String> list, String string){
        for(String s : list){
            if (s.equals(string)){
                return false;
            }
        }
        return true;
    }
}
