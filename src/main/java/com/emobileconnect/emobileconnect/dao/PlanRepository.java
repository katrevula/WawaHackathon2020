package com.emobileconnect.emobileconnect.dao;

import com.emobileconnect.emobileconnect.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query("select t from Plan t where t.plan_id = :id")
    Plan findByPlanId(@Param("id") int id);

}