package com.restaurant.app.restaurantservice.service.specifications;

import com.restaurant.app.restaurantservice.domain.Chef;
import com.restaurant.app.restaurantservice.domain.Cusine;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class ChefSpecification {

    public static Specification<Chef> nameEquals(String name){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Chef> restaurantIdEquals(long id){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.join("restaurant").get("id"), id);
        };
    }


    public static Specification<Chef> cusineEquals(String cusine){
        return (root, query, criteriaBuilder)
                -> {
            Join<Chef, Cusine> cusines = root.join("cusines", JoinType.LEFT);
            return criteriaBuilder.equal(cusines.get("name"), cusine);
        };
    }
    
}
