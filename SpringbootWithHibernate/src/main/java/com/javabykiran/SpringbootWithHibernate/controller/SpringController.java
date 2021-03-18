package com.javabykiran.SpringbootWithHibernate.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabykiran.SpringbootWithHibernate.entities.Country;
import com.javabykiran.SpringbootWithHibernate.entities.Employee;
import com.javabykiran.SpringbootWithHibernate.entities.Registration;
import com.javabykiran.SpringbootWithHibernate.service.SpringService;

@CrossOrigin
@RestController
public class SpringController {

	@Autowired
	SpringService service;

	@RequestMapping("getallemployee")
	public List<Employee> ListEmployee() {
		List<Employee> listempolyee = service.ListEmployee();

		return listempolyee;

	}

	@RequestMapping("getallemployeebyid/{id}")
	public Employee getEmployeebyid(@PathVariable int id) {

		System.out.println(id);
		Employee emp = service.getEmployeebyid(id);

		return emp;
	}

	@DeleteMapping("/deleteemployee/{id}")
	public String deleteemployeebyid(@PathVariable int id)
	{
		
		boolean result=service.deleteemployeebyid(id);
		if(result){
			return "Employee" +id+  "Deleted Successfully !!!";
		}else{
			return "Error";
		}
		
		
	}

	@RequestMapping("getallemployeebyname/{name}")
	public Employee getallEmployeebyName(@PathVariable String name)

	{
		System.out.println(name);
		Employee emp = service.getEmployeebyName(name);

		return emp;

	}

	@RequestMapping("getallemployeebystatus/{status}")
	public List<Employee> getallEmployeebyStatus(@PathVariable String status) {
		System.out.println(status);
		List<Employee> emplist = service.getallEmployeebyStatus(status);

		return emplist;

	}

	@PutMapping("updateEmployee")
	public String UpdateEmployee(@RequestBody Employee emp) {
		boolean result = service.updateEmployee(emp);
		if (result) {
			return "Employee " + emp.getName() + " Updated Successfully";
		} else {
			return "Error";
		}

	}

	@PostMapping("addEmployee")
	public String AddEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getName());

		boolean result = service.AddEmployee(emp);
		if (result) {
			return "Data Added Successfully";
		} else {
			return "Error";
		}

	}

	@RequestMapping("getallCountry")
	public List<Country> getAllCountry() {
		List<Country> countrylist = service.getAllCountry();
		return countrylist;

	}

	@PostMapping("savecountry")
	public String saveCountry(@RequestBody Country country) {
		System.out.println(country.getCname());
		boolean result = service.saveCountry(country);

		if (result) {
			return "Country Added Successfully";
		} else {
			return "Error";
		}

	}

	@DeleteMapping("deletecountry/{cname}")
	public String deleteCountrybyCname(@PathVariable String cname) {
		System.out.println(cname);
		boolean reasult = service.deleteCountrybyCname(cname);
		return "Country Deleted Successfully";
	}

	@PutMapping("updatecountry")
	public String updateCountry(@RequestBody Country country) {
		System.out.println(country.getCname());
		boolean result = service.updateCountry(country);
		if (result) {
			return "Country " + country.getCname() + " Updated Successfully";
		} else {
			return "Error";
		}

	}

	@PostMapping("logincheck")
	public HashMap Logincheck(@RequestBody Registration reg) {
		HashMap hm = service.checklogin(reg.getEmail(), reg.getPassword());

		return hm;

	}

}
