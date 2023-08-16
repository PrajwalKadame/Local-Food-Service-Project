package com.SangamOne.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.SangamOne.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer>{
	
	@Query(value="select * from companies where company_name=?1", nativeQuery = true)
	List<Company> findByCompany(String name);

}
