<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.webonise.vaar.view.VaarSearchTag"
		import="java.lang.reflect.Field"
		import="java.lang.annotation.Annotation"
		import="com.webonise.vaar.utility.AnnotationResolver"
		import="com.webonise.vaar.annotationinterface.SearchColumn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function validate()
{
	var ele=document.getElementById('searchdiv').getElementsByTagName('input');
	for(var i=0;i<ele.length;i++)
	{
		 if(ele[i].value=="")
		 {
			   ele[i].focus();
			   alert("Field Required");
			   return false;
		  }
		 var type=ele[i].getAttribute('datatype');
		 if(type=="String" || type=="Long" || type=="Date")
			 {
			   if(type=="String")
				   {
				     var val=ele[i].value;
				     if(val.startsWith("'") && val.endsWith("'") && val.length>2)
				    	 {}
				     else
				    	 {
				    	   alert('Invalid String');
				    	   ele[i].focus();
				    	   ele[i].value=""
				    	   return false;
				    	 }
				   }
			   if(type=="Long")
				   {
				     var letters = /^[0-9]+$/;
				     if(!ele[i].value.match(letters))
					   {
					     alert('only numbers allowed');
					     ele[i].focus();
					     ele[i].value="";
					     return false;
					   }
				   }
			   if(type=="Date")
				   {
				      var matches = /^(\d{2})[-\/](\d{2})[-\/](\d{4})$/.exec(ele[i].value);
				      
				      
				      if (matches != null)
				    	  {
				    	     var d = matches[2];
					         var m = matches[1] - 1;
					         var y = matches[3];
					         var composedDate = new Date(y, m, d);
				    	     
					         if((composedDate.getDate() == d &&
					            composedDate.getMonth() == m &&
					            composedDate.getFullYear() == y))
				   		      {
				   		        return true;   
				   		      }
				    	  }
					        	    alert("Invalid Date Format(use (MM-DD-YYYY) format)");
					   		        ele[i].focus();
							        ele[i].value="";
					   		        return false;
				   }
			 }
		 else
			 {
			    alert("Annotation Specified with invalid Datatype(use String or Long or Date)");
			    return false;
			 }
			 
	}
	return true;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Tool</title>
</head>
<body>

	<% 
		
		AnnotationResolver ann=new AnnotationResolver();
		String definition=request.getParameter("definition");
		JOptionPane.showMessageDialog(null,definition);
		Field[] fields=ann.getFields(definition);
		if(fields == null){
			out.println("No attributes !!!");
		}
		else{
	%>

	<form action="VaarControllerServlet?def="<%=definition%>" method="GET">
		<input type="hidden" name="defination" value=definition>
			<div id="searchdiv" style="border: 2px solid black; float: left; margin: 0px 20px 0px 0px; padding: 5px">
				<table border="2px solid black">
					<% for(Field field : fields) {
							Annotation an[] = field.getAnnotations();
							if (an.length == 0)
								System.out.println("No Annotations !!!");

							for (Annotation annotation : an) {
								if (annotation
									.toString()
									.startsWith("@com.webonise.vaar.annotationinterface.SearchColumn")) {
									SearchColumn column=field.getAnnotation(SearchColumn.class); %>

							<tr>
								<td><label><%=column.label()%></label></td>
								<td><input datatype=<%=column.type()%> type="text" name=<%=field.getName()%>></td>
							</tr>
							<%		
								}
							}
						} %>
						
							<tr>
								<td colspan="2" align="center"> <button onclick="return validate()">Search</button> 
								</td>
							</tr>

				</table>
			</div>
	</form>

	<div style="border:2pxsolidblack; float:left; padding:5px;">
		<table>
			<tr>
				<% for (Field field1 : fields) { 
					Annotation an1[] = field1.getAnnotations();
					for (Annotation annotation : an1) {
						if(annotation 
							.toString()
							.equals("@com.webonise.vaar.annotationinterface.GridColumn()")) {
				%>
				<td><label>field1.getName()</label> <input type="text" value="">
				</td>
				<%
						}
					}
				}
		}
				%>
			</tr>
		</table>
	</div>
</body>
</html>