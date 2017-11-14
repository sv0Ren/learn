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
import constants.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    private static final String ID = "1337";
    private static final String FIRSTNAME = "FIRSTNAME";
    private static final String LASTNAME = "LASTNAME";
    private static final String MAIL = "MAIL@alla.com";

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
    public void testGetWithBody() throws Exception {
        userService.save(user);

        this.mockMvc.perform(get("/user/id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstName").value(FIRSTNAME))
                .andExpect(jsonPath("lastName").value(LASTNAME));

        userService.delete(user);
    }

    @Test
    public void testGetByTypAndIdentifier() throws Exception {
        user.setMail(MAIL);
        userService.save(user);

        this.mockMvc.perform(get("/user/"+Constants.MAIL+"/"+MAIL+"/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("firstName").value(FIRSTNAME))
                .andExpect(jsonPath("lastName").value(LASTNAME));

        userService.delete(user);
    }

    @Test
    public void testGetById() throws Exception {
        userService.save(user);

        this.mockMvc.perform(get("/user/id/"+ID))
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
    public void testDeleteByID() throws Exception {
        userService.save(user);

        this.mockMvc.perform(delete("/user/"+ID))
                .andExpect(status().isOk());

    }

    @Test
    public void testDelete() throws Exception {
        userService.save(user);

        this.mockMvc.perform(delete("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

    }

    @Test
    public void testUpdate() throws Exception {
        userService.save(user);
        //user.setMail(MAIL);
        user.firstName = "lala";

        this.mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

        User updatedUser = userService.findByFirstName("lala");
        //User updatedUser2 = userService.findByMail(MAIL);

        Assert.assertEquals(updatedUser.firstName,"lala");

        userService.delete(updatedUser);
    }

    @Test
    public void testDelteAllUsers() throws Exception {
        userService.deleteAll();
    }

}
