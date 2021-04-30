package com.restaurant.app.restaurantservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.app.restaurantservice.controller.RestaurantController;
import com.restaurant.app.restaurantservice.domain.Chef;
import com.restaurant.app.restaurantservice.dto.ChefDto;
import com.restaurant.app.restaurantservice.dto.ResponseDto;
import com.restaurant.app.restaurantservice.dto.RestaurantDto;
import com.restaurant.app.restaurantservice.exception.NotFoundException;
import com.restaurant.app.restaurantservice.service.RestaurantService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.restaurant.app.restaurantservice.TestUtil.getInValidRestaurantDto;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestaurantController.class)
class RestaurantControllerTest {

    public static final String POST = "post";
    public static final String PUT = "put";
    public static final String DELETE = "delete";
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    RestaurantService restaurantService;

    @Test
    void getRestaurantById() throws Exception {

        given(restaurantService.getRestaurantById(anyLong())).willReturn(TestUtil.getValidRestaurantDto());

        mockMvc.perform(get("/api/v1/restaurants/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tim")));

    }

    @Test
    void getRestaurants() throws Exception {

        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        restaurantDtos.add(TestUtil.getValidRestaurantDto());
        given(restaurantService.getRestaurants(null,null, null, null, null)).willReturn(restaurantDtos);

        mockMvc.perform(get("/api/v1/restaurants").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tim")));

    }

    @Test
    void getRestaurantsByQueryParams() throws Exception {

        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        restaurantDtos.add(TestUtil.getValidRestaurantDto());
        given(restaurantService.getRestaurants(any(),any(), any(), any(), any())).willReturn(restaurantDtos);

        mockMvc.perform(get("/api/v1/restaurants?restaurant_name=Tim&restaurant_cusine=breakfast&restaurant_rating=8&restaurant_city=Toronto&restaurant_province=ON").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Tim")));

    }

    @Test
    void saveNewRestaurant() throws Exception {

        RestaurantDto restaurantDto = TestUtil.getValidRestaurantDto();
        String restaurantDtoJson = objectMapper.writeValueAsString(restaurantDto);

        given(restaurantService.saveNewRestaurant(any())).willReturn(TestUtil.getResponseDto(POST));

        mockMvc.perform(post("/api/v1/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(restaurantDtoJson))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("create_date")));
    }

    @Test
    void saveNewInvalidRestaurant() throws Exception {

        RestaurantDto restaurantDto = getInValidRestaurantDto();
        String restaurantDtoJson = objectMapper.writeValueAsString(restaurantDto);

        given(restaurantService.saveNewRestaurant(any())).willReturn(TestUtil.getResponseDto(POST));

        mockMvc.perform(post("/api/v1/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(restaurantDtoJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("com.restaurantservice.request.body.invalid")));;
    }

    @Test
    void updateRestaurantById() throws Exception {

        ResponseDto responseDto = TestUtil.getResponseDto(PUT);
        given(restaurantService.updateRestaurantById(anyLong(), any())).willReturn(responseDto);

        RestaurantDto restaurantDto = TestUtil.getValidRestaurantDto();
        String restaurantDtoJson = objectMapper.writeValueAsString(restaurantDto);

        mockMvc.perform(put("/api/v1/restaurants/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(restaurantDtoJson))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("update_date")));;
    }

    @Test
    void updateRestaurantByInvalidId() throws Exception {

        given(restaurantService.updateRestaurantById(anyLong(), any())).willThrow(new NotFoundException(1));

        RestaurantDto restaurantDto = TestUtil.getValidRestaurantDto();
        String restaurantDtoJson = objectMapper.writeValueAsString(restaurantDto);

        mockMvc.perform(put("/api/v1/restaurants/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(restaurantDtoJson))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteRestaurantById() throws Exception {

        given(restaurantService.deleteRestaurantById(anyLong())).willReturn(TestUtil.getResponseDto(DELETE));


        mockMvc.perform(delete("/api/v1/restaurants/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("delete_date")));
    }

    @Test
    void deleteRestaurantByInvalidId() throws Exception {

        given(restaurantService.deleteRestaurantById(anyLong())).willThrow(new NotFoundException(1));


        mockMvc.perform(delete("/api/v1/restaurants/1"))
                .andExpect(status().isNotFound());
    }


}