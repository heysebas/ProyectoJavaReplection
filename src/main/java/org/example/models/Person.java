package org.example.models;


public class Person {
    private int id_person;
    private String name;

    // Getters and Setters
    public int getId_person() { return id_person; }
    public void setId_person(int id_person) { this.id_person = id_person; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Person{id_person=" + id_person + ", name='" + name + "'}";
    }
}