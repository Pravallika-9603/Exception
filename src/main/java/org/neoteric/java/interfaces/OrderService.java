package org.neoteric.java.interfaces;

import org.neoteric.java.Exceptions.InvalidOrderException;
import org.neoteric.java.Exceptions.PaymentFailureException;
import org.neoteric.java.model.Order;
import org.neoteric.java.model.Product;

import java.util.List;

public interface OrderService {

    void placeOrder(Order order) throws InvalidOrderException, PaymentFailureException;;

    void cancelOrder(String orderId) throws InvalidOrderException;

    void updateOrder(String orderId, List<Product> productList) throws InvalidOrderException;

}
