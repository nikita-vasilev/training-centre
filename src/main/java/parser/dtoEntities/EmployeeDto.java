package parser.dtoEntities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeDto {
    @SerializedName("personName")
    private String name;
    private String department;
    private List<ProjectDto> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", projects=" + projects +
                '}';
    }
}
