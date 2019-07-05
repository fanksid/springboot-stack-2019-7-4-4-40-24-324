package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private static final List<Company> COMPANY = new ArrayList<Company>(){{
        Company alibaba = new Company(1, "alibaba", 200, Employee.generateAliEmployees());
        Company tengxun = new Company(2, "tengxun", 200, Employee.generateTengxunEmployees());
        add(alibaba);
        add(tengxun);
    }};

    public List<Company> getAll() {
        return COMPANY;
    }
}
