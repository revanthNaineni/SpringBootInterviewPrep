package com.springbootinterview.springbootinterview.DAO.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootinterview.springbootinterview.DAO.IPlansDAO;
import com.springbootinterview.springbootinterview.models.Plan;
import com.springbootinterview.springbootinterview.repository.PlanRepository;

@Service
public class PlansDAOImpl implements IPlansDAO {
	
	private PlanRepository planRepository;
	

	public PlansDAOImpl(PlanRepository planRepository) {
		this.planRepository = planRepository;
	}

	@Override
	public List<Plan> getAllAvailablePlans() {
		List<Plan> plans = planRepository.findAll();
		return plans;
	}

	@Override
	public List<Plan> searchPlans(String name, String validity, Double price) {
		List<Plan> plans = planRepository.findByPlanNameOrValidityOrPrice(name, validity, price);
		return plans;
	}

}
