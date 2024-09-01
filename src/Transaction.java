// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.Date;

// public class Transaction {

//     private Connection conn;

//     public Transaction(Connection conn) {
//         this.conn = conn;
//     }

//     public void addTransaction(int idProduk, int idPelanggan, Date tanggal, int jumlah) {
//         String query = "INSERT INTO Transaksi (id_produk, id_pelanggan, tanggal_transaksi, jumlah) VALUES (?, ?, ?, ?)";
//         try (PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setInt(1, idProduk);
//             stmt.setInt(2, idPelanggan);
//             stmt.setDate(3, new java.sql.Date(tanggal.getTime()));
//             stmt.setInt(4, jumlah);
//             stmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void displayTransactions() {
//         String query = "SELECT * FROM Transaksi";
//         try (PreparedStatement stmt = conn.prepareStatement(query);
//                 ResultSet rs = stmt.executeQuery()) {
//             while (rs.next()) {
//                 System.out.println(
//                         rs.getInt("id_transaksi") + ": " + rs.getInt("id_produk") + ", " + rs.getInt("id_pelanggan")
//                                 + ", " + rs.getDate("tanggal_transaksi") + ", " + rs.getInt("jumlah"));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }

public class Transaction {
    private int id;
    private int customerId;
    private String date;
    private double totalAmount;
    private double discount;

    public Transaction(int id, int customerId, String date, double totalAmount, double discount) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.discount = discount;
    }

    // Add getters and setters here if needed

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}