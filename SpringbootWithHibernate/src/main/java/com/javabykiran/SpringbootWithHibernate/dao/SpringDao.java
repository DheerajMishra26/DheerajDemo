package com.javabykiran.SpringbootWithHibernate.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.SpringbootWithHibernate.entities.Country;
import com.javabykiran.SpringbootWithHibernate.entities.Employee;
import com.javabykiran.SpringbootWithHibernate.entities.Registration;

@Repository
public class SpringDao {

	@Autowired
	SessionFactory sessionfactory;

	public List<Employee> ListEmployee() {

		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> listemployee = criteria.list();

		return listemployee;
	}

	public Employee getEmployeebyid(int id) {

		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));

		Employee emp = (Employee) criteria.uniqueResult();

		return emp;
	}

	public Employee getEmployeebyName(String name) {

		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("name", name));

		Employee emp = (Employee) criteria.uniqueResult();

		return emp;
	}

	public List<Employee> getallEmployeebyStatus(String status) {

		Session session = sessionfactory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("status", status));
		List<Employee> emplist = criteria.list();

		return emplist;
	}

	public boolean AddEmployee(Employee emp) {

		Session session = sessionfactory.openSession();

		Transaction tx = session.beginTransaction();

		Long millies = System.currentTimeMillis();
		Date date = new Date(millies);
		System.out.println(date);
		emp.setCreateddtm(date);
		emp.setUpdateddtm(date);
		session.save(emp);
		tx.commit();

		return true;
	}

	public boolean saveCountry(Country country) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(country);
		tx.commit();
		return true;
	}

	public boolean deleteCountrybyCname(String cname) {

		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Country where cname=:cname");
		query.setParameter("cname", cname);
		int i = query.executeUpdate();
		tx.commit();

		return false;
	}

	public boolean updateCountry(Country country) {

		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update Country SET cname=:cname where cid=:cid");
		query.setParameter("cname", country.getCname());
		query.setParameter("cid", country.getCid());
		int i = query.executeUpdate();
		tx.commit();
		return true;
	}

	public Registration checklogin(String useremail, String userpassword) {
		System.out.println("login check dao email and password is" + useremail + " " + userpassword);
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Registration.class);
		criteria.add(Restrictions.eq("email", useremail));
		criteria.add(Restrictions.eq("password", userpassword));
		Registration user = (Registration) criteria.uniqueResult();
		System.out.println("user--" + user);

		return user;
	}

	public List<Country> getAllCountry() {
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Country.class);
		List<Country> countrylist = criteria.list();

		return countrylist;
	}

	public boolean updateEmployee(Employee emp) {

		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update Employee SET name=:name where id=:id");
		query.setParameter("name", emp.getName());
		query.setParameter("id", emp.getId());
		int i = query.executeUpdate();
		tx.commit();
		if (i > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean deleteemployeebyid(int id) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Employee where id=:id");
		query.setParameter("id", id);

		int i = query.executeUpdate();
		tx.commit();
		if (i > 0) {
			return true;
		} else

			return false;

	}

}
