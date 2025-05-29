package com.example.xueyin.springbootdemo.demos.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BasicController.class)
public class BasicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloWithDefaultName() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello unknown user"));
    }

    @Test
    public void testHelloWithCustomName() throws Exception {
        mockMvc.perform(get("/hello").param("name", "John"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello John"));
    }

    @Test
    public void testUser() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("theonefx"))
                .andExpect(jsonPath("$.age").value(666));
    }

    @Test
    public void testSaveUser() throws Exception {
        mockMvc.perform(get("/save_user")
                .param("name", "John")
                .param("age", "25"))
                .andExpect(status().isOk())
                .andExpect(content().string("user will save: name=John, age=25"));
    }

    @Test
    public void testSaveUserWithoutParams() throws Exception {
        mockMvc.perform(get("/save_user"))
                .andExpect(status().isOk())
                .andExpect(content().string("user will save: name=zhangsan, age=18"));
    }

    @Test
    public void testHtml() throws Exception {
        mockMvc.perform(get("/html"))
                .andExpect(status().isOk())
                .andExpect(view().name("index.html"));
    }

    @Test
    public void testParseUser() throws Exception {
        mockMvc.perform(get("/save_user")
                .param("name", "test")
                .param("age", "30"))
                .andExpect(status().isOk())
                .andExpect(content().string("user will save: name=test, age=30"));
    }
}
