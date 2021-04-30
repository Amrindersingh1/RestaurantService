package com.restaurant.app.restaurantservice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;

    private String name;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", orphanRemoval = true)
    private List<Cusine> cusines = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", orphanRemoval = true)
    private List<Chef> chefs = new ArrayList<>();

    private double rating;

    private String city;

    private String province;

    public Restaurant() {
    }

    public Restaurant(long id, String name, List<Cusine> cusines, List<Chef> chefs, double rating, String city, String province) {
        this.id = id;
        this.name = name;
        this.cusines = cusines;
        this.chefs = chefs;
        this.rating = rating;
        this.city = city;
        this.province = province;
    }

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double ratings) {
        this.rating = ratings;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<Cusine> getCusines() {
        return cusines;
    }

    public void setCusines(List<Cusine> cusines) {
        this.cusines = cusines;
    }

    public void addCusine(Cusine cusine) {
        cusine.setRestaurant(this);
        this.cusines.add(cusine);
    }

    public void addChef(Chef chef) {
        chef.setRestaurant(this);
        this.chefs.add(chef);
    }

    public void removeCusine(Cusine cusine) {
        cusine.setRestaurant(null);
        this.cusines.remove(cusine);
    }

    public void removeChef(Chef chef) {
        chef.setRestaurant(null);
        this.chefs.remove(chef);
    }

}
