package com.vfc.vfc_backend.repository;

import com.vfc.vfc_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    //add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
