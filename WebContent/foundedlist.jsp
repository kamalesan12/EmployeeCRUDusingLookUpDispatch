<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EmpList</title>
</head>
<body>

<table>
<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>ADDRESS</th>
</tr>

<%
ArrayList<HashMap<String,Object>> emplist=new ArrayList<HashMap<String,Object>>();
emplist=(ArrayList<HashMap<String,Object>>)request.getAttribute("empList");
System.out.println("Retrived list from req scope :"+emplist);
if(!emplist.isEmpty() && !emplist.equals(null)){
	for(HashMap<String,Object> empmap:emplist){
		System.out.println(empmap.get("id").getClass().getName());
		int id=(Integer) empmap.get("id");
		String name=(String) empmap.get("name");
		String email=(String) empmap.get("email");
		String addr=(String) empmap.get("addr");
		%>	
		
<tr>
<td><%=id %></td>
<td><%= name%></td>
<td><%= email%></td>
<td><%= addr%></td>
</tr>			
<% 		
	}
}

%>

</table>

</body>
</html>