package tr.com.okangulsevil.creditappbackend.controller;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import tr.com.okangulsevil.creditappbackend.IntegrationTestSupport;
import tr.com.okangulsevil.creditappbackend.model.User;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerIT extends IntegrationTestSupport {

    private final String URL = "/v1/users/";

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    public void testGetAllUsers_shouldReturnEmptyList() throws Exception{
        this.mockMvc.perform(get(URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        List<User> userFromDb = userRepository.findAll();
        assertEquals(0, userFromDb.size());
    }

    @Test
    public void testGetAllUsers_shouldReturnUserDtoList() throws Exception {

        userRepository.save(generateUser());

        this.mockMvc.perform(get(URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        List<User> userFromDb = userRepository.findAll();
        assertEquals(1, userFromDb.size());
    }

    @Test
    public void testGetUserById_whenCalledValidId_shouldReturnUserDto() throws Exception {

        User user = userRepository.save(generateUser());

        this.mockMvc.perform(get(URL + user.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(new MediaType("application", "hal+json")))
                .andExpect(jsonPath("$.id", is(user.getId())))
                .andExpect(jsonPath("$.firstName", is(user.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(user.getLastName())))
                .andExpect(jsonPath("$.identityNumber", is(user.getIdentityNumber())))
                .andExpect(jsonPath("$.phoneNumber", is(user.getPhoneNumber())));

        User userFromDb = userRepository.findById(user.getId()).get();
        assertEquals(user, userFromDb);
    }

    @Test
    public void testGetUserById_whenCalledInvalidId_shouldReturnNotFoundException() throws Exception {

        this.mockMvc.perform(get(URL + "not-valid-id")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
