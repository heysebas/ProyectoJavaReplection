package org.example.repository;

import org.example.models.Person;

public class PersonDao extends DaoGeneral<Person> {
    public PersonDao() {
        super(Person.class, "/Users/jpabloacosta/Desktop/U/8/Desarollo Equipo/3/ProyectoJavaReplection/persons.csv"); // Specify the path to your persons CSV file
    }
}
