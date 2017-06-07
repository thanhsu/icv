<%-- 
    Document   : index
    Created on : 17-04-2017, 22:04:43
    Author     : duyng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>I-CV Manager Account</title>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/icon.png">
        
        <link href="lib/css/bootstrap.min.css" rel ="stylesheet">
        <link href="lib/css/justified-nav.css" rel="stylesheet">
        <link href="lib/css/border.css" ref="stylesheet">
        <link href="lib/css/carousel.css" ref="stylesheet">
    </head>
    <body>
        <div>
            <%@include file = "./fragment/header.html"%>;
        </div>
        
        <div class="container" style="padding-top: 100px;">
            <div class="col-md-6 col-sm-6 col-md-offset-3 col-sm-offset-3 box-shadow">
                <form action="AccountControl?accountAction=resetPassword" method="Post">
                    <div class="row">   
                        <div class="col-md-3 col-sm-3">
                            <p>Username</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="text" class="form-control" name="usernamereset" placeholder="Username" autofocus required>
                        </div>
                    </div>
                    <div class="row">   
                        <div class="col-md-3 col-sm-3">
                            <p>Email</p>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <input type="email" class="form-control" name="emailreset" placeholder="Email" autofocus required>
                        </div>
                    </div>
                    <div class="row">   
                        <div class="col-md-6 col-sm-6 col-sm-offset-3 col-md-offset-3">
                            <input class="btn btn-block btn-primary" type="submit" value="Reset Password">
                        </div>
                    </div>
                </form>
                <div class="row">
                    <p><%= request.getParameter("errorReset") %></p>
                    
                </div>
            </div>
            
            
        </div>
        
        
        <div class="clearfix">
            <%@include file="fragment/footer.html" %>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="lib/js/bootstrap.min.js"></script>
        
        
    </body>
</html>
