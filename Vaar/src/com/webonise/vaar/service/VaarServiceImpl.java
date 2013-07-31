package com.webonise.vaar.service;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.webonise.vaar.dao.VaarDao;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VaarServiceImpl implements VaarService {

	@Autowired
	VaarServiceHelper vaarServiceHelper;

	@Autowired
	VaarDao vaarDao;

	@Override
	public String search(java.util.List<String> parameters, String classpath) {
		// TODO Auto-generated method stub

		String query;
		String json = "[";
		List<?> list;
		try {

			query = vaarServiceHelper.generateQuery(parameters, classpath);
			list = vaarDao.search(query);

			Gson gson = new Gson();
			int i=0;
			for (Iterator<?> iterator = list.iterator(); iterator.hasNext();i++) {
				Object object = (Object) iterator.next();
				if(i!=0)
				json+=",";	
				json = json + gson.toJson(object);
			}
			json += "]";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;

	}
}
