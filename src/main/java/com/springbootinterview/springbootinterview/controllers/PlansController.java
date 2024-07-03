package com.springbootinterview.springbootinterview.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootinterview.springbootinterview.DAO.IPlansDAO;
import com.springbootinterview.springbootinterview.models.Plan;

@RestController
public class PlansController {
	
	private IPlansDAO plansDAO;
	

	public PlansController(IPlansDAO plansDAO) {
		this.plansDAO = plansDAO;
	}

	@GetMapping("/getAllAvailablePlans")
	public ResponseEntity<List<Plan>> getAllAvailablePlans() {
		
		List<Plan> allAvailablePlans = plansDAO.getAllAvailablePlans();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(allAvailablePlans);
		
	}
	
	@GetMapping("/searchPlans")
	public ResponseEntity<List<Plan>> searchPlans(@RequestParam String name,@RequestParam String validity, @RequestParam Double price) {
		
		List<Plan> fetchedPlans = plansDAO.searchPlans(name,validity,price);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(fetchedPlans);
		
	}
}
