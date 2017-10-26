/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

//    @Autowired
//    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
      //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCreate() throws Exception {

        //this.mockMvc.perform(get("/user")).andExpect(status().isOk());
                //.andExpect(jsonPath("$.content").value("Hello, World!"));
    }

//    @MockBean
//    private UserVehicleService userVehicleService;
//
//    @Test
//    public void testExample() throws Exception {
//        given(this.userVehicleService.getVehicleDetails("sboot"))
//                .willReturn(new VehicleDetails("Honda", "Civic"));
//        this.mvc.perform(get("/sboot/vehicle").accept(MediaType.TEXT_PLAIN))
//                .andExpect(status().isOk()).andExpect(content().string("Honda Civic"));
//    }


    /*
    private RequestBuilder get(String s) {
    }
    /*
    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/user").param("name", "Spring Community"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
    }*/

}
