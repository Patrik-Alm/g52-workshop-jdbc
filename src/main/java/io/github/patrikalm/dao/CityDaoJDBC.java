package io.github.patrikalm.dao;

import io.github.patrikalm.City;
import io.github.patrikalm.interfaces.CityDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CityDaoJDBC implements CityDAO {



    public getConnection () {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "G52Java");
        } catch (SQLException e) {
            throw new RuntimeException("Oops, something went wrong with the connection!");
        }
    }






    @Override
    public City findByID(int id) {
        return null;
    }

    @Override
    public List<City> findByCode(String countryCode) {
        return List.of();
    }

    @Override
    public List<City> findByName(String name) {
        return List.of();
    }

    @Override
    public List<City> findAll() {
        return List.of();
    }

    @Override
    public City add(City city) {
        return null;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public int delete(City city) {
        return 0;
    }
}
