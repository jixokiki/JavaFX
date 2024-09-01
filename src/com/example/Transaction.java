package com.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction {
    private Connection conn;

    public Transaction(Connection conn) {
        this.conn = conn;
    }

    public void addTransaction(int productId, int customerId, Date date, int quantity) {
        String query = "INSERT INTO Transaksi (id_produk, id_pelanggan, tanggal_transaksi, jumlah) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productId);
            stmt.setInt(2, customerId);
            stmt.setDate(3, date);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTransaction(int id, int productId, int customerId, Date date, int quantity) {
        String query = "UPDATE Transaksi SET id_produk = ?, id_pelanggan = ?, tanggal_transaksi = ?, jumlah = ? WHERE id_transaksi = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productId);
            stmt.setInt(2, customerId);
            stmt.setDate(3, date);
            stmt.setInt(4, quantity);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTransaction(int id) {
        String query = "DELETE FROM Transaksi WHERE id_transaksi = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayTransactions() {
        String query = "SELECT * FROM Transaksi";
        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_transaksi") +
                        ", Product ID: " + rs.getInt("id_produk") +
                        ", Customer ID: " + rs.getInt("id_pelanggan") +
                        ", Date: " + rs.getDate("tanggal_transaksi") +
                        ", Quantity: " + rs.getInt("jumlah"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
