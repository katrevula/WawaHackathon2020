package com.emobileconnect.emobileconnect.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emobileconnect.emobileconnect.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
