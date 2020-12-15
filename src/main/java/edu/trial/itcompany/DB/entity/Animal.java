package edu.trial.itcompany.DB.entity;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String species;
    private double weight;

    public Animal ( String name, String species, double weight ) {
        this.name = name;
        this.species = species;
        this.weight = weight;
    }

    public Animal ( Long id, String name, String species, double weight ) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.weight = weight;
    }

    public Animal ( ) {
    }

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getSpecies ( ) {
        return species;
    }

    public void setSpecies ( String species ) {
        this.species = species;
    }

    public double getWeight ( ) {
        return weight;
    }

    public void setWeight ( double weight ) {
        this.weight = weight;
    }
}
