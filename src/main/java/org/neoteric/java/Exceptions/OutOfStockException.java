package org.neoteric.java.Exceptions;

public class OutOfStockException extends RuntimeException{

    public OutOfStockException(String message){
        super(message);
        System.out.println(" Out Of Stock Exception"+message);
    }

}
