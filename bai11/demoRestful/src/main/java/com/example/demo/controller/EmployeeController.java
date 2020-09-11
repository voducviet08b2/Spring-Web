package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    private List<Employee> employeeList=new ArrayList<>();
    @GetMapping("/employee")
    public ResponseEntity<List<Employee> > getEmployee(){
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Employee> createEm(@RequestBody Employee employee){
        employeeList.add(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Employee>> deleteEm(@PathVariable int id){
        for(Employee employee:employeeList){
            if(id==employee.getId()){
                employeeList.remove(employee);
                return new ResponseEntity<>(employeeList,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
