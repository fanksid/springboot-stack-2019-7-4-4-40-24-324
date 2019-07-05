package com.tw.apistackbase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private enum Gender {
        male,
        female,
        other;
    }

    private Integer id;

    private Integer companyId;

    private String name;

    private Integer age;

    private Gender gender;

    private Integer salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public static List<Employee> generateAliEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(buildEmployee(1, 1, "Alibaba1", 19, Gender.female, 30000));
        list.add(buildEmployee(2, 1, "Alibaba2", 21, Gender.male, 40000));
        list.add(buildEmployee(3, 1, "Alibaba3", 26, Gender.male, 45000));
        return list;
    }

    public static List<Employee> generateTengxunEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(buildEmployee(1, 2, "tengxun1", 19, Gender.female, 30000));
        list.add(buildEmployee(2, 2, "tengxun2", 21, Gender.male, 40000));
        list.add(buildEmployee(3, 2, "tengxun3", 26, Gender.male, 45000));
        return list;
    }

    private static Employee buildEmployee(int id, int companyId, String name, int age, Gender gender, int salary) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setCompanyId(companyId);
        employee.setName(name);
        employee.setAge(age);
        employee.setGender(gender);
        employee.setSalary(salary);
        return employee;
    }

}
