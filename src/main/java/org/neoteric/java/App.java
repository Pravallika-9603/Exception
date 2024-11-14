package org.neoteric.java;

import org.neoteric.java.Exceptions.InvalidOrderException;
import org.neoteric.java.Service.ClothingProduct;
import org.neoteric.java.Service.ElectronicProduct;
import org.neoteric.java.Service.OrderImp;
import org.neoteric.java.Service.RegularUser;
import org.neoteric.java.model.Order;
import org.neoteric.java.model.Product;
import org.neoteric.java.model.User;

import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args) {
        // Step 1: Create a User (Regular or Premium)
        User user = new RegularUser("U001", "Alice");

        // Step 2: Create some Products
        Product laptop = new ElectronicProduct("P001", "Laptop", 800, 5);
        Product shirt = new ClothingProduct("P002", "Shirt", 2000, 50);

        // Step 3: Add products to a list
        List<Product> productList = new ArrayList<>();
        productList.add(laptop);
        productList.add(shirt);

        // Step 4: Create an Order
        Order order = new Order("O001", user, productList);

        // Step 5: Create OrderService instance
        OrderImp orderService = new OrderImp();

        // Step 6: Place the order
        try {
            orderService.placeOrder(order);
        } catch (InvalidOrderException e) {
            System.out.println("Error placing order: " + e.getMessage());
        }

        // Step 7: Attempt to add another product and update the order
        Product headphones = new ElectronicProduct("P003", "Headphones", 100, 10);
        productList.add(headphones);

        try {
            orderService.updateOrder(order.getOrderId(), productList);
        } catch (InvalidOrderException e) {
            System.out.println("Error updating order: " + e.getMessage());
        }

        // Step 8: Cancel the order
        try {
            orderService.cancelOrder(order.getOrderId());
        } catch (InvalidOrderException e) {
            System.out.println("Error canceling order: " + e.getMessage());
        }
    }
}

