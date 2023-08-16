package com.SangamOne.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SangamOne.model.Company;
import com.SangamOne.model.House;
import com.SangamOne.repository.HouseRepo;

@RestController
public class HouseController {

	@Autowired
	HouseRepo houseRepo;
	
	@PostMapping("/addHouse")
	public String addHouse(@RequestBody House house) {
		houseRepo.save(house);
		return "Inserted";
	}
	
//	@GetMapping("/viewHousesByCompanyId/{company_id}")
//	public List<House> getHouses(@PathVariable int company_id) {
//		return houseRepo.findByHouses(company_id);
//	}
	
	
//	@GetMapping("/getHouseByCompanyId&houseNo/{company_id}/{house_number}")
//	public List<House> getByHouses1(@PathVariable int company_id, @PathVariable String house_number) {
//		return houseRepo.findByHouse1(company_id, house_number);
//	}
	
	@PutMapping("/updateHouse")
	public String updateHouse(@RequestBody House house) {
		houseRepo.save(house);
		return "Updated";
	}
	
	@DeleteMapping("/delete/{company_id}/{house_id}")
	public String deleteByCompanyIdAndHouseId(@PathVariable int company_id, @PathVariable int house_id) {
		houseRepo.deleteByCompanyIdAndHouseId(company_id, house_id);
		return "Deleted";
	}
}
