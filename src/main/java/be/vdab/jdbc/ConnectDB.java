package be.vdab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC",
                "root",
                "1Dv1MyjL$f&D*msQkbHJ93ud#dGw%G"
        )) {
            System.out.println("connection is good");
        } catch (Exception e) {
            System.out.println("connection no good");
            e.printStackTrace(System.err);
        }

    }
}
