package io.github.patrikalm.dao;

import io.github.patrikalm.City;
import io.github.patrikalm.interfaces.CityDAO;
import io.github.patrikalm.maintenance.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDAO {




    static List<City> cityList = new ArrayList<>();




    @Override
    public City findById(int id) {

        String sql = "SELECT * FROM city WHERE ID = ?";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {

                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                  if (resultSet.next()) {

                    return new City(
                            resultSet.getInt("ID"), resultSet.getString("Name"),
                            resultSet.getString("CountryCode"), resultSet.getString("District"),
                            resultSet.getInt("Population")
                    );
                  }
                }

        } catch (SQLException e1) {
            e1.printStackTrace();
            throw new RuntimeException("Oops, something went wrong with the database query!" + e1.getMessage());
        }

        return null;
    }

    @Override
    public List<City> findByCode(String countryCode) {


        String sql = "SELECT * FROM city WHERE CountryCode = ?";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {

            preparedStatement.setString(1, countryCode);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                cityList.clear();

                while (resultSet.next()) {

                    cityList.add( new City(
                            resultSet.getInt("ID"), resultSet.getString("Name"),
                            resultSet.getString("CountryCode"), resultSet.getString("District"),
                            resultSet.getInt("Population")));
                }
                return cityList;
            }

            } catch (SQLException e2) {
                throw new RuntimeException("Oops, something went wrong with the database query!");
            }
    }

    @Override
    public List<City> findByName(String name) {
        String sql = "SELECT * FROM city WHERE Name = ?";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, name);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                cityList.clear();

                while (resultSet.next()) {

                    cityList.add( new City(
                            resultSet.getInt("ID"), resultSet.getString("Name"),
                            resultSet.getString("CountryCode"), resultSet.getString("District"),
                            resultSet.getInt("Population")));
                }
                return cityList;
            }

        } catch (SQLException e3) {
            throw new RuntimeException("Oops, something went wrong with the database query!");
        }
    }

    @Override
    public List<City> findAll() {

        String sql = "SELECT * FROM city";

        try(
                Connection connection = DataBaseConnection.getConnection();
                Statement statement = connection.createStatement();
        ) {


            try (ResultSet resultSet = statement.executeQuery(sql)) {

                cityList.clear();

                while (resultSet.next()) {

                    cityList.add( new City(
                            resultSet.getInt("ID"), resultSet.getString("Name"),
                            resultSet.getString("CountryCode"), resultSet.getString("District"),
                            resultSet.getInt("Population")));
                }
                return cityList;
            }

        } catch (SQLException e4) {
            throw new RuntimeException("Oops, something went wrong with the database query!");
        }
    }

    @Override
    public City add(City city) {

        String sql = "INSERT INTO city (Name, CountryCode, District, Population) VALUES (?,?,?,?)";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ) {


            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());

            int affectedRows = preparedStatement.executeUpdate();

            return city;


        } catch (SQLException e5) {
            throw new RuntimeException("Oops, something went wrong with adding an object to the database!" + e5.getMessage());
        }
    }

    @Override
    public City update(City city) {

        String sql = "UPDATE city SET Name =?, CountryCode = ?, District = ?, Population = ? WHERE ID = ?";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1, city.name);
            preparedStatement.setString(2, city.countryCode);
            preparedStatement.setString(3, city.district);
            preparedStatement.setInt(4, city.population);
            preparedStatement.setInt(5, city.getId());

           preparedStatement.executeUpdate();

        } catch (SQLException e6) {
            throw new RuntimeException("Oops, something went wrong with updating an object in the database!");
        }
        return null;
    }

    @Override
    public int delete(City city) {

        String sql = "DELETE FROM city WHERE ID = ?";

        try(
                Connection connection = DataBaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){

            preparedStatement.setInt(1, city.getId());

            preparedStatement.executeUpdate();



        }catch (SQLException e7) {
            throw new RuntimeException("Oops, something went wrong with deleting an object in the database!");
        }

        return 0;
    }
}
