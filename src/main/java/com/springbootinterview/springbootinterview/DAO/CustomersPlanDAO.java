package com.springbootinterview.springbootinterview.DAO;

import java.util.List;

import com.springbootinterview.springbootinterview.exceptions.CustomerNotFoundException;
import com.springbootinterview.springbootinterview.exceptions.NoActivePlansException;
import com.springbootinterview.springbootinterview.exceptions.NoPlanForTheCustomer;
import com.springbootinterview.springbootinterview.exceptions.NoPlanHistoryException;
import com.springbootinterview.springbootinterview.exceptions.PlanNotFoundException;
import com.springbootinterview.springbootinterview.models.CustomersPlans;
import com.springbootinterview.springbootinterview.models.Plan;

public interface CustomersPlanDAO {
	
	void createCustomersPlan(CustomersPlans customersPlans) throws CustomerNotFoundException,PlanNotFoundException;
	List<Plan> getCustomersPlanDAO(Long customerID,Boolean isActive) throws CustomerNotFoundException, NoPlanForTheCustomer, NoActivePlansException, NoPlanHistoryException;

}
