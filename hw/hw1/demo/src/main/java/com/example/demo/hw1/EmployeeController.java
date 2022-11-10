package com.example.demo.hw1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api")
public class EmployeeController {

/*
 */
    @GetMapping("/employee")
    public Employee getEmployee(){
        Employee employee = new Employee(301, "afasfa",1411);
        return employee;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") long id){
        Employee employee = new Employee(id, "afasfa",1411);
        return employee;
    }

    @GetMapping("/customers")
    public List<Employee> getEmployees(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(301, "afasfa",1411));
        employeeList.add(new Employee(302, "afafaasfa",141.41));
        return employeeList;
    }

    @PostMapping("/employee")
    public void postEmployee(@RequestBody Employee employee){
        System.out.println("kullanıcı eklendi. name: "+ employee.getName());
    }

    @PutMapping("/employee")
    public void putEmployee(@RequestBody Employee employee){
        System.out.println("kullanıcı güncellendi. name: "+ employee.getName());
    }
    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestBody Employee employee){
        System.out.println("kullanıcı silindi. name: "+ employee.getName());
    }



}
