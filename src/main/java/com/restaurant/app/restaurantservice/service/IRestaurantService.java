package com.restaurant.app.restaurantservice.service;

import com.restaurant.app.restaurantservice.dto.RestaurantDto;
import com.restaurant.app.restaurantservice.dto.ResponseDto;

import java.util.List;

public interface IRestaurantService {

    ResponseDto saveNewRestaurant(RestaurantDto restaurantDto);

    RestaurantDto getRestaurantById(long restaurantId);

    List<RestaurantDto> getRestaurants(String restaurant_name, String restaurant_city, String restaurant_cusine, String restaurant_province, Double restaurant_rating);

    ResponseDto updateRestaurantById(long restaurantId, RestaurantDto restaurantDto);

    ResponseDto deleteRestaurantById(long restaurantId);
}
