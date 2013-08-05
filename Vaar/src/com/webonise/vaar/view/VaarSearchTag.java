package com.webonise.vaar.view;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.catalina.connector.Request;

import com.webonise.vaar.utility.AnnotationResolver;

/**
 * @author Anvay Rajhansa This class is to manage the custom tag MySearch
 * 
 */


public class VaarSearchTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
	private String definition;
	
	
	public VaarSearchTag(){
		
	}

	// @Autowired(required=true)
	private AnnotationResolver annotationResolver = new AnnotationResolver();

	/**
	 * @return the definition
	 */
	public String getDefinition() {

		return definition;
	}

	/**
	 * @param definition
	 *            the definition to set definition given in attribute
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		try {
			String address="<a href=\"http://localhost:8080/Vaar/SearchTool.jsp?definition=";
			address+=definition;
			address+="\">Search</a>";
			
			out.print(address);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return SKIP_BODY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {
		return SKIP_PAGE;
	}

	public AnnotationResolver getAnnotationResolver() {
		return annotationResolver;
	}

	public void setAnnotationResolver(AnnotationResolver annotationResolver) {
		this.annotationResolver = annotationResolver;
	}

}
