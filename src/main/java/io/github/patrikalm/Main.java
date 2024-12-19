package io.github.patrikalm;


import io.github.patrikalm.dao.CityDaoJDBC;

import java.util.ArrayList;
import java.util.List;



public class Main {


    public static void main(String[] args) {



        System.out.println("Hello, World!");


        City city = new City("Växjö", "SWE", "Kronobergs län", 101001);


        List<City> cities = new ArrayList<>();

        cities.add(CityDaoJDBC.findById(3));






    }


}