package com.restaurant.app.restaurantservice.controller;

import com.restaurant.app.restaurantservice.dto.RestaurantDto;
import com.restaurant.app.restaurantservice.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @GetMapping("restaurants")
    public ResponseEntity<List<RestaurantDto>> getRestaurants(@RequestParam(value = "restaurant_name", required = false) String restaurant_name,
                                                              @RequestParam(value = "restaurant_cusine", required = false) String restaurant_cusine,
                                                              @RequestParam(value = "restaurant_rating", required = false) Double restaurant_rating,
                                                              @RequestParam(value = "restaurant_city", required = false) String restaurant_city,
                                                              @RequestParam(value = "restaurant_province", required = false) String restaurant_province) {
        return new ResponseEntity<>(restaurantService.getRestaurants(restaurant_name, restaurant_city, restaurant_cusine, restaurant_province, restaurant_rating), HttpStatus.OK);
    }


    @GetMapping("restaurants/{restaurantId}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable("restaurantId") long restaurantId ) {

        return new ResponseEntity<RestaurantDto>(restaurantService.getRestaurantById(restaurantId), HttpStatus.OK);
    }


    @PostMapping("restaurants")
    ResponseEntity saveNewRestaurant(@RequestBody @Validated RestaurantDto restaurantDto) {

        return new ResponseEntity(restaurantService.saveNewRestaurant(restaurantDto), HttpStatus.CREATED);

    }


    @PutMapping("restaurants/{restaurantId}")
    public ResponseEntity updateRestaurant(@PathVariable("restaurantId") long restaurantId, @RequestBody @Validated RestaurantDto restaurantDto ) {

        return new ResponseEntity(restaurantService.updateRestaurantById(restaurantId, restaurantDto), HttpStatus.OK);
    }


    @DeleteMapping("restaurants/{restaurantId}")
    public ResponseEntity deleteRestaurant(@PathVariable("restaurantId") long restaurantId) {

        return new ResponseEntity<>(restaurantService.deleteRestaurantById(restaurantId), HttpStatus.OK);
    }

}
