package com.UST.StateMapping.controller;

import com.UST.StateMapping.entity.District;
import com.UST.StateMapping.service.DistrictService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DistrictController.class)
class DistrictControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DistrictService mockDistrictService;

    @Test
    void testGetAllDistrictsByState() throws Exception {
        // Setup
        // Configure DistrictService.getAllDistrictsByState(...).
        final List<District> districts = List.of(new District("state", "district"));
        when(mockDistrictService.getAllDistrictsByState("state")).thenReturn(districts);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/districts/{state}", "state")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetAllDistrictsByState_DistrictServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockDistrictService.getAllDistrictsByState("state")).thenReturn(Collections.emptyList());

        // Run the test
        District districts = null;
        final MockHttpServletResponse response = mockMvc.perform(get("/districts/{state}", "state")
                        .content(asJsonString(districts)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }
    private String asJsonString(District districts){
        try{
            return new ObjectMapper().writeValueAsString(districts);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
