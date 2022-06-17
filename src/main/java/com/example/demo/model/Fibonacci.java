package com.example.demo.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Cacheable
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fibonacci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long input;
	@Type(type = "text")
	private String fibonacci;
	private int requestCount;

	public Fibonacci() {
	}

	public Fibonacci(Long id, Long input, String fibonacci, int count) {
		super();
		this.id = id;
		this.input = input;
		this.fibonacci = fibonacci;
		this.requestCount = count;
	}

	public Fibonacci(Long input, String fibonacci, int count) {
		super();
		this.input = input;
		this.fibonacci = fibonacci;
		this.requestCount = count;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInput() {
		return input;
	}

	public void setInput(Long input) {
		this.input = input;
	}

	public String getFibonacci() {
		return fibonacci;
	}

	public void setFibonacci(String fibonacci) {
		this.fibonacci = fibonacci;
	}

	public int getCount() {
		return requestCount;
	}

	public void setCount(int count) {
		this.requestCount = count;
	}

}
