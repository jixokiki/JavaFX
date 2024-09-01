package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private Connection conn;

    public Customer(Connection conn) {
        this.conn = conn;
    }

    public void addCustomer(String name, String address, String phone) {
        String query = "INSERT INTO Pelanggan (nama_pelanggan, alamat, no_telepon) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, phone);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(int id, String name, String address, String phone) {
        String query = "UPDATE Pelanggan SET nama_pelanggan = ?, alamat = ?, no_telepon = ? WHERE id_pelanggan = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, phone);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        String query = "DELETE FROM Pelanggan WHERE id_pelanggan = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayCustomers() {
        String query = "SELECT * FROM Pelanggan";
        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_pelanggan") +
                        ", Name: " + rs.getString("nama_pelanggan") +
                        ", Address: " + rs.getString("alamat") +
                        ", Phone: " + rs.getString("no_telepon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
