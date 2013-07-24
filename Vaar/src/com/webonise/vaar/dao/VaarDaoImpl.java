package com.webonise.vaar.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VaarDaoImpl implements VaarDao{
	
	private static SessionFactory factory;
	private static Session session = null;
	      
	@Override
	public List search(String query) {
	
		try {
			Configuration cfg = new Configuration().configure();
			factory = cfg.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object."
					+ ex);
			throw new ExceptionInInitializerError(ex);
		}
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query finalQuery = session.createQuery(query);
		List<?> list = finalQuery.list();
		transaction.commit();
		
		return list;
	}
}
