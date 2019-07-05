package com.tw.apistackbase;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.service.CompanyService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CompanyServiceTest {
    @Autowired
    private CompanyService companyService;

    @Test
    void should_return_all_company_when_get_all() {
        List<Company> companies = companyService.getAll();

        assertNotNull(companies);
        assertFalse(companies.isEmpty());
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
}
