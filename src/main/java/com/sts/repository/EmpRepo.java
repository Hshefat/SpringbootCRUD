package com.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.model.Employee;



@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
