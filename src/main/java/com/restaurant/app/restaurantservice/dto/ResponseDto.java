package com.restaurant.app.restaurantservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

    static final long serialVersionUID = -5815512345675181210L;

    @NotBlank
    private long restaurant_id;

    @Null
    private LocalDateTime create_date;

    @Null
    private LocalDateTime update_date;

    @Null
    private LocalDateTime delete_date;

    public ResponseDto() {
    }

    public ResponseDto(@NotBlank long restaurant_id, @Null LocalDateTime create_date, @Null LocalDateTime update_date, @Null LocalDateTime delete_date) {
        this.restaurant_id = restaurant_id;
        this.create_date = create_date;
        this.update_date = update_date;
        this.delete_date = delete_date;
    }

    public long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

    public LocalDateTime getDelete_date() {
        return delete_date;
    }

    public void setDelete_date(LocalDateTime delete_date) {
        this.delete_date = delete_date;
    }
}
