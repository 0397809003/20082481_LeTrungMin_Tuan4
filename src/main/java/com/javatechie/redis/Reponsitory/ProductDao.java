package com.javatechie.redis.Reponsitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.javatechie.redis.Entity.Product;

@Repository
public class ProductDao {
    public static  final String HASH_KEY  = "Product";
    @Autowired
	private RedisTemplate template;
	
	
	public Product save(Product product) {
		template.opsForHash().put(HASH_KEY, product.getId() , product);
		return product;
	}
	
     public List<Product>  findAll() {
		 return template.opsForHash().values(HASH_KEY);

	}
     
     public  Product  findproductByid(int id) {
		// TODO Auto-generated method stub
    	 return (Product) template.opsForHash().get(HASH_KEY, id);

	}
    public String deletProduct(int id) {
    	 template.opsForHash().delete(HASH_KEY, id);
    	return "product  removed !! ";
    }

}
