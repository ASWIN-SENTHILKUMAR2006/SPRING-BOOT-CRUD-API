package com.crud.crudapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crudapp.DTO.EmployeeDTO;
import com.crud.crudapp.model.Employee;
import com.crud.crudapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepo ;
	
	
	
	public List<Employee> getEmployee() {
		List<Employee> empList =  employeeRepo.findAll();
	   return empList;
	}
	
	public Employee addEmployee(EmployeeDTO empData) {
		Employee newEmployee = new Employee();
		newEmployee.setEmpDepartment(empData.getEmpDepartment());
		newEmployee.setEmployeeName(empData.getEmployeeName());
		return  employeeRepo.save(newEmployee);
	}
	
	public Optional<Employee> getEmployeeById(int EmpId) {
		Optional<Employee> Employee_id = employeeRepo.findById(EmpId);
		return Employee_id;
	}
	
	public Employee updateEmployee(Employee retrievedEmployee , EmployeeDTO newEmployeeData) {
		retrievedEmployee.setEmployeeName(newEmployeeData.getEmployeeName());
		retrievedEmployee.setEmpDepartment(newEmployeeData.getEmpDepartment());
		return employeeRepo.save(retrievedEmployee);
	}
	
	public Boolean deleteEmployee(int EmpId) {
		employeeRepo.deleteById(EmpId);
		if(employeeRepo.findById(EmpId).isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
}
