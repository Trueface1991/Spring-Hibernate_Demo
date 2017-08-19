package com.andrew.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.andrew.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory SessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		// get current hibernate session
		Session currentSession = SessionFactory.getCurrentSession();
		
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		
		// return results
		return customers;
	}

	
	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current hibernate session
		Session currentSession = SessionFactory.getCurrentSession();
		
		// save the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = SessionFactory.getCurrentSession();
		
		// now retrieve/read the customer from the database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		
		// get the current hibernate session
		Session currentSession = SessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}



}
