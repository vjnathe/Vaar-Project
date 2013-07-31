package com.webonise.vaar.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.swing.JOptionPane;

import com.webonise.vaar.utility.AnnotationResolver;

/**
 * @author Anvay Rajhansa This class is to manage the custom tag MySearch
 * 
 */

// @ContextConfiguration(locations = {"/WEB-INF/vaar-context.xml"})
public class VaarSearchTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String definition;

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

		try {
			   pageContext.forward("SearchTool.jsp?definition="+definition+"");
		} catch (ServletException | IOException e) {
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
