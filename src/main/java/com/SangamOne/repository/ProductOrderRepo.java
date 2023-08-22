package com.SangamOne.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.SangamOne.model.ProductOrder;

public interface ProductOrderRepo extends JpaRepository<ProductOrder, Integer>{

	@Transactional
	@Modifying
	@Query(value="update products set quantity=quantity-:quantity where product_id=:product_id and quantity>=:quantity", nativeQuery=true)
	int updateProductCount(@Param("quantity") int quantity, @Param("product_id")int product_id);

}
