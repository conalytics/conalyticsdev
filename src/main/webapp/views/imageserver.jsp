
<%@ page import = "com.conalytics.services.*" %>
<%@ page import = "java.io.*" %>

<jsp:useBean id="inventory" class="com.conalytics.services.InventoryServiceImpl" scope="session" />
<%
 
  Double iNumPhoto ;

  
  if ( request.getParameter("imgID") != null )
  {
   
    iNumPhoto = Double.parseDouble(request.getParameter("imgID")) ;   
  
    try
    {  
       // get the image from the database
       byte[] imgData = inventory.getImagebyInvId(iNumPhoto);
       // display the image
       response.setContentType("image/gif");
       OutputStream o = response.getOutputStream();
       o.write(imgData);
       o.flush(); 
       o.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw e;
    }
 
  }
%>