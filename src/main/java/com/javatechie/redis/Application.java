package com.javatechie.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javatechie.redis.Entity.Product;
import com.javatechie.redis.Reponsitory.ProductDao;

@SpringBootApplication
@Controller
@RequestMapping("/product")
public class Application {
	@Autowired
	private ProductDao productDao;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return productDao.save(product);
	}
	public List<Product> getAllProducts(){
		return productDao.findAll();
	}
	@GetMapping("/{id}")
	public Product  findProduct(@PathVariable int id){
		return productDao.findproductByid(id);
	}
	@DeleteMapping("/{id}")
	public  String remove  (@PathVariable int id) {
		return productDao.deletProduct(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
