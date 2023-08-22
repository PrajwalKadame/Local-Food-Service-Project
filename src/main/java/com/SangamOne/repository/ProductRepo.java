package com.SangamOne.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.SangamOne.model.House;
import com.SangamOne.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query(value = "select * from products where company_id=:company_id", nativeQuery = true)
	List<Product> findByProducts(@Param("company_id") int company_id);
	
	@Query(value = "select * from products where company_id=:company_id and house_id=:house_id", nativeQuery = true)
	List<Product> findByProducts1(@Param("company_id")int company_id, @Param("house_id") int house_id);

//	@Query(value = "select * from products where company_id=:company_id and house_id=:house_number", nativeQuery = true)
//	List<Product> findByProducts2(@Param("company_id") int company_id, @Param("house_number") String house_number);
	
	@Modifying
	@Transactional
	@Query(value = "delete from products where company_id=:company_id and house_id=:house_id and product_id=:product_id", nativeQuery = true)
	void deleteByCompanyIdAndHouseIdAndProductId(@Param("company_id") int company_id, @Param("house_id") int house_id, @Param("product_id") int product_id);

	
	//@Query(value = "select quantity, product_id, company_id, delivery_desc, house_id, house_number, price, product_desc, product_name from products where company_id=:company_id and house_id=:house_id and product_id=:product_id", nativeQuery = true)
	//List<Product> findByProductsQuantity(@Param("company_id") int company_id, @Param("house_id") int house_id, @Param("product_id") int product_id);

}
