package com.andrew.springdemo.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.andrew.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomer(Model theModel, String name);

}
