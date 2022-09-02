package com.cl.foodapp.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.cl.foodapp.Exception.IdNotFound;
import com.cl.foodapp.dao.CustomerDao;
import com.cl.foodapp.dao.ItemsDao;
import com.cl.foodapp.dao.FoodOrderDao;
import com.cl.foodapp.entity.Customer;
import com.cl.foodapp.entity.FoodOrder;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	FoodOrderDao orderDao;
	
	@Autowired
	ItemsDao itemsDao;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	
	
	public Customer saveCustomer(Customer customer, int id) {
		customer.setGst(0.18);
		customer.setServiceCost(0.05);
		Optional<FoodOrder> orders2 = orderDao.getby(id);
		if (orders2.isEmpty()) {
			throw new IdNotFound();
		} else {
			double total = orders2.get().getTotalPrice();
			customer.setT_cost(total + (total * customer.getGst()) + (total * customer.getServiceCost()));
			return customerDao.saveCustomer(customer);
		}
	
	}
	
	public String sendMessage(Customer customer, int id) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		Optional<FoodOrder> orders3 = orderDao.getby(id);
		if (orders3.isEmpty()) {
			throw new IdNotFound();
		} else {
			customer.setGst(0.18);
			customer.setServiceCost(0.2);
			double total = orders3.get().getTotalPrice();
			customer.setT_cost(total + (total * customer.getGst()) + (total * customer.getServiceCost()));
			simpleMailMessage.setFrom("shamithshetty48824@gmail.com");
			simpleMailMessage.setTo(customer.getEmail());
			simpleMailMessage.setSubject("bill");
			simpleMailMessage.setText("order ID:"+orders3.get().getId()+"food price:"+orders3.get().getTotalPrice()+"Total cost including gst and service cost "+customer.getT_cost());
			javaMailSender.send(simpleMailMessage);
			
			String message=simpleMailMessage.getText();
			
			return message;
		}
	}

}