package io.github.patrikalm;


import io.github.patrikalm.dao.CityDaoJDBC;
import io.github.patrikalm.interfaces.CityDAO;

import java.util.ArrayList;
import java.util.List;



public class Main {


    public static void main(String[] args) {



        System.out.println("Hello, World!");

        City city1 = new City(4080, "Vägsjö", "SWE", "Kronobergs län", 101002); // Used for Update and Delete methods

        // City city = new City("Växjö", "SWE", "Kronobergs län", 101001); // Used for Add method

        CityDAO cityDAO = new CityDaoJDBC();

        List<City> testCities = new ArrayList<>();



        cityDAO.delete(city1); // Tested and works! :)

       // cityDAO.update(city1); // Tested and works! :)

        // cityDAO.add(city); // Tested and works! :)

        testCities = cityDAO.findAll(); // Tested and works! :)

        // testCities = cityDAO.findByCode("SWE"); // Tested and works! :)

        //testCities = cityDAO.findByName("Borås"); // Tested and works! :)

        // City testCity = cityDAO.findById(3); // Tested and works! :)




        //System.out.println(city.toString());

        testCities.forEach(System.out::println);


    }


}