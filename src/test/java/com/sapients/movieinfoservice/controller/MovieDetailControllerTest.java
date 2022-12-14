package com.sapients.movieinfoservice.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MovieDetailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPlanetSearch() throws Exception {
        String api = "/movieInfo/planet?search=Yavin IV";

     //   mockMvc.perform(get(api))
       //         .andExpect(status().is(200))
         //       .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));

    }
}
