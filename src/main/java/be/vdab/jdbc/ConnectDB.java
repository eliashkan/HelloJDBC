package be.vdab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static be.vdab.jdbc.ConnectionUtils.*;

public class ConnectDB {
    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(
                ADDRESS,
                USER,
                PASSWORD);
             Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet resultSet = statement.executeQuery("SELECT * FROM BEERS;")
        ) {
            System.out.println("connection is good");


        } catch (Exception e) {
            System.out.println("connection no good");
            e.printStackTrace(System.err);
        }

    }
}
