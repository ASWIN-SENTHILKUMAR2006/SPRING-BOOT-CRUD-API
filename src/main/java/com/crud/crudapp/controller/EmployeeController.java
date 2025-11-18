package com.crud.crudapp.controller;
import com.crud.crudapp.DTO.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudapp.model.Employee;
import com.crud.crudapp.service.EmployeeService;

@RestController
@RequestMapping("/ems/")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService ;
	
	
	@GetMapping("employees")
	public ResponseEntity <List<Employee>> getEmployee() {
		List <Employee> emp = employeeService.getEmployee();
		return ResponseEntity.ok(emp);
	} 
	
	@PostMapping("addemployee")
	public ResponseEntity<?>  addEmployee(@RequestBody EmployeeDTO empData ){
		Employee newEmployee = employeeService.addEmployee(empData);
		String response;
		if(newEmployee == null) {
			response = "Failed To Create Emplloyee 😭😭";
		}else {
			response = "Successfully Created Employee " +  newEmployee.toString() ;
		}
		return  ResponseEntity.ok( response);
	}
	
	@PutMapping("updateemployee/{EmpId}")
	public ResponseEntity<String> updateEmployee(@PathVariable  int EmpId , @RequestBody EmployeeDTO newEmployeeData ){
		Optional<Employee> retrievedEmployee = employeeService.getEmployeeById(EmpId);
		String response ;
		Employee Emp ;
		if(retrievedEmployee.isPresent()) {
			Emp = retrievedEmployee.get();  // get the First element  (employee type )  assign to this Variable
			Employee updatedEmployee = employeeService.updateEmployee( Emp ,  newEmployeeData );
			 response ="Successfully updated Employee {ID : "+EmpId +" } => "  + updatedEmployee.toString( ) ;
		}else {
			response = "No Employee Found by ID:"+EmpId;
		}
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("deleteemployee/{EmpId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable  int EmpId){
		Boolean isDeleted = employeeService.deleteEmployee(EmpId);
		String  response ; 
		if(isDeleted) {
		 response = "Successfully Deleted Employee -> EmpId:0"+EmpId;
		}else {
		response = "Failed To Deleted the Entry!! or Not Found";
		}
		return ResponseEntity.ok(response);
	}


}
