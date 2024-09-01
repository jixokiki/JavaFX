package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private Connection conn;

    public Product(Connection conn) {
        this.conn = conn;
    }

    public void addProduct(String name, double price, int stock) {
        String query = "INSERT INTO Produk (nama_produk, harga, stok) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setInt(3, stock);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(int id, String name, double price, int stock) {
        String query = "UPDATE Produk SET nama_produk = ?, harga = ?, stok = ? WHERE id_produk = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setInt(3, stock);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        String query = "DELETE FROM Produk WHERE id_produk = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayProducts() {
        String query = "SELECT * FROM Produk";
        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_produk") +
                        ", Name: " + rs.getString("nama_produk") +
                        ", Price: " + rs.getDouble("harga") +
                        ", Stock: " + rs.getInt("stok"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
