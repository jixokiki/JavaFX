package com.example;

import java.sql.Connection;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProductManagementGUI extends Application {
    private Product productManager;

    @Override
    public void start(Stage primaryStage) {
        Connection conn = Database.connect();
        productManager = new Product(conn);

        primaryStage.setTitle("Product Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Name input
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0);

        // Price input
        Label priceLabel = new Label("Price:");
        GridPane.setConstraints(priceLabel, 0, 1);
        TextField priceInput = new TextField();
        GridPane.setConstraints(priceInput, 1, 1);

        // Stock input
        Label stockLabel = new Label("Stock:");
        GridPane.setConstraints(stockLabel, 0, 2);
        TextField stockInput = new TextField();
        GridPane.setConstraints(stockInput, 1, 2);

        // Add Product button
        Button addButton = new Button("Add Product");
        addButton.setOnAction(e -> {
            String name = nameInput.getText();
            double price = Double.parseDouble(priceInput.getText());
            int stock = Integer.parseInt(stockInput.getText());
            productManager.addProduct(name, price, stock);
        });
        GridPane.setConstraints(addButton, 1, 3);

        grid.getChildren().addAll(nameLabel, nameInput, priceLabel, priceInput, stockLabel, stockInput, addButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
