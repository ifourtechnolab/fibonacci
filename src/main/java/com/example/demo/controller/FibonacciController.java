package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fibonacci;
import com.example.demo.service.FibonacciService;

@RestController
public class FibonacciController {

	@Autowired
	private FibonacciService fibonacciService;

	@GetMapping("/Fibonacci/{id}")
	public Fibonacci calculateFibonacciController(@PathVariable("id") Long input) {
		return fibonacciService.getFibonacci(input);
	}

	@GetMapping("/Fibonacci/mc")
	public List<Integer> getMostRequestedInput() {

		return fibonacciService.getMostRequestedInput();
	}
}
