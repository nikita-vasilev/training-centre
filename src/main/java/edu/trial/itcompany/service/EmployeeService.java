package edu.trial.itcompany.service;

import edu.trial.itcompany.DBmodel.Employee;
import edu.trial.itcompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public EmployeeService (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void save (Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void update (Employee employee) {
        em.merge(employee);
    }

    public void deleteById (Long id) {
        employeeRepository.deleteById(id);
    }
}
