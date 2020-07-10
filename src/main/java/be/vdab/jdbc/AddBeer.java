package be.vdab.jdbc;

import java.sql.*;

public class AddBeer {

    public static void main(String[] args) {

        final String SQL_QUERY_ADD_BEER = "insert into beers (Name, Alcohol, Price, Stock, BrewerId, CategoryId)" +
                "values ('BIER', 14, 2, 1000, 51, 14)";

        try (Connection con = DriverManager.getConnection(ConnectionUtils.ADDRESS,
                ConnectionUtils.USER, ConnectionUtils.PASSWORD);
        Statement st = con.createStatement()
        ) {

            st.executeUpdate(SQL_QUERY_ADD_BEER, Statement.RETURN_GENERATED_KEYS);

            try (ResultSet rs = st.getGeneratedKeys()) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
