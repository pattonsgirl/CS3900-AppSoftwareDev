package com.wsu.workorderproservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

//@Entity annotation is used to mark a Java class as a JPA entity. This means that the class represents a table in a relational database,
// and its instances can be persisted to and retrieved from the database using JPA.
@Entity
//@NoArgsConstructor annotation in Lombok generates a constructor that takes no parameters.
@NoArgsConstructor
//@AllArgsConstructor generates a constructor with 1 parameter for each field in your class
@AllArgsConstructor
//@Getter annotation in Project Lombok is used to automatically generate a default getter method for a field
@Getter
//@Setter annotation automatically generates a setter method for a field when it's used
@Setter
//@Builder annotation in Lombok is a feature that generates a builder class for Java objects, which can simplify the process of creating objects
@Builder
//the @Table annotation is used to customize the mapping between an entity class and the corresponding database table
// [here we can specify table name if not match with entity name and also can specify index, unique constraints, ..etc]
@Table(name = "technician")
public class Technician {
    //@Id annotation is used to mark a field in an entity class as the primary key for that entity.
    // This primary key uniquely identifies each row in the corresponding database table. Also we can specify here auto increment, sequence generated id, or auto assigned id]
    @Id
    //@Column annotation is used to specify the mapping between an entity attribute and a database column. It allows you to customize various aspects of the column definition.
    @Column(name = "technician_code")
    private String code;
    @Column(name = "technician_first_name")
    private String firstName;
    @Column(name = "technician_last_name")
    private String lastName;
    @Column(name = "technician_type")
    private String type;
    @JoinTable(name = "technician_work_permit",
            joinColumns = @JoinColumn(name = "technician_code"),
            inverseJoinColumns = @JoinColumn(name = "state_code"))
    @ManyToMany
    private Set<State> workPermits;

}
