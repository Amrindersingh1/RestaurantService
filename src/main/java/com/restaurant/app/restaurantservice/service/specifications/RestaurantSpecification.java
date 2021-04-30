package com.restaurant.app.restaurantservice.service.specifications;

import com.restaurant.app.restaurantservice.domain.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;


public class RestaurantSpecification {

    public static Specification<Restaurant> nameEquals(String name){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Restaurant> cityEquals(String city){
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("city"), city);
    }

    public static Specification<Restaurant> provinceEquals(String province){
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("province"), province);
    }

    public static Specification<Restaurant> ratingEquals(double rating){
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("rating") , rating);
    }

    public static Specification<Restaurant> cusineEquals(String cusine){
        return (root, query, criteriaBuilder)
                -> {
            Join<Restaurant,Cusine> cusines = root.join("cusines", JoinType.LEFT);
            return criteriaBuilder.equal(cusines.get("name"), cusine);
        };
    }

}
