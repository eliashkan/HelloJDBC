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
            System.out.println("These are all 5° beers:");
            while (rs.next()){
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getFloat("Alcohol"));

            }

            // new alcohol level query
            valueToFillInQuestionMark = 10F;
            prepstat.setFloat(1, valueToFillInQuestionMark);
            rs = prepstat.executeQuery();
            System.out.println("These are all 10° beers");
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getFloat("Alcohol"));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
