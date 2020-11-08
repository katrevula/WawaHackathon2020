package com.emobileconnect.emobileconnect.controller;

import com.emobileconnect.emobileconnect.model.Plan;
import com.emobileconnect.emobileconnect.service.impl.PlanService;
import com.emobileconnect.emobileconnect.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;
@RestController
public class PlanController {

    public static final Logger logger = LoggerFactory.getLogger(PlanController.class);

    @Autowired
    private PlanService planService;


    @RequestMapping(value = "/addplans", method = RequestMethod.POST)
    public ResponseEntity<?> addPlan(@RequestBody Plan plan, UriComponentsBuilder ubuilder) {
        Plan currentPlan = planService.getByID(plan.getPlan_id());
        //  logger.info(String.format("Plan name %s", plan.getPlan_Name()));
        if (currentPlan != null) {
            logger.error("Unable to create. Plan with name {} already exist", plan.getPlan_Name());
            return new ResponseEntity(new CustomErrorType("Unable to create. Plan with following Name already exist: " + plan.getPlan_Name()),
                    HttpStatus.CONFLICT);
        }
        planService.addPlan(plan);
        //    logger.info("Printing plan value" + plan.getPlan_Name());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ubuilder.path("/api/addplans/").buildAndExpand(plan.getPlan_id()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }








}


