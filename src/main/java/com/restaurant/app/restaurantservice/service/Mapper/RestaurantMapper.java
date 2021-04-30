package com.restaurant.app.restaurantservice.service.Mapper;

import com.restaurant.app.restaurantservice.domain.Chef;
import com.restaurant.app.restaurantservice.domain.Cusine;
import com.restaurant.app.restaurantservice.domain.Restaurant;
import com.restaurant.app.restaurantservice.dto.ChefDto;
import com.restaurant.app.restaurantservice.dto.RestaurantDto;


import java.util.ArrayList;
import java.util.List;

public class RestaurantMapper {

    public RestaurantMapper() {
    }

    public RestaurantDto restaurantToRestaurantDto(Restaurant restaurant) {
        if (restaurant == null) {
            return null;
        }

        RestaurantDto restaurantDto = new RestaurantDto();

        restaurantDto.setRestaurant_id(restaurant.getId());
        restaurantDto.setRestaurant_name(restaurant.getName());
        restaurantDto.setRestaurant_rating(restaurant.getRating());
        restaurantDto.setRestaurant_city(restaurant.getCity());
        restaurantDto.setRestaurant_province(restaurant.getProvince());
        restaurantDto.setRestaurant_chefs(chefListToChefDtoList(restaurant.getChefs()));
        restaurantDto.setRestaurant_cusines(cusineListToStringList(restaurant.getCusines()));

        return restaurantDto;
    }


    public Restaurant restaurantDtoToRestaurant(RestaurantDto restaurantDto) {
        if (restaurantDto == null) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setName(restaurantDto.getRestaurant_name());
        restaurant.setRating(restaurantDto.getRestaurant_rating());
        restaurant.setCity(restaurantDto.getRestaurant_city());
        restaurant.setProvince(restaurantDto.getRestaurant_province());
        chefDtoListToChefList(restaurantDto.getRestaurant_chefs()).forEach(chef -> {
            restaurant.addChef(chef);
        });
        stringListToCusineList(restaurantDto.getRestaurant_cusines()).forEach(cusine -> {
            restaurant.addCusine(cusine);
        });

        return restaurant;
    }


    public ChefDto chefToChefDto(Chef chef) {
        if (chef == null) {
            return null;
        }

        ChefDto chefDto = new ChefDto();

        chefDto.setChef_name(chef.getName());
        chefDto.setChef_salary(chef.getSalary());
        chefDto.setChef_cusines(cusineListToStringList(chef.getCusines()));

        return chefDto;
    }


    public Chef chefDtoToChef(ChefDto chefDto) {
        if (chefDto == null) {
            return null;
        }

        Chef chef = new Chef();

        chef.setName(chefDto.getChef_name());
        chef.setSalary(chefDto.getChef_salary());
        stringListToCusineList(chefDto.getChef_cusines()).forEach(cusine -> {
            chef.addCusine(cusine);
        });

        return chef;
    }

    protected List<ChefDto> chefListToChefDtoList(List<Chef> list) {
        if (list == null) {
            return null;
        }

        List<ChefDto> chefDtoList = new ArrayList<ChefDto>(list.size());
        for (Chef chef : list) {
            chefDtoList.add(chefToChefDto(chef));
        }

        return chefDtoList;
    }

    protected List<String> cusineListToStringList(List<Cusine> cusineList) {
        if (cusineList == null) {
            return null;
        }

        List<String> list = new ArrayList<String>(cusineList.size());
        for (Cusine cusine : cusineList) {
            list.add(fromCusine(cusine));
        }

        return list;
    }

    public List<Chef> chefDtoListToChefList(List<ChefDto> list) {
        if (list == null) {
            return null;
        }

        List<Chef> chefList = new ArrayList<Chef>(list.size());
        for (ChefDto chefDto : list) {
            chefList.add(chefDtoToChef(chefDto));
        }

        return chefList;
    }

    public List<Cusine> stringListToCusineList(List<String> list) {
        if (list == null) {
            return null;
        }

        List<Cusine> cusineList = new ArrayList<Cusine>(list.size());
        for (String string : list) {
            cusineList.add(fromStringToCusine(string));
        }

        return cusineList;
    }

    protected String fromCusine(Cusine cusine) {
        return cusine == null ? "" : cusine.getName();
    }

    protected Cusine fromStringToCusine(String cusine) {
        return new Cusine(cusine);
    }


}
