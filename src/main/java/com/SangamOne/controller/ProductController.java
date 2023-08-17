package com.SangamOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SangamOne.model.Product;
import com.SangamOne.repository.ProductRepo;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepo productRepo;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		productRepo.save(product);
		return "Inserted";
	}
	
	@GetMapping("/viewProductsByCompanyId/{company_id}")
	public List<Product> viewProducts1(@PathVariable int company_id) {
		return productRepo.findByProducts(company_id);
	}
	
	
	@GetMapping("/viewHouseByCompanyId&houseId/{company_id}/{house_id}")
	public List<Product> viewProducts2(@PathVariable int company_id, @PathVariable int house_id) {
		return productRepo.findByProducts1(company_id, house_id);
	}
	
//	@GetMapping("/viewHouseByCompanyId&houseNumber/{company_id}/{house_number}")
//	public List<Product> getByProducts2(@PathVariable int company_id, @PathVariable String house_number) {
//		return productRepo.findByProducts2(company_id, house_number);
//	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		productRepo.save(product);
		return "Updated";
	}
	
	@DeleteMapping("/delete/{company_id}/{house_id}/{product_id}")
	public String deleteProduct(@PathVariable int company_id, @PathVariable int house_id, @PathVariable int product_id) {
		productRepo.deleteByCompanyIdAndHouseIdAndProductId(company_id, house_id, product_id);
		return "Deleted";
	}

}

