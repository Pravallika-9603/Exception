package org.neoteric.java.Service;

import org.neoteric.java.Exceptions.InvalidOrderException;
import org.neoteric.java.Exceptions.OutOfStockException;
import org.neoteric.java.Exceptions.PaymentFailureException;
import org.neoteric.java.interfaces.OrderService;
import org.neoteric.java.interfaces.PaymentStatus;
import org.neoteric.java.model.Order;
import org.neoteric.java.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderImp implements OrderService {

    private Map<String, Order> orders=new HashMap<>();

    @Override
    public void placeOrder(Order order) throws InvalidOrderException {

        if(order.getProductList().isEmpty()){
            throw new InvalidOrderException("");
        }

        if (!processPayment(order.getTotalAmount())) {
            System.out.println(" failed"+PaymentStatus.failure);
        }
        else {
            orders.put(order.getOrderId(), order);
            order.markAsPaid();
            System.out.println("Order placed successfully."+PaymentStatus.success);
        }

    }

    @Override
    public void cancelOrder(String orderId) throws InvalidOrderException{

        Order order = orders.get(orderId);
        if (order == null || order.isPaid()) {
            throw new InvalidOrderException("Order cannot be cancelled.");
        }
        orders.remove(orderId);
        System.out.println("Order canceled successfully.");

    }

    @Override
    public void updateOrder(String orderId, List<Product> productList) throws InvalidOrderException{

        Order order = orders.get(orderId);
        if (order == null) {
            throw new InvalidOrderException("Order not found.");
        }
        order = new Order(order.getOrderId(), order.getUser(), productList);
        orders.put(orderId, order);
        System.out.println("Order updated successfully.");

    }

    private boolean processPayment(double amount) {
        return amount <= 1000;
    }

}
