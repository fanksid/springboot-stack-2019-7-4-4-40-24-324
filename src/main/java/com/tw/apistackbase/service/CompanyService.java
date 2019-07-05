package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private static final List<Company> COMPANY = new ArrayList<Company>() {{
        Company alibaba = new Company(1, "alibaba", 200, Employee.generateAliEmployees());
        Company tengxun = new Company(2, "tengxun", 200, Employee.generateTengxunEmployees());
        add(alibaba);
        add(tengxun);
    }};

    public List<Company> getAll(Integer page, Integer pageSize) {
        if (Objects.nonNull(page) && Objects.nonNull(pageSize)) {
            int start = pageSize * (page - 1);
            int end = pageSize * page;
            return COMPANY.subList(getMax(start), getMax(end));
        }
        return COMPANY;
    }

    private int getMax(int number) {
        if (number >= COMPANY.size() - 1) {
            return COMPANY.size() - 1;
        }
        return number;
    }

    public Company getById(Integer id) {
        Optional<Company> company = COMPANY.stream().filter(c -> id.equals(c.getId())).findAny();
        return company.orElse(null);
    }

    public List<Employee> getEmployeesByCompanyId(Integer id) {
        Company company = getById(id);
        if (Objects.isNull(company)) {
            return Collections.emptyList();
        }
        return company.getEmployees();
    }
}
