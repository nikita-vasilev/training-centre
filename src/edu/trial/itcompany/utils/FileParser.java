package edu.trial.itcompany.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.trial.itcompany.model.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {

    public static List<Employee> parse(File f) {
        List<Employee> employees = new ArrayList<>();
        Gson gson = new GsonBuilder().create();
        try {
            employees.addAll(Arrays.asList(gson.fromJson(new FileReader(f), Employee[].class)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
