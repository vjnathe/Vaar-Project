package com.webonise.vaar.dao;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class VaarDaoImpl implements VaarDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public List<?> search(String query) {

		System.out.println("\n\nDAO : In the search function.");
		List<?> list = sessionfactory.getCurrentSession().createQuery(query)
				.list();

		if (list.size() == 0)
			JOptionPane.showMessageDialog(null, "No Records Found !!!");

		return list;
	}
}
