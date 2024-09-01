// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

// public class Customer {

//     private Connection conn;

//     public Customer(Connection conn) {
//         this.conn = conn;
//     }

//     public void addCustomer(String nama, String alamat, String telepon) {
//         String query = "INSERT INTO Pelanggan (nama_pelanggan, alamat, telepon) VALUES (?, ?, ?)";
//         try (PreparedStatement stmt = conn.prepareStatement(query)) {
//             stmt.setString(1, nama);
//             stmt.setString(2, alamat);
//             stmt.setString(3, telepon);
//             stmt.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public void displayCustomers() {
//         String query = "SELECT * FROM Pelanggan";
//         try (PreparedStatement stmt = conn.prepareStatement(query);
//                 ResultSet rs = stmt.executeQuery()) {
//             while (rs.next()) {
//                 System.out.println(rs.getInt("id_pelanggan") + ": " + rs.getString("nama_pelanggan") + ", "
//                         + rs.getString("alamat") + ", " + rs.getString("telepon"));
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String membershipStatus;

    public Customer(int id, String name, String address, String phone, String email, String membershipStatus) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.membershipStatus = membershipStatus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }
}