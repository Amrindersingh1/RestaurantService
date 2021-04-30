package com.restaurant.app.restaurantservice.service;

import com.restaurant.app.restaurantservice.domain.*;
import com.restaurant.app.restaurantservice.dto.ResponseDto;
import com.restaurant.app.restaurantservice.dto.RestaurantDto;
import com.restaurant.app.restaurantservice.exception.NotFoundException;
import com.restaurant.app.restaurantservice.repository.RestaurantRepository;
import com.restaurant.app.restaurantservice.service.Mapper.RestaurantMapper;
import com.restaurant.app.restaurantservice.service.specifications.RestaurantSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService implements IRestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = new RestaurantMapper();
    }

    public ResponseDto saveNewRestaurant(RestaurantDto restaurantDto) {

        Restaurant restaurant = restaurantMapper.restaurantDtoToRestaurant(restaurantDto);
        restaurant = restaurantRepository.save(restaurant);

        ResponseDto response = new ResponseDto();
        response.setRestaurant_id(restaurant.getId());
        response.setCreate_date(getCurrentDate());

        return response;
    }

    @Override
    public RestaurantDto getRestaurantById(long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById((restaurantId)).orElseThrow(() -> new NotFoundException(restaurantId));

        return restaurantMapper.restaurantToRestaurantDto(restaurant);
    }

    @Override
    public List<RestaurantDto> getRestaurants(String restaurant_name, String restaurant_city, String restaurant_cusine, String restaurant_province, Double restaurant_rating) {

        List<RestaurantDto> restaurantDtoList = new ArrayList<>();

        List<Specification> specifications = new ArrayList<>();

        if(restaurant_name!=null && !restaurant_name.isEmpty()) {
            specifications.add(RestaurantSpecification.nameEquals(restaurant_name));
        }
        if(restaurant_city!=null && !restaurant_city.isEmpty()) {
            specifications.add(RestaurantSpecification.cityEquals(restaurant_city));
        }
        if(restaurant_province!=null && !restaurant_province.isEmpty()) {
            specifications.add(RestaurantSpecification.provinceEquals(restaurant_province));
        }
        if(restaurant_rating!=null) {
            specifications.add(RestaurantSpecification.ratingEquals(restaurant_rating));
        }
        if(restaurant_cusine!=null && !restaurant_cusine.isEmpty()) {
            specifications.add(RestaurantSpecification.cusineEquals(restaurant_cusine));
        }

        Specification result = null;
        if(specifications.size()>0) {
            result = specifications.get(0);
            for (int i = 1; i < specifications.size(); i++) {
                result.and(specifications.get(i));
            }
        }

        List<Restaurant> restaurants = result==null?restaurantRepository.findAll():restaurantRepository.findAll(result);

        for(Restaurant restaurant : restaurants) {
            restaurantDtoList.add(restaurantMapper.restaurantToRestaurantDto(restaurant));
        }
        return restaurantDtoList;
    }

    @Override
    public ResponseDto updateRestaurantById(long restaurantId, RestaurantDto restaurantDto) {

        Restaurant restaurant = restaurantRepository.findById((restaurantId)).orElseThrow(() -> new NotFoundException(restaurantId));

        restaurant.setName(restaurantDto.getRestaurant_name());
        restaurant.setCity(restaurantDto.getRestaurant_city());
        restaurant.setProvince(restaurantDto.getRestaurant_province());
        restaurant.setRating(restaurantDto.getRestaurant_rating());

        restaurant.getChefs().clear();
        restaurant.getCusines().clear();

        List<Chef> newChefList = restaurantMapper.chefDtoListToChefList(restaurantDto.getRestaurant_chefs());
        for(Chef chef : newChefList) {
            restaurant.addChef(chef);
        }

        List<Cusine> newCusineList = restaurantMapper.stringListToCusineList(restaurantDto.getRestaurant_cusines());
        for(Cusine cusine : newCusineList) {
            restaurant.addCusine(cusine);
        }


        restaurant = restaurantRepository.save(restaurant);

        ResponseDto response = new ResponseDto();
        response.setRestaurant_id(restaurant.getId());
        response.setUpdate_date(getCurrentDate());

        return response;

    }

    @Override
    public ResponseDto deleteRestaurantById(long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById((restaurantId)).orElseThrow(() -> new NotFoundException(restaurantId));
        restaurantRepository.deleteById(restaurantId);

        ResponseDto response = new ResponseDto();
        response.setRestaurant_id(restaurant.getId());
        response.setDelete_date(getCurrentDate());

        return response;
    }

    private LocalDateTime getCurrentDate() {
        LocalDateTime now= LocalDateTime.now();;
        return now;
    }

}
