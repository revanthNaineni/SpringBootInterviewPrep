package com.springbootinterview.springbootinterview.DAO.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootinterview.springbootinterview.DAO.CustomersPlanDAO;
import com.springbootinterview.springbootinterview.exceptions.CustomerNotFoundException;
import com.springbootinterview.springbootinterview.exceptions.NoActivePlansException;
import com.springbootinterview.springbootinterview.exceptions.NoPlanForTheCustomer;
import com.springbootinterview.springbootinterview.exceptions.NoPlanHistoryException;
import com.springbootinterview.springbootinterview.exceptions.PlanNotFoundException;
import com.springbootinterview.springbootinterview.models.Customer;
import com.springbootinterview.springbootinterview.models.CustomersPlans;
import com.springbootinterview.springbootinterview.models.Plan;
import com.springbootinterview.springbootinterview.repository.CustomerPlanRepository;
import com.springbootinterview.springbootinterview.repository.CustomerRepository;
import com.springbootinterview.springbootinterview.repository.PlanRepository;

@Service
//@AllArgsConstructor
public class CustomersPlanDAOImpl implements CustomersPlanDAO {
	
	private CustomerPlanRepository customerPlanRepository;
	private CustomerRepository customerRepository;
	private PlanRepository planRepository;
	

	public CustomersPlanDAOImpl(CustomerPlanRepository customerPlanRepository, CustomerRepository customerRepository,
			PlanRepository planRepository) {
		super();
		this.customerPlanRepository = customerPlanRepository;
		this.customerRepository = customerRepository;
		this.planRepository = planRepository;
	}


	
	@Override
	public List<Plan> getCustomersPlanDAO(Long customerID, Boolean isActive) throws CustomerNotFoundException, NoPlanForTheCustomer, NoActivePlansException, NoPlanHistoryException {
		Optional<Customer> findCustomerById = customerRepository.findById(customerID);
		List<Plan> currentplans = new ArrayList<Plan>();
		if (findCustomerById.isEmpty()) {
			throw new CustomerNotFoundException("Customer with id " + customerID + " is not found in the server");
		} else {
			List<CustomersPlans> listCustomerPlans = customerPlanRepository.findByCustomerIdAndActive(customerID,isActive);
			if (listCustomerPlans.isEmpty()) {
				if (isActive) {
					throw new NoActivePlansException(
							"Customer with id " + customerID + " is not having any active plans");
				} else {
					throw new NoPlanHistoryException(
							"Customer with id " + customerID + " is not having any plan history");
				}
			}
			for (CustomersPlans customersPlans : listCustomerPlans) {
				Optional<Plan> plan = planRepository.findById(customersPlans.getPlanId());
				if (plan.isPresent()) {
					currentplans.add(plan.get());
				}
			}
			
		}
		return currentplans;
	}
	 

	@Override
	public void createCustomersPlan(CustomersPlans customersPlans) throws CustomerNotFoundException, PlanNotFoundException {
		Optional<Customer> findCustomerById = customerRepository.findById(customersPlans.getCustomerId());
		Optional<Plan> findPlanById = planRepository.findById(customersPlans.getPlanId());
		if(findCustomerById.isEmpty()) {
			throw new CustomerNotFoundException("Customer with id "+customersPlans.getCustomerId()+" is not found in the server");
		}else if(findPlanById.isEmpty()) {
			throw new PlanNotFoundException("Plan with id "+customersPlans.getPlanId()+" is not found in the server");
		}
		customerPlanRepository.save(customersPlans);
		
	}

}
