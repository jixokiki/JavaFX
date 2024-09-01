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

public class CustomerManagementGUI extends Application {
    private Customer customerManager;

    @Override
    public void start(Stage primaryStage) {
        Connection conn = Database.connect();
        customerManager = new Customer(conn);

        primaryStage.setTitle("Customer Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Name input
        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0);

        // Address input
        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 1);
        TextField addressInput = new TextField();
        GridPane.setConstraints(addressInput, 1, 1);

        // Phone input
        Label phoneLabel = new Label("Phone:");
        GridPane.setConstraints(phoneLabel, 0, 2);
        TextField phoneInput = new TextField();
        GridPane.setConstraints(phoneInput, 1, 2);

        // Add Customer button
        Button addButton = new Button("Add Customer");
        addButton.setOnAction(e -> {
            String name = nameInput.getText();
            String address = addressInput.getText();
            String phone = phoneInput.getText();
            customerManager.addCustomer(name, address, phone);
        });
        GridPane.setConstraints(addButton, 1, 3);

        grid.getChildren().addAll(nameLabel, nameInput, addressLabel, addressInput, phoneLabel, phoneInput, addButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
