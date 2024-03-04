package com.javatechie.redis.Entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("Product")
@Data
@NoArgsConstructor
@AllArgsConstructor 
public class Product implements Serializable {
    @Id
	private int id ;
	private String name  ;
	private int age ;
	private long  price ;
	
	public Product(int id, String name, int age, long price) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.price = price;
	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	
	
}
