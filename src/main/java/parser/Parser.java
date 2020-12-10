package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Employee;
import parser.dtoEntities.EmployeeDto;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    Gson parser;

    public Parser() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        parser = gsonBuilder.create();
    }

    public List<EmployeeDto> parseBaseToEmployees(){
        List<EmployeeDto> list =  new ArrayList<>();
        try (Reader reader = new FileReader("D:\\IdeaProjects\\base.dat")) {
            list = parser.fromJson(reader, new TypeToken<List<EmployeeDto>>() {}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
