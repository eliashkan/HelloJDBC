package be.vdab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static be.vdab.jdbc.ConnectionUtils.*;

public class ChangeStock {
    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(
                ADDRESS,
                USER,
                PASSWORD);

             Statement stmt = con.createStatement()

        ) {

            int numberOfRecordsUpdated = stmt.executeUpdate(
                    "update beers set stock = 50 where Name like '%kriek%'"
            );

            System.out.println("changed" + numberOfRecordsUpdated + "records");

        } catch (SQLException throwables) {
            System.out.println("something went wrong :(");
            throwables.printStackTrace();
        }

    }
}
