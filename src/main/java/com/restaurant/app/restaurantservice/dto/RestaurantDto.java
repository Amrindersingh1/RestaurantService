package com.restaurant.app.restaurantservice.dto;


import com.restaurant.app.restaurantservice.domain.Chef;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;


public class RestaurantDto implements Serializable {

    static final long serialVersionUID = -5815566940065181210L;

    private long restaurant_id;

    @NotBlank
    private String restaurant_name;

    @NotNull
    @Valid
    private List<String> restaurant_cusines;

    @NotNull
    @Valid
    private List<ChefDto> restaurant_chefs;

    @NotNull
    @Min(0)
    @Max(10)
    private double restaurant_rating;

    @NotBlank
    private String restaurant_city;

    @NotBlank
    private String restaurant_province;

    public RestaurantDto() {
    }

    public RestaurantDto(long restaurant_id, String restaurant_name, List<String> restaurant_cusines, List<ChefDto> restaurant_chefs, double restaurant_rating, String restaurant_city, String restaurant_province) {
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.restaurant_cusines = restaurant_cusines;
        this.restaurant_chefs = restaurant_chefs;
        this.restaurant_rating = restaurant_rating;
        this.restaurant_city = restaurant_city;
        this.restaurant_province = restaurant_province;
    }

    public long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public List<String> getRestaurant_cusines() {
        return restaurant_cusines;
    }

    public void setRestaurant_cusines(List<String> restaurant_cusines) {
        this.restaurant_cusines = restaurant_cusines;
    }

    public List<ChefDto> getRestaurant_chefs() {
        return restaurant_chefs;
    }

    public void setRestaurant_chefs(List<ChefDto> restaurant_chefs) {
        this.restaurant_chefs = restaurant_chefs;
    }

    public double getRestaurant_rating() {
        return restaurant_rating;
    }

    public void setRestaurant_rating(double restaurant_rating) {
        this.restaurant_rating = restaurant_rating;
    }

    public String getRestaurant_city() {
        return restaurant_city;
    }

    public void setRestaurant_city(String restaurant_city) {
        this.restaurant_city = restaurant_city;
    }

    public String getRestaurant_province() {
        return restaurant_province;
    }

    public void setRestaurant_province(String restaurant_province) {
        this.restaurant_province = restaurant_province;
    }


}
