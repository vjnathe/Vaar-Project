package com.webonise.vaar.service;

import java.util.Iterator;

public class VaarServiceHelper {

	public String generateQuery(java.util.List<String> parameters,
			String classpath) throws ClassNotFoundException {

		StringBuilder query = new StringBuilder();
		query.append("from " + classpath + " where ");
		int i = 0;
		for (Iterator<String> iterator = parameters.iterator(); iterator
				.hasNext(); i++) {
			String string = (String) iterator.next();
			if (i % 2 == 0 || i == 0)
				query.append(string);
			else {
				query.append("=");
				query.append(string);
				if (i < (parameters.size() - 1))
					query.append(" " + "and" + " ");
			}
		}

		return query.toString();
	}

}
