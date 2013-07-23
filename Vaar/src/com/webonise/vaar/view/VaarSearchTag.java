package com.webonise.vaar.view;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.webonise.vaar.utility.AnnotationResolver;

/**
 * @author Anvay Rajhansa This class is to manage the custom tag MySearch
 * 
 */
public class VaarSearchTag extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String definition;

	private AnnotationResolver myannotationResolved = new AnnotationResolver();

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
		Field[] fields = myannotationResolved.getFields(definition);

		try {
			if (fields == null)
				out.println("No attributes !!!");
			else {
				out.println("<div style=\"border:2px solid black; float:left; margin:0px 20px 0px 0px; padding:5px \">");
				out.print("<table border=\"2px solid black\">");
				for (Field field : fields) {

					Annotation an[] = field.getAnnotations();
					if (an.length == 0)
						System.out.println("No Annotations !!!");

					for (Annotation annotation : an) {

						if (annotation
								.toString()
								.equals("@com.webonise.vaar.annotationinterface.SearchColumn()")) {
							out.print("<tr>");
							out.print("<td>");
							out.println("<label>" + field.getName()
									+ "</label> </td><td>");

							out.println("<input type=\"text\" value=\"\"> </br>");
							out.print("</td>");
							out.print("</tr>");
						}
					}
				}
				out.print("<tr>");
				out.print("<td colspan=\"2\" align=\"center\">");
				out.println("<input type=\"submit\" value=\"Search\">");
				out.print("</td>");
				out.print("</tr>");
				out.print("</table>");
				out.println("</div>");

				out.println("<div style=\"border:2px solid black; float:left; padding:5px;\">");
				out.print("<table>");
				out.print("<tr>");
				for (Field field1 : fields) {
					Annotation an1[] = field1.getAnnotations();
					for (Annotation annotation : an1) {
						if (annotation
								.toString()
								.equals("@com.webonise.vaar.annotationinterface.GridColumn()")) {
							out.print("<td>");
							out.println("<label>" + field1.getName()
									+ "</label>");
							out.println("<input type=\"text\" value=\"\"> </br>");
							out.print("</td>");
						}
					}
				}
				out.print("</tr>");
				out.print("</table>");
				out.println("</div>");
			}

		} catch (IOException e) {

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

}
