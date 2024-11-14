package org.neoteric.java.Service;

import org.neoteric.java.Exceptions.OutOfStockException;
import org.neoteric.java.model.Product;

public abstract class ProductService extends Product {

    public ProductService(String productId, String name, double price, int stock) {
         super(productId,name,price,stock);
    }

    public void reduceStock(int quantity) throws OutOfStockException {
        if (quantity > getStock()) {
            throw new OutOfStockException("Stock not available for "+getName());
        }
       // System.out.println(getStock());
        setStock(getStock()-quantity);
    }

    public abstract String getCategory();

}
