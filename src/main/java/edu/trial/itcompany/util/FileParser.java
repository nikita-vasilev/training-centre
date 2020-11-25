package edu.trial.itcompany.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.trial.itcompany.model.Employee;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FileParser {
    public List<Employee> parse ( String fileName ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper ( );
        List<Employee> employees = objectMapper.readValue ( new File ( fileName ), new TypeReference<List<Employee>> ( ) {
        } );
        System.out.println ( Arrays.toString ( employees.toArray ( ) ) );
        return employees;
    }
}
