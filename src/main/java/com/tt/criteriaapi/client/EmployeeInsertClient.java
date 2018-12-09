package com.tt.criteriaapi.client;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tt.criteriaapi.model.Employee;
import com.tt.criteriaapi.util.SessionFactoryProvider;

public class EmployeeInsertClient {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "John Doe", "HR", LocalDate.now(), 34000);
		Employee e2 = new Employee(102, "Travis Head", "Developer", LocalDate.parse("2018-06-11"), 48000);
		Employee e3 = new Employee(103, "Alex Dawning", "HR", LocalDate.parse("2018-09-17"), 53000);
		Employee e4 = new Employee(104, "Anna Parker", "Developer", LocalDate.parse("2016-04-13"), 72000);
		Employee e5 = new Employee(105, "Peter Parker", "Developer", LocalDate.parse("2015-12-09"), 84000);
		
		
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);

		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}
}
