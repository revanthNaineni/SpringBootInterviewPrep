package com.springbootinterview.springbootinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootinterview.springbootinterview.models.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
	
	List<Plan> findByPlanNameOrValidityOrPrice(String planName,String Validity,Double price);

}
