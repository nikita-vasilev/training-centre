package edu.trial.itcompany.DBmodel;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee", schema = "companys")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emplID")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "department", nullable = false)
    private String department;
}
