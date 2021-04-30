package com.restaurant.app.restaurantservice.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class ChefDto implements Serializable {

    static final long serialVersionUID = -1234566940065581210L;

    @NotBlank
    private String chef_name;

    @NotNull
    private double chef_salary;

    @NotNull
    @Valid
    private List<String> chef_cusines;

    public ChefDto() {
    }

    public ChefDto(String chef_name, double chef_salary, List<String> chef_cusines) {
        this.chef_name = chef_name;
        this.chef_salary = chef_salary;
        this.chef_cusines = chef_cusines;
    }


    public String getChef_name() {
        return chef_name;
    }

    public void setChef_name(String chef_name) {
        this.chef_name = chef_name;
    }

    public double getChef_salary() {
        return chef_salary;
    }

    public void setChef_salary(double chef_salary) {
        this.chef_salary = chef_salary;
    }

    public List<String> getChef_cusines() {
        return chef_cusines;
    }

    public void setChef_cusines(List<String> chef_cusines) {
        this.chef_cusines = chef_cusines;
    }
}
