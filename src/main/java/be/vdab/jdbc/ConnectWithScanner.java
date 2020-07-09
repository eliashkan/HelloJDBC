package be.vdab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import static be.vdab.jdbc.ConnectionUtils.*;

public class ConnectWithScanner {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String scannedPassword = null;

        while (scannedPassword == null) {
            System.out.println("Enter the password to the MySQL Server: ");
            scannedPassword = s.nextLine();
        }

        try (Connection con = DriverManager.getConnection(
                address,
                user,
                scannedPassword)
        ) {
            System.out.println("connection is good");


        } catch (Exception e) {
            System.out.println("connection no good");
            e.printStackTrace(System.err);
        }
    }
}
