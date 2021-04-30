package com.restaurant.app.restaurantservice.repository;

import com.restaurant.app.restaurantservice.domain.Restaurant;
import com.restaurant.app.restaurantservice.service.specifications.RestaurantSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, JpaSpecificationExecutor<Restaurant> {

}
