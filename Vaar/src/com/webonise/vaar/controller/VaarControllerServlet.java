package com.webonise.vaar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.webonise.vaar.service.VaarService;
import com.webonise.vaar.service.VaarServiceImpl;

/**
 * Servlet implementation class VaarControllerServlet
 */
@WebServlet("/VaarControllerServlet")
public class VaarControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VaarControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Enumeration<?> param=request.getParameterNames();
     String classpath=null;
     List<String> parameters=new ArrayList<String>();
     List list;
     while(param.hasMoreElements())
     {
    	 String paramName = (String)param.nextElement();
    	 if(paramName.equals("definition"))
    	 {
    		 classpath=request.getParameter(paramName);
    	 }
    	 else
    	 {
    		 String paramValues[]=request.getParameterValues(paramName);
        	 for (int i = 0; i < paramValues.length; i++) {
        		 if(!paramValues[i].equals(""))
        		 {
        		   parameters.add(paramName);
        		   parameters.add(paramValues[i]);
        		 }
    		} 
    	 }
    	 
     }
     VaarService service=new VaarServiceImpl();
     list=service.search(parameters,classpath);
    
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
