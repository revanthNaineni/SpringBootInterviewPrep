package com.springbootinterview.springbootinterview.DAO;

import java.util.List;

import com.springbootinterview.springbootinterview.models.Plan;

public interface IPlansDAO {
	
	List<Plan> getAllAvailablePlans();

	List<Plan> searchPlans(String name, String validity, Double price);

}
