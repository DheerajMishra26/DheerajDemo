package com.javabykiran.SpringbootWithHibernate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabykiran.SpringbootWithHibernate.dao.SpringDao;
import com.javabykiran.SpringbootWithHibernate.entities.Country;
import com.javabykiran.SpringbootWithHibernate.entities.Employee;
import com.javabykiran.SpringbootWithHibernate.entities.Registration;

@Service
public class SpringService {

	@Autowired
	SpringDao springdao;

	public List<Employee> ListEmployee() {
		List<Employee> listemployee = springdao.ListEmployee();

		return listemployee;
	}

	public Employee getEmployeebyid(int id) {
		Employee emp = springdao.getEmployeebyid(id);

		return emp;
	}

	public Employee getEmployeebyName(String name) {

		Employee emp = springdao.getEmployeebyName(name);

		return emp;
	}

	public List<Employee> getallEmployeebyStatus(String status) {
		List<Employee> emplist = springdao.getallEmployeebyStatus(status);

		return emplist;
	}

	public boolean AddEmployee(Employee emp) {

		boolean result = springdao.AddEmployee(emp);

		return result;
	}

	public boolean saveCountry(Country country) {

		boolean result = springdao.saveCountry(country);

		return result;

	}

	public boolean deleteCountrybyCname(String cname) {

		boolean result = springdao.deleteCountrybyCname(cname);

		return result;
	}

	public boolean updateCountry(Country country) {

		boolean result = springdao.updateCountry(country);

		return result;
	}

	public HashMap checklogin(String email, String password) {
		System.out.println("service logincheck");
		Registration reg = springdao.checklogin(email, password);

		HashMap hm = new HashMap();

		if (reg == null) {
			hm.put("msg", "Invalid user");

		} else {
			hm.put("msg", "Valid user");
			reg.setPassword("******");
			hm.put("user", reg);

		}

		return hm;

	}

	public List<Country> getAllCountry() {
		List<Country> countrylist = springdao.getAllCountry();

		return countrylist;
	}

	public boolean updateEmployee(Employee emp) {
		boolean result=springdao.updateEmployee(emp);
		return result;
	}

	public boolean deleteemployeebyid(int id) {
		boolean result=springdao.deleteemployeebyid(id);
		return result;
	}

	

	

	

}
