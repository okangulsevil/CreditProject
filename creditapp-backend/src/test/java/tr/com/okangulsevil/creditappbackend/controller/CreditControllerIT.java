package tr.com.okangulsevil.creditappbackend.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import tr.com.okangulsevil.creditappbackend.IntegrationTestSupport;
import tr.com.okangulsevil.creditappbackend.model.Credit;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CreditControllerIT extends IntegrationTestSupport {

    private final String URL = "/v1/credits/";

    @AfterEach
    void tearDown() {
        creditRepository.deleteAll();
    }

    @Test
    public void testGetAllCredits_shouldReturnEmptyList() throws Exception {

        this.mockMvc.perform(get(URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        List<Credit> creditFromDb = creditRepository.findAll();
        assertEquals(0, creditFromDb.size());
    }
}
