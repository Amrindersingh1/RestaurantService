package com.restaurant.app.restaurantservice;

import com.restaurant.app.restaurantservice.domain.Chef;
import com.restaurant.app.restaurantservice.domain.Cusine;
import com.restaurant.app.restaurantservice.domain.Restaurant;
import com.restaurant.app.restaurantservice.dto.ChefDto;
import com.restaurant.app.restaurantservice.dto.RestaurantDto;
import com.restaurant.app.restaurantservice.service.Mapper.RestaurantMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestaurantMapperTest {

    RestaurantMapper restaurantMapper = new RestaurantMapper();

    @Test
    public void restaurantMapperTest() {

        RestaurantDto restaurantDto = TestUtil.getValidRestaurantDto();
        Restaurant restaurant = restaurantMapper.restaurantDtoToRestaurant(restaurantDto);
        RestaurantDto mappedRestaurantDto = restaurantMapper.restaurantToRestaurantDto(restaurant);

        assertEquals(restaurantDto.getRestaurant_name(), mappedRestaurantDto.getRestaurant_name());
        assertEquals(restaurantDto.getRestaurant_city(), mappedRestaurantDto.getRestaurant_city());
        assertEquals(restaurantDto.getRestaurant_province(), mappedRestaurantDto.getRestaurant_province());
        assertEquals(restaurantDto.getRestaurant_rating(), mappedRestaurantDto.getRestaurant_rating());

    }

    @Test
    public void chefMapperTest() {

        ChefDto chefDto = new ChefDto("chefA", 5000, Arrays.asList(new String[]{"fast food", "breakfast"}));
        Chef chef = restaurantMapper.chefDtoToChef(chefDto);
        ChefDto mappedChefDto = restaurantMapper.chefToChefDto(chef);

        assertEquals(chefDto.getChef_name(), mappedChefDto.getChef_name());
        assertEquals(chefDto.getChef_salary(), mappedChefDto.getChef_salary());

    }


}
