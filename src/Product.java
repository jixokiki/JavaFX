// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// public class Product {

//     private Connection conn;

//     public Product(Connection conn) {
//         this.conn = conn;
//     }

//     public void addProduct(String nama, double harga, int stok) {
//         String query = "INSERT INTO Produk (nama_produk, harga, stok) VALUES (?, ?, ?)";
//         try (PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setString(1, nama);
//             stmt.setDouble(2, harga);
//             stmt.setInt(3, stok);
//             stmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void displayProducts() {
//         String query = "SELECT * FROM Produk";
//         try (PreparedStatement stmt = conn.prepareStatement(query);
//                 ResultSet rs = stmt.executeQuery()) {
//             while (rs.next()) {
//                 System.out.println(rs.getInt("id_produk") + ": " + rs.getString("nama_produk") + ", "
//                         + rs.getDouble("harga") + ", " + rs.getInt("stok"));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stock;
    private String expiryDate;

    public Product(int id, String name, String category, double price, int stock, String expiryDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}