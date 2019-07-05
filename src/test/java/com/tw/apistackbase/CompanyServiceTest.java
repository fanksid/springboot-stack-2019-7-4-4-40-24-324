package com.tw.apistackbase;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CompanyServiceTest {
    @Autowired
    private CompanyService companyService;

    @Test
    void should_return_all_company_when_get_all() {
        List<Company> companies = companyService.getAll(null, null);

        assertNotNull(companies);
        assertEquals(2, companies.size());
    }

    @Test
    void should_get_company_when_query_by_id() {
        Company company = companyService.getById(1);

        assertNotNull(company);
        assertEquals("alibaba", company.getCompanyName());
    }

    @Test
    void should_return_null_when_has_no_company_exist() {
        Company company = companyService.getById(101);

        assertNull(company);
    }

    @Test
    void should_return_companys_employees_by_company_id() {
        List<Employee> employees = companyService.getEmployeesByCompanyId(1);

        assertNotNull(employees);
        assertEquals(3, employees.size());
    }

    @Test
    void should_return_companies_when_get_all_with_page_and_size() {
        List<Company> companies = companyService.getAll(1, 1);

        assertNotNull(companies);
        assertEquals(1, companies.size());
        assertEquals("alibaba", companies.get(0).getCompanyName());
    }

    @Test
    void should_add_new_company_when_company_is_valid() {
        Company meituan = new Company(3, "meituan", 100, Collections.emptyList());

        companyService.addCompany(meituan);

        List<Company> companies = companyService.getAll(null, null);
        assertNotNull(companies);
        assertEquals(3, companies.size());
        assertEquals("meituan", companies.get(2).getCompanyName());
    }

    @Test
    void should_update_company_successful_when_update_with_id_company() {
        Company alibaba = new Company(1, "alibaba", 100, Collections.emptyList());

        companyService.updateCompany(1, alibaba);

        List<Company> companies = companyService.getAll(null, null);
        assertNotNull(companies);
        assertEquals(2, companies.size());
        assertEquals("alibaba", companies.get(0).getCompanyName());
        assertEquals(100, companies.get(0).getEmployeesNumber().intValue());
    }
}
