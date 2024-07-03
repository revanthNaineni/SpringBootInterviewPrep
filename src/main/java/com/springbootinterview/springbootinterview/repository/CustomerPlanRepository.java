package com.springbootinterview.springbootinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootinterview.springbootinterview.models.CustomersPlans;

@Repository
public interface CustomerPlanRepository extends JpaRepository<CustomersPlans, Long> {
	
	List<CustomersPlans> findByCustomerIdAndActive(Long customerId,Boolean active);

}
