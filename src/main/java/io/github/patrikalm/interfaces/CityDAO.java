package io.github.patrikalm.interfaces;

import io.github.patrikalm.City;

import java.util.List;

public interface CityDAO {

    City findByID(int id);
    List<City> findByCode(String countryCode);
    List<City> findByName(String name);
    List<City> findAll();
    City add(City city);
    City update(City city);
    int delete(City city);





}
