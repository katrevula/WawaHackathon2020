package com.emobileconnect.emobileconnect.service.impl;

import com.emobileconnect.emobileconnect.dao.PlanRepository;
import com.emobileconnect.emobileconnect.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {


    @Autowired
    private PlanRepository planRepository;

    
    @Override
    public List<Plan> getAllplans() {
        return planRepository.findAll();
    }

    @Override
    public boolean isPlanExist(Plan plan) {
        return plan.equals(getAllplans());
    }

    @Override
    public Plan addPlan(Plan plan) {
        Plan savedPlan = planRepository.saveAndFlush(plan);
        return plan;
    }

    @Override
    public Plan getByID(int id) {
        return planRepository.findByPlanId(id);
    }

    @Override
    public Plan editPlan(Plan plan) {

        return planRepository.saveAndFlush(plan);
    }

    @Override
    public void updatePlan(Plan plan) {
        planRepository.saveAndFlush(plan);
    }

    @Override
    public void deletePlan(int id) {
        planRepository.deleteById(id);

    }
}
