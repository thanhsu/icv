

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String id = request.getParameter("id");
    RequestDispatcher rd = request.getRequestDispatcher("/ProfileControl?profileAction=view&id="+id);
    rd.forward(request, response);
    //response.sendRedirect("ProfileControl?profileAction=view&id="+ id);
%>
