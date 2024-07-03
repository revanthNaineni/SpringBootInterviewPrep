package com.springbootinterview.springbootinterview.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootinterview.springbootinterview.DAO.CustomersPlanDAO;
import com.springbootinterview.springbootinterview.exceptions.CustomerNotFoundException;
import com.springbootinterview.springbootinterview.exceptions.NoActivePlansException;
import com.springbootinterview.springbootinterview.exceptions.NoPlanForTheCustomer;
import com.springbootinterview.springbootinterview.exceptions.NoPlanHistoryException;
import com.springbootinterview.springbootinterview.exceptions.PlanNotFoundException;
import com.springbootinterview.springbootinterview.models.Customer;
import com.springbootinterview.springbootinterview.models.CustomersPlans;
import com.springbootinterview.springbootinterview.models.Plan;


@RestController
//@AllArgsConstructor
public class CustomersPlanController {
	
	private CustomersPlanDAO customersPlanDAO;
	
	public CustomersPlanController(CustomersPlanDAO customersPlanDAO) {
		super();
		this.customersPlanDAO = customersPlanDAO;
	}
	
	
	@PostMapping("/createCustomersPlan")
	public String createCustomersPlan(@RequestBody CustomersPlans customersPlans) throws CustomerNotFoundException, PlanNotFoundException {
		customersPlanDAO.createCustomersPlan(customersPlans);
		return "Plan created successfully";
	
	}

	
	
	@GetMapping("/getCustomersCurrentPlan")
	public ResponseEntity<List<Plan>> getCustomersCurrentPlan(@RequestParam Long customerId) throws CustomerNotFoundException, NoPlanForTheCustomer, NoActivePlansException, NoPlanHistoryException {
		List<Plan> customersPlans = customersPlanDAO.getCustomersPlanDAO(customerId,true);
		return ResponseEntity.status(HttpStatus.OK).body(customersPlans);

	}
	
	@GetMapping("/getCustomersPlanHistory")
	public ResponseEntity<List<Plan>> getCustomersPlanHistory(@RequestParam Long customerId) throws CustomerNotFoundException, NoPlanForTheCustomer, NoActivePlansException, NoPlanHistoryException {
		List<Plan> customersPlans = customersPlanDAO.getCustomersPlanDAO(customerId,false);
		return ResponseEntity.status(HttpStatus.OK).body(customersPlans);

	}
	 

}
