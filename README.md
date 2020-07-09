# Voorbeeldcode JDBC met cursus van Noël Vaes

## ConnectionUtils.java ziet er als volgt uit

    package be.vdab.jdbc;
    
    public class ConnectionUtils {
        static final String address = "jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC";
        static final String user = "root";
        static final String password = "YOURPASSWORDFORYOURMYSQLSERVER";
    }