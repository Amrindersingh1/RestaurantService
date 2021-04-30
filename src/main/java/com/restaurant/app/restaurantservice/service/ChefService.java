package com.restaurant.app.restaurantservice.service;

import com.restaurant.app.restaurantservice.domain.Chef;
import com.restaurant.app.restaurantservice.domain.Restaurant;
import com.restaurant.app.restaurantservice.dto.ChefDto;
import com.restaurant.app.restaurantservice.dto.RestaurantDto;
import com.restaurant.app.restaurantservice.repository.ChefRepository;
import com.restaurant.app.restaurantservice.repository.RestaurantRepository;
import com.restaurant.app.restaurantservice.service.Mapper.RestaurantMapper;
import com.restaurant.app.restaurantservice.service.specifications.ChefSpecification;
import com.restaurant.app.restaurantservice.service.specifications.RestaurantSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChefService implements IChefService{

    private final ChefRepository chefRepository;
    private final RestaurantMapper restaurantMapper;

    public ChefService(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
        this.restaurantMapper = new RestaurantMapper();
    }

    @Override
    public List<ChefDto> getChefs(Long restaurant_id, String name, String cusine) {

        List<ChefDto> chefDtoList = new ArrayList<>();

        List<Specification> specifications = new ArrayList<>();

        if(name!=null && !name.isEmpty()) {
            specifications.add(ChefSpecification.nameEquals(name));
        }
        if(cusine!=null && !cusine.isEmpty()) {
            specifications.add(ChefSpecification.cusineEquals(cusine));
        }
        if(restaurant_id!=null) {
            specifications.add(ChefSpecification.restaurantIdEquals(restaurant_id));
        }

        Specification result = null;
        if(specifications.size()>0) {
            result = specifications.get(0);
            for (int i = 1; i < specifications.size(); i++) {
                result.and(specifications.get(i));
            }
        }

        List<Chef> chefs = result==null?chefRepository.findAll():chefRepository.findAll(result);

        for(Chef chef : chefs) {
            chefDtoList.add(restaurantMapper.chefToChefDto(chef));
        }
        return chefDtoList;
    }
}
