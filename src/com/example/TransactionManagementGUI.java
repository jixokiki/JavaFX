package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Date;

public class TransactionManagementGUI extends Application {
    private Transaction transactionManager;

    @Override
    public void start(Stage primaryStage) {
        Connection conn = Database.connect();
        transactionManager = new Transaction(conn);

        primaryStage.setTitle("Transaction Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Product ID input
        Label productIdLabel = new Label("Product ID:");
        GridPane.setConstraints(productIdLabel, 0, 0);
        TextField productIdInput = new TextField();
        GridPane.setConstraints(productIdInput, 1, 0);

        // Customer ID input
        Label customerIdLabel = new Label("Customer ID:");
        GridPane.setConstraints(customerIdLabel, 0, 1);
        TextField customerIdInput = new TextField();
        GridPane.setConstraints(customerIdInput, 1, 1);

        // Quantity input
        Label quantityLabel = new Label("Quantity:");
        GridPane.setConstraints(quantityLabel, 0, 2);
        TextField quantityInput = new TextField();
        GridPane.setConstraints(quantityInput, 1, 2);

        // Add Transaction button
        Button addButton = new Button("Add Transaction");
        addButton.setOnAction(e -> {
            int productId = Integer.parseInt(productIdInput.getText());
            int customerId = Integer.parseInt(customerIdInput.getText());
            int quantity = Integer.parseInt(quantityInput.getText());
            Date date = new Date(System.currentTimeMillis());
            transactionManager.addTransaction(productId, customerId, date, quantity);
        });
        GridPane.setConstraints(addButton, 1, 3);

        grid.getChildren().addAll(productIdLabel, productIdInput, customerIdLabel, customerIdInput, quantityLabel, quantityInput, addButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
