/**
 * 
 */
package com.webonise.vaar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webonise.vaar.service.VaarService;

/**
 * @author Vijayraj Nathe
 *
 */
@Controller
public class VaarController {
	
	@Autowired
	private VaarService service;

	@RequestMapping(value="/fetcher",method=RequestMethod.GET,produces="json/application")
 public @ResponseBody String  call(@RequestParam("parameters")String name)
 {
		
		System.out.println("CONTROLLER : String recieved is :\t"+name);
		
	
	String arr[]=name.split(",");
	String classpath=null;
    List<String> parameters=new ArrayList<String>();
    String json;
    for (int i = 0; i < arr.length; i+=2) 
    {
		String parameter = arr[i];
		if(parameter.equals("definition"))
			classpath=arr[i+1];
		else
		if(!arr[i+1].equals("?")){
			   parameters.add(parameter);
    		   parameters.add(arr[i+1]);
		}
	}
    System.out.println("CONTROLLER : parameter value is:\t"+parameters);
    System.out.println("CONTROLLER : classpath value is:\t"+classpath);
	
    json=service.search(parameters,classpath);    
    return json;
 }
}
