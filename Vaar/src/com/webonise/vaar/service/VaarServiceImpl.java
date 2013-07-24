package com.webonise.vaar.service;

import java.util.List;

import com.webonise.vaar.dao.VaarDao;
import com.webonise.vaar.dao.VaarDaoImpl;



public class VaarServiceImpl implements VaarService{

	@Override
	public List search(java.util.List<String> parameters, String classpath) {
		// TODO Auto-generated method stub
		
		VaarServiceHelper vaarServiceHelper = new VaarServiceHelper();
		
		String query;
		List list=null;
		
		
			try {
				query = vaarServiceHelper.generateQuery(parameters,classpath);
				System.out.print(query);
				VaarDao vaarDao=new VaarDaoImpl();
				list=vaarDao.search(query);
				return list;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		
		
		
	}
}
