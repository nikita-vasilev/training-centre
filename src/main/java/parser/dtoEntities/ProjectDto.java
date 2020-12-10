package parser.dtoEntities;

import com.google.gson.annotations.SerializedName;

public class ProjectDto {
    @SerializedName("projectName")
    private String name;
    private String customer;
    private String manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                "name='" + name + '\'' +
                ", customer='" + customer + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}

