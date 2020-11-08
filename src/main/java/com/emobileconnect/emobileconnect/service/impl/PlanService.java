package com.emobileconnect.emobileconnect.service.impl;

import com.emobileconnect.emobileconnect.model.Plan;

import java.util.List;

public interface PlanService  {

    List<Plan> getAllplans();

    boolean isPlanExist(Plan plan);

//    boolean isLetter(Plan plan);

    Plan addPlan(Plan plan);

    Plan getByID(int id);

    Plan editPlan(Plan plan);

    void updatePlan(Plan plan);

    void deletePlan(int id);



}