package com.SangamOne.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SangamOne.model.Company;
import com.SangamOne.model.House;

@Repository
public interface HouseRepo extends JpaRepository<House, Integer>{



	@Query(value = "select * from houses where company_id=:company_id", nativeQuery = true)
	List<House> findByHouses(@Param("company_id") int company_id);
	
//	@Query(value="select * from houses where company_id=?1", nativeQuery = true)
//	List<House> findByHouses(int company_id);

	@Query(value = "select * from houses where company_id=:company_id and house_number=:house_number", nativeQuery = true)
	List<House> findByHouse1(@Param("company_id")int company_id, @Param("house_number")String house_number);

	@Modifying
	@Transactional
	@Query(value = "delete from houses where company_id=:company_id and house_id=:house_id", nativeQuery = true)
	void deleteByCompanyIdAndHouseId(@Param("company_id")int company_id, @Param("house_id")int house_id);

}
