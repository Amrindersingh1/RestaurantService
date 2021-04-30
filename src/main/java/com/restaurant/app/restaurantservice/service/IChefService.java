package com.restaurant.app.restaurantservice.service;

import com.restaurant.app.restaurantservice.dto.ChefDto;
import com.restaurant.app.restaurantservice.dto.RestaurantDto;

import java.util.List;

public interface IChefService {

    List<ChefDto> getChefs(Long restaurant_id, String name, String cusine);

}
