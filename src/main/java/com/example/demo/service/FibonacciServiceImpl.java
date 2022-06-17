package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FibonacciReposetory;
import com.example.demo.model.Fibonacci;

@Service
public class FibonacciServiceImpl implements FibonacciService {

	@Autowired
	private FibonacciReposetory fibonacciReposetory;

	public Fibonacci getFibonacci(Long input) {
		// check if this exists in cache or database

		Optional<Fibonacci> findByInput = fibonacciReposetory.findByInput(input);

		if (!findByInput.isPresent()) {

			String stringSeries = generateFibonacci(input);

			// create new model
			Fibonacci fibModel = new Fibonacci(input, stringSeries, 1);

			// store the model
			fibonacciReposetory.save(fibModel);

			return fibModel;
		} else {
			Fibonacci series = findByInput.get();
			// increment the count since series got re-requested
			series.setCount(series.getCount() + 1);
			fibonacciReposetory.save(series);

			// return the series
			return series;
		}

	}

	@Override
	public List<Integer> getMostRequestedInput() {

		int findMaxCount = 0;
		try {
			findMaxCount = fibonacciReposetory.findMaxCount();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		List<Integer> mostHitsInput = fibonacciReposetory.getMostHitsInput(findMaxCount);
		return mostHitsInput;
	}

	// Generate Fibonacci
	private String generateFibonacci(Long input) {
		{
			String newS = "";
			Long n = input, firstTerm = 0L, secondTerm = 1L;

			for (int i = 1; i <= n; ++i) {

				if (newS.equals("")) {
					newS = String.valueOf(firstTerm);
				} else {
					newS = newS + "," + String.valueOf(firstTerm);
				}

				// compute the next term
				Long nextTerm = firstTerm + secondTerm;
				firstTerm = secondTerm;
				secondTerm = nextTerm;
			}

			return newS;

		}
	}

}
