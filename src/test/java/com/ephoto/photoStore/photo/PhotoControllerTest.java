package com.ephoto.photoStore.photo;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = PhotoController.class)
class PhotoControllerTest {

    @MockBean
    PhotoList photoList;

    @Autowired
    MockMvc mockMvc;

    @Test
    void displayTitleOfPhoto() throws Exception {
        PhotoItem dachshund = new PhotoItem();
        dachshund.setTitle("Dachshund");
        dachshund.setPrice(BigDecimal.TEN);
        when(this.photoList.getAll()).thenReturn(List.of(dachshund));
        mockMvc.perform(get("/"))
                .andExpect(content().string(containsString("Dachshund")));
    }

    @Test
    void displayPriceOfPhoto() throws Exception {
        PhotoItem dachshund = new PhotoItem();
        dachshund.setTitle("Dachshund");
        dachshund.setPrice(BigDecimal.valueOf(25));
        when(this.photoList.getAll()).thenReturn(List.of(dachshund));
        mockMvc.perform(get("/"))
                .andExpect(content().string(containsString("$25")));
    }
}