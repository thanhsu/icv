<%-- 
    Document   : failure
    Created on : 20-04-2017, 09:43:10
    Author     : duyng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Failure</title>
        <link rel="shortcut icon" href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/icon.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/bootstrap.min.css" rel ="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/signin.css" rel="stylesheet">
    
        <style type="text/css">
            .backgroup_register{
                position: fixed;
                background-image: url("./image/");
            }
            body{
                
                background: url(image/bgrg.jpg) no-repeat center center fixed; 
			background-size:cover;
			-webkit-background-size: cover;
			-o-background-size: cover;
			-ms-background-size: cover;
			-moz-background-size: cover;
                
            }
            .color-background{
                background-color: white;
                color: #000;
                
            }
            
        
        </style>
    
    </head>
    <body>
        
        
        <div class="container">
            <form class="form-signin" role="form" action ="AccountControl?accountAction=login" method="Post">
                <h2 class="form-signin-heading">Please sign in</h2>
                <input type="text" class="form-control" placeholder="UserName" name="username" required autofocus>
                <input type="password" class="form-control" placeholder="Password" name="password" required>
               
                <button class="btn btn-lg btn-primary  btn-block" type="submit">Sign in</button>
                <p id="errorLogin"><c:out value="${sessionScope.errorLogin_}"> </c:out> </p>
            </form>
            <a class="btn btn-lg btn-success btn-block" type="button" href="AccountControl?accountAction=register">Sign Up</a>
            
        </div>
        
        
    </body>
</html>
