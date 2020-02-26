package com.codersknowledge.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codersknowledge.entity.Employee;
import com.codersknowledge.enums.SortOrderType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.codersknowledge.*"})
@Rollback(false)
public class EmployeeServiceTest {

@Autowired private EmployeeService employeeService;
	
	@Test
	public void testInsert() {
		List<Employee> students = new ArrayList<>();
		for(int i = 1; i <= 1000; i++){
			Employee st = new Employee();
			st.setFirstName("name - " + i);
			students.add(st);
		}
		
		employeeService.saveEmployees(students);
	}
	
	@Test
	public void read() {
		List<Employee> list = employeeService.getAllStudents(10,10, "studentId", SortOrderType.ASC, null);
		list.stream().forEach(s -> System.out.println(s.toString()));
	}

	@Test
	public void countTest() {
		Long count = employeeService.getAllStudentsCount(null);
		System.out.println("============= " + count);
	}
}