package com.restaurant.app.restaurantservice;

import static org.assertj.core.api.Assertions.assertThat;

import com.restaurant.app.restaurantservice.controller.ChefController;
import com.restaurant.app.restaurantservice.controller.RestaurantController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest
class RestaurantServiceApplicationTests {

    @Autowired
    RestaurantController restaurantController;

    @Autowired
    ChefController chefController;


    @Test
    void contextLoads() {
        assertThat(restaurantController).isNotNull();
        assertThat(chefController).isNotNull();
    }

}
