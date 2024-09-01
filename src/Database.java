// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class Database {

//     public static Connection connect() {
//         String url = "jdbc:mysql://localhost:3306/SalesInventoryDB";
//         String user = "root"; // Ganti dengan user MySQL Anda
//         String password = "Bekasibarat12"; // Ganti dengan password MySQL Anda

//         try {
//             return DriverManager.getConnection(url, user, password);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/JavaFXSales";
    private static final String USER = "root";
    private static final String PASSWORD = "Bekasibarat12";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
