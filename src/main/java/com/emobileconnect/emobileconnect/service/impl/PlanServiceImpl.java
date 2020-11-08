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
        return null;
    }

    @Override
    public boolean isPlanExist(Plan plan) {
        return false;
    }

    @Override
    public Plan addPlan(Plan plan) {
        return null;
    }

    @Override
    public Plan getByID(int id) {
        return null;
    }

    @Override
    public Plan editPlan(Plan plan) {
        return null;
    }

    @Override
    public void updatePlan(Plan plan) {

    }

    @Override
    public void deletePlan(int id) {

    }
}
