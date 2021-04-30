package com.restaurant.app.restaurantservice;

import com.restaurant.app.restaurantservice.dto.ChefDto;
import com.restaurant.app.restaurantservice.dto.ResponseDto;
import com.restaurant.app.restaurantservice.dto.RestaurantDto;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TestUtil {

    public static final String POST = "post";
    public static final String PUT = "put";
    public static final String DELETE = "delete";

    public static  ResponseDto getResponseDto(String type) {

        ResponseDto responseDto = new ResponseDto();
        responseDto.setRestaurant_id(1);
        switch (type) {
            case POST:
                responseDto.setCreate_date(LocalDateTime.now());
                break;
            case PUT:
                responseDto.setUpdate_date(LocalDateTime.now());
                break;
            case DELETE:
                responseDto.setDelete_date(LocalDateTime.now());
                break;
            default:
                break;
        }
        return responseDto;

    }

    public static  RestaurantDto getValidRestaurantDto(){

        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setRestaurant_name("Tim");
        restaurantDto.setRestaurant_city("Toronto");
        restaurantDto.setRestaurant_cusines(Arrays.asList(new String[]{"fast food", "breakfast"}));
        restaurantDto.setRestaurant_id(1);
        restaurantDto.setRestaurant_rating(7);
        restaurantDto.setRestaurant_province("ON");

        ChefDto chefDto = new ChefDto("chefA", 5000, Arrays.asList(new String[]{"fast food", "breakfast"}));
        restaurantDto.setRestaurant_chefs(Arrays.asList(new ChefDto[]{chefDto}));

        return restaurantDto;
    }

    public static  RestaurantDto getInValidRestaurantDto(){

        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setRestaurant_name("");
        restaurantDto.setRestaurant_city(null);
        restaurantDto.setRestaurant_cusines(null);
        restaurantDto.setRestaurant_id(1);
        restaurantDto.setRestaurant_rating(37);
        restaurantDto.setRestaurant_province("");

        return restaurantDto;
    }
}
