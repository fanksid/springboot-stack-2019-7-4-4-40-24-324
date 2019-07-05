package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Company>> getAll(@RequestParam(required = false) Integer page,
                                                @RequestParam(required = false) Integer pageSize) {
        List<Company> companies = companyService.getAll(page, pageSize);
        return ResponseEntity.ok(companies);
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Company> getById(@PathVariable Integer id) {
        Company company = companyService.getById(id);
        return ResponseEntity.ok(company);
    }

    @GetMapping(path = "/{id}/employees", produces = {"application/json"})
    public ResponseEntity<List<Employee>> getEmployeesByCompanyId(@PathVariable Integer id) {
        List<Employee> employees = companyService.getEmployeesByCompanyId(id);
        return ResponseEntity.ok(employees);
    }
}
