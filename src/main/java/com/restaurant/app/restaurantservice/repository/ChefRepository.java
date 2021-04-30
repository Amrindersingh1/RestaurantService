package com.restaurant.app.restaurantservice.repository;

import com.restaurant.app.restaurantservice.domain.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChefRepository extends JpaRepository<Chef, Long>, JpaSpecificationExecutor<Chef> {
}
