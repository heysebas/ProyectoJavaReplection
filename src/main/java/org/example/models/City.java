package org.example.models;

public class City {

    private Integer idCity;
    private String name;

    public City(Integer idCity, String name) {
        this.idCity = idCity;
        this.name = name;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
