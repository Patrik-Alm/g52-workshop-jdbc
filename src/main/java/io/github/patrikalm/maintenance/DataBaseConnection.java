package io.github.patrikalm.maintenance;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {


    public static Connection getConnection() throws SQLException {

        Properties properties = new Properties();

        Reader in = Files.newBufferedReader(Path.of();



        // return DriverManager.getConnection(url, name, password);


    }


}
