<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.conalytics.services.AutoService"%>
<%
   
    String query = request.getParameter("q");
    AutoService as = new AutoService();
    List<String> countries = db.getData(query);
 
    Iterator<String> iterator = countries.iterator();
    while(iterator.hasNext()) {
        String country = (String)iterator.next();
        out.println(country);
    }
%>