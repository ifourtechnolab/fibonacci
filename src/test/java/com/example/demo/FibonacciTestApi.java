package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith({ SpringExtension.class })
@SpringBootTest
@AutoConfigureMockMvc
public class FibonacciTestApi {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void inputForFibonacciTesting() throws Exception {
		// Checking API with given input
		mockMvc.perform(MockMvcRequestBuilders.get("/Fibonacci/{id}", 5).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", notNullValue()))
				.andExpect(jsonPath("$.fibonacci", is("0,1,1,2,3")));

	}

	@Test
	public void maxRequestedFibonacciInputTesting() throws Exception {
		// Checking API with given input
		mockMvc.perform(MockMvcRequestBuilders.get("/Fibonacci/{id}", "mc")).andExpect(status().isOk());

	}

}
