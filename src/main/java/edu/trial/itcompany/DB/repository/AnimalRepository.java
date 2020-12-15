package edu.trial.itcompany.DB.repository;

import edu.trial.itcompany.DB.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
