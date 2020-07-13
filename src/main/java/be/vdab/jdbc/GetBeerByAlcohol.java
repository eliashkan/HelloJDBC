package be.vdab.jdbc;

import java.sql.*;

public class GetBeerByAlcohol {
    public static void main(String[] args) {

        final String SQL_QUERY_BEER_BY_ALCOHOL = "select * from beers where Alcohol = ?";

        try (Connection con = DriverManager.getConnection(
                ConnectionUtils.ADDRESS,
                ConnectionUtils.USER,
                ConnectionUtils.PASSWORD);
             PreparedStatement prepstat = con.prepareStatement(SQL_QUERY_BEER_BY_ALCOHOL)
        ) {

            float valueToFillInQuestionMark = 5F;
            prepstat.setFloat(1, valueToFillInQuestionMark);
            ResultSet rs = prepstat.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getFloat("Alcohol"));

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
