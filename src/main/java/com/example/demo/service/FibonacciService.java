package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Fibonacci;

public interface FibonacciService {

	public Fibonacci getFibonacci(Long input);

	public List<Integer> getMostRequestedInput();

}
