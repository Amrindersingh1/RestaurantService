package com.restaurant.app.restaurantservice.controller;

import com.restaurant.app.restaurantservice.dto.ChefDto;
import com.restaurant.app.restaurantservice.service.ChefService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ChefController {

    private final com.restaurant.app.restaurantservice.service.ChefService ChefService;

    public ChefController(ChefService ChefService) {
        this.ChefService = ChefService;
    }


    @GetMapping("chefs")
    public ResponseEntity<List<ChefDto>> getChefs(@RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(value = "cusine", required = false) String cusine,
                                                  @RequestParam(value = "restaurant_id", required = false) Long restaurant_id) {
        return new ResponseEntity<>(ChefService.getChefs(restaurant_id, name, cusine), HttpStatus.OK);
    }
}
