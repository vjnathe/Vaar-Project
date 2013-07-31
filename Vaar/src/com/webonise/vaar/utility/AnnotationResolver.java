/**
 * 
 */
package com.webonise.vaar.utility;

import java.lang.reflect.Field;



/**
 * @author Vijayraj Nathe class for resolvinf fields from specified class.
 */

//@Component
public class AnnotationResolver {

	

	/**
	 * @param path for class
	 * @return Fields Array.
	 */
	public Field[] getFields(String path) {
		Class<?> classobj;
		try {
			classobj = Class.forName(path);
			Field fields[] = classobj.getDeclaredFields();
			return fields;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

}
