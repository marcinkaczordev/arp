package arp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GridControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void exampleTest() throws Exception {
//        this.mvc.perform(get("/")).andExpect(status().isOk())
//                .andExpect(content().string("Hello World"));
    }

}