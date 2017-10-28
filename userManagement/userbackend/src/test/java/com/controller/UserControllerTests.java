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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.User;
import com.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    private static final String ID = "1337";
    private static final String FIRSTNAME = "FIRSTNAME";
    private static final String LASTNAME = "LASTNAME";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    User user;

    @Before
    public void setup() {
        user = new User(ID,FIRSTNAME, LASTNAME);
    }

    @Test
    public void testGetAll() throws Exception {
        this.mockMvc.perform(get("/user"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {
        userService.save(user);

        this.mockMvc.perform(get("/user/1337"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstName").value(FIRSTNAME))
                .andExpect(jsonPath("lastName").value(LASTNAME));

        userService.delete(user);
    }

    @Test
    public void testCreate() throws Exception {
        this.mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

        userService.delete(user);
    }

    @Test
    public void testDelete() throws Exception {
        //TODO: delete test
    }

    @Test
    public void testUpdate() throws Exception {
        //TODO:
    }

    //@Test
    public void testDelteAllUsers() throws Exception {
        userService.deleteAll();
    }

}
