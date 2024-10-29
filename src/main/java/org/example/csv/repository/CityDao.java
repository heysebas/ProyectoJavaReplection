package org.example.repository;

import org.example.models.City;

public class CityDao extends DaoGeneral<City> {
    public CityDao() {
        super(City.class, "/Users/jpabloacosta/Desktop/U/8/Desarollo Equipo/3/ProyectoJavaReplection/cities.csv");
    }
}
