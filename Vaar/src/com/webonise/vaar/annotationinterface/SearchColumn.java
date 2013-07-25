package com.webonise.vaar.annotationinterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Vijayraj Nathe
 *annotation interface searchcoulmn field.
 */

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SearchColumn {

	String label();
	String type() default "String";

}
