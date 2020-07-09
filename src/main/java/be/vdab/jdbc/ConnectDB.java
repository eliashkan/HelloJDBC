package be.vdab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import static be.vdab.jdbc.ConnectionUtils.*;

public class ConnectDB {
    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(
                address,
                user,
                password)
        ) {
            System.out.println("connection is good");


        } catch (Exception e) {
            System.out.println("connection no good");
            e.printStackTrace(System.err);
        }

    }
}
