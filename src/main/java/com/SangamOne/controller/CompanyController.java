package com.SangamOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SangamOne.model.Company;
import com.SangamOne.repository.CompanyRepo;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyRepo companyRepo;
	
	@PostMapping("/addCompany")
	public String addCompany(@RequestBody Company company) {
		companyRepo.save(company);
		return "Inserted";
	}
		
	@GetMapping("/viewCompanies")
	public List<Company> viewAllCompany() {
		return companyRepo.findAll();	
	}
	
	@GetMapping("/{company_id}")
	public Company getCompany(@PathVariable("company_id") int company_id) {
		return companyRepo.findById(company_id).get();
	}
	
	@GetMapping("/getCompanyByCompanyName/{name}")
	public List<Company> getByCompany(@PathVariable String name) {
		return companyRepo.findByCompany(name);
	}

	@DeleteMapping("/delete/{company_id}")
	public String deleteById(@PathVariable("company_id") int company_id) {
		companyRepo.deleteById(company_id);
		return "Deleted";
	}
}
