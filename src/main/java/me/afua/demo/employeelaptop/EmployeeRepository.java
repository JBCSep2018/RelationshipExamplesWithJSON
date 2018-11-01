package me.afua.demo.employeelaptop;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    Iterable <Employee> findAllByFirstName(String firstName);
    Iterable <Employee> findAllByMyLaptop_Model(String make);
}
