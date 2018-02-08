package org.iris.hibernate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.iris.dto.Address;
import org.iris.dto.LogInName;
import org.iris.dto.UserDetails;
public class Main {

	public static void main(String[] args) {
		
		UserDetails userDetails = new UserDetails();
		//userDetails.setUserId(1);
		LogInName name = new LogInName();
		name.setId(1);
		name.setEmailid("emailid");
		userDetails.setUserId(name);
		userDetails.setUserName("pankaj");
		userDetails.setJoinedDate(new Date());
		Address addr = new Address();
		addr.setStreet("hello");
		addr.setCity("faridabad");
		addr.setState("haryna");
		userDetails.setHomeAddress(addr);
		userDetails.setWorkAddress(addr);
		userDetails.setDescription("this is the first page");
		
		userDetails.getListofAddress().add(addr);
		userDetails.getListofAddress().add(addr);
		
		
		
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session  = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
		userDetails = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
	    //userDetails  =  ( UserDetails ) session.get(UserDetails.class, 1);
		//System.out.println(userDetails.getUserId() + " , " + userDetails.getAddress().getCity());
		
		session.close();
		
		
		
	
		
		
	}
	
}
