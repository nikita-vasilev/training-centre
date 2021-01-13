package edu.trial.itcompany.repository;

import edu.trial.itcompany.DBmodel.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findAll();

    public void deleteById(Long id);

}
