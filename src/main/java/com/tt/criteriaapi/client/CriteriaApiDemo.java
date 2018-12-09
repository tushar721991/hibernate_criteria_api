package com.tt.criteriaapi.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.tt.criteriaapi.model.Employee;
import com.tt.criteriaapi.util.SessionFactoryProvider;

public class CriteriaApiDemo {

	public static void main(String[] args) {
		criteriaMultiselect();
		
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();
		
		//create criteriabuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery  = builder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
//		criteriaQuery.select(root);
		Path expression = root.get("employeeSalary");
//		criteriaQuery.select(root).where(builder.greaterThan(expression, 30000));
		//find all employees whose name starts with A
//		criteriaQuery.select(root).where(builder.like((Path)root.get("employeeName"), "A%"));
		
		//find all employees salary between 
		criteriaQuery.select(root).where(builder.between((Path)root.get("employeeSalary"),40000, 60000));

		//and condition
		//department and salary
		
		Predicate salaryGreaterThan = builder.greaterThan((Path)root.get("employeeSalary"), 20000);
		Predicate developerDepartment = builder.equal((Path)root.get("employeeDepartment"), "developer");

		criteriaQuery.multiselect(root.get("employeeId"), root.get("employeeSalary"), root.get("employeeDepartment")).where(builder.and(developerDepartment, salaryGreaterThan));
		
//		criteriaQuery.select(root).where(builder.and(developerDepartment, salaryGreaterThan));
		//create query object from session by using criteria query object
		criteriaQuery.orderBy(builder.asc(root.get("employeeSalary")));
		
		Query<Employee> query = session.createQuery(criteriaQuery);
		List<Employee> employeeList = query.list();
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
		
		session.close();
		factory.close();
		
	}

	private static void criteriaMultiselect() {
		// TODO Auto-generated method stub

		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();
		
		//create criteriabuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery  = builder.createQuery(Object[].class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		Path expression = root.get("employeeSalary");
		Predicate salaryGreaterThan = builder.greaterThan((Path)root.get("employeeSalary"), 20000);
		Predicate developerDepartment = builder.equal((Path)root.get("employeeDepartment"), "developer");

		criteriaQuery.multiselect(root.get("employeeId")
				, root.get("employeeDepartment")
				, root.get("employeeSalary"))
		.where(builder.and(developerDepartment, salaryGreaterThan));


		criteriaQuery.orderBy(builder.asc(root.get("employeeSalary")));
		
		Query<Object[]> query = session.createQuery(criteriaQuery);
		List<Object[]> employeeList = query.list();
		for (Object[] employee : employeeList) {
			
			System.out.println(employee[0]+"\t"+employee[1]+"\t"+employee[2]);
		}
		
		session.close();
		factory.close();
		
	}
}
