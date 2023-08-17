package com.SangamOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SangamOne.model.Product;
import com.SangamOne.model.ProductOrder;
import com.SangamOne.repository.ProductOrderRepo;

@RestController
public class ProductOrderController {

	@Autowired
	ProductOrderRepo productOrderRepo;
	
	@PostMapping("/orderProduct")
	public String orderProduct(@RequestBody ProductOrder productOrder) {
		productOrderRepo.save(productOrder);
		return "Inserted";
	}
	
	@PutMapping("/cancelOrder")
	public String cancelOrder(@RequestBody ProductOrder productOrder) {
		productOrderRepo.save(productOrder);
		return "Cancelled";
	}
	
	@PutMapping("/updateOrderQuantity")
	public String updateOrderQuantity(@RequestBody ProductOrder productOrder) {
		productOrderRepo.save(productOrder);
		return "Updated";
	}
}
