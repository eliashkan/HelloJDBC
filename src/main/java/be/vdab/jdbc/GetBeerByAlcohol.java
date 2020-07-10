package be.vdab.jdbc;

import java.sql.*;

public class GetBeerByAlcohol {
    public static void main(String[] args) {

        final String SQL_QUERY_BEER_BY_ALCOHOL = "select * from beers where Alcohol = ?";

        try (Connection con = DriverManager.getConnection(
                ConnectionUtils.ADDRESS,
                ConnectionUtils.USER,
                ConnectionUtils.PASSWORD);
             PreparedStatement st = con.prepareStatement(SQL_QUERY_BEER_BY_ALCOHOL)
        ) {

            float i = 5F;
            st.setFloat(1, i);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getFloat("Alcohol"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
