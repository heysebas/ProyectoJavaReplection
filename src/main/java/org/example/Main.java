package org.example;

import org.example.interfac.CSVLoader;
import org.example.models.City;
import org.example.models.Person;
import org.example.repository.CityDao;
import org.example.repository.PersonDao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVLoader<Person> personLoader = new CSVLoader<>();
        List<Person> persons = personLoader.loadFromCSV("/home/mariana/Descargas/csv/person.csv", Person.class);

        PersonDao personRepository = new PersonDao();
        persons.forEach(personRepository::add);

        System.out.println("All Person records:");
        personRepository.getAll().forEach(System.out::println);


        // Similarly for City
        CSVLoader<City> cityLoader = new CSVLoader<>();
        List<City> cities = cityLoader.loadFromCSV("/home/mariana/Descargas/csv/city.csv", City.class);

        CityDao cityRepository = new CityDao();
        cities.forEach(cityRepository::add);

        System.out.println("All cities records:");
        cityRepository.getAll().forEach(System.out::println);
    }
}