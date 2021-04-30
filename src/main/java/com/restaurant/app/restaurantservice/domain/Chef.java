package com.restaurant.app.restaurantservice.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Chef {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cusine> cusines = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    private String name;

    private double salary;

    public Chef() {
    }

    public Chef(long id, String name, double salary, List<Cusine> cusines) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.cusines = cusines;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Cusine> getCusines() {
        return cusines;
    }

    public void setCusines(List<Cusine> cusines) {
        this.cusines = cusines;
    }

    public void addCusine(Cusine cusine) {
        cusine.setChef(this);
        this.cusines.add(cusine);
    }

    public void removeCusine(Cusine cusine) {
        cusine.setChef(null);
        this.cusines.remove(cusine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chef chef = (Chef) o;
        return id == chef.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}
