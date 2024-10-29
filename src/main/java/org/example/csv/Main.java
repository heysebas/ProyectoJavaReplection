package org.example;

import org.example.models.City;
import org.example.models.Person;
import org.example.repository.CityDao;
import org.example.repository.PersonDao;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CityDao cityDao = new CityDao();
        List<City> cities = cityDao.findAll();
        cities.forEach(System.out::println);

        PersonDao personDao = new PersonDao();
        List<Person> persons = personDao.findAll();
        persons.forEach(System.out::println);

    }
}