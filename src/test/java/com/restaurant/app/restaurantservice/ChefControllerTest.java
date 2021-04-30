package com.restaurant.app.restaurantservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.app.restaurantservice.controller.ChefController;
import com.restaurant.app.restaurantservice.dto.ChefDto;
import com.restaurant.app.restaurantservice.service.ChefService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(ChefController.class)
class ChefControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ChefService chefService;


    @Test
    public void getChefs() throws Exception {
        given(chefService.getChefs(any(), any(), any())).willReturn(getValidChefDto());

        mockMvc.perform(get("/api/v1/chefs").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("chefA")));
    }



    private List<ChefDto> getValidChefDto() {
        ChefDto chefDto = new ChefDto("chefA", 5000, Arrays.asList(new String[]{"fast food", "breakfast"}));
        return Arrays.asList(new ChefDto[]{chefDto});
    }
}
