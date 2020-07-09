package be.vdab.jdbc;

import java.sql.*;

import static be.vdab.jdbc.ConnectionUtils.*;

public class SimpleBeerSearch {
    public static void main(String[] args) {
        try (
                Connection con = DriverManager.getConnection(
                        ADDRESS,
                        USER,
                        PASSWORD);

                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                ResultSet resultSet = stmt.executeQuery("select * from beers");

        ) {

            System.out.println("Connection OK!");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("Name"));
                System.out.println(resultSet.getDouble("Alcohol") + "% vol.");
                System.out.println(resultSet.getDouble("Price") + "€");
                System.out.println("---------------------------");
            }

        } catch (SQLException throwables) {
            System.out.println("Oops, something went wrong!");
            throwables.printStackTrace(System.err);
        }
    }
}
