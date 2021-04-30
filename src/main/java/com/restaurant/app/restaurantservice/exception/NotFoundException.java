package com.restaurant.app.restaurantservice.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(long restaurantId) {
        super("Restaurant with id : " + restaurantId + " doesn't exist.");
    }
}
