package com.SangamOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SangamOne.model.ProductOrder;

public interface ProductOrderRepo extends JpaRepository<ProductOrder, Integer>{

}
