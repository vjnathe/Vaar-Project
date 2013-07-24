package com.webonise.vaar.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;

public class VaarServiceHelper {
	
	public String generateQuery(java.util.List<String> parameters, String classpath) throws ClassNotFoundException{
		
		String query="Select ";
		int i=0;
		
		Class<?> classobj;
		
			classobj = Class.forName(classpath);
			Field fields[] = classobj.getDeclaredFields();
		
			int j=0;
			for (Field field : fields) {
				Annotation an[] = field.getAnnotations();
				for (i=0;i<an.length;i++) {
					if (an[i]
							.toString()
							.equals("@com.webonise.vaar.annotationinterface.GridColumn()")){
						query=query+field.getName();
						
						if(j!=(fields.length-2))
						query=query+",";
					}
				}
				j++;
			}
			
		query=query+" from "+classpath+" where ";
		i=0;
		for (Iterator<String> iterator = parameters.iterator(); iterator.hasNext();i++) {
			String string = (String) iterator.next();
			if(i%2==0 || i==0)
				query=query+string;
			else{
				query=query+"=";
				query=query+string;
				if(i<(parameters.size()-1))
				query=query+" "+"and"+" ";
			}
		}
		
		return query;
		
		
		
	}

}
