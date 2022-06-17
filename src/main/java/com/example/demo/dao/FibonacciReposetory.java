package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Fibonacci;

public interface FibonacciReposetory extends JpaRepository<Fibonacci, Long> {

	public Optional<Fibonacci> findByInput(Long id);

	@Query(value = "select max(requestCount) from Fibonacci")
	public int findMaxCount();

	@Query("select input from Fibonacci u where u.requestCount = ?1")
	public List<Integer> getMostHitsInput(int input);

}
