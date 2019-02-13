package com.shile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 15:10 2019/2/13
 */
public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }


}
