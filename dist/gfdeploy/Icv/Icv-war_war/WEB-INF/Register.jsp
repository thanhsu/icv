<%-- 
    Document   : Register
    Created on : 17-04-2017, 23:50:20
    Author     : duyng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/icon.png">
        <title>Create Your New Account Now</title>
        <link href="lib/css/bootstrap.min.css" rel="stylesheet">
        <link href="lib/css/border.css" rel="stylesheet">
        <style type="text/css">
            .backgroup_register{
                position: fixed;
                background-image: url("./image/");
            }
            body{
                
                background: url(image/bgrg2.jpg) no-repeat center center fixed; 
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
        <div>
            <%@include file="./fragment/header.html"%>
        </div>
        
        <div class="container " style="padding-top: 100px;">
            <div class="row">
                <div class="col-md-5 col-sm-5 border_left">
                    <!--- put some thing in there -->
                    
                    
                    
                   
                </div>
                <!-- Form Register -->
                <div class="col-md-6 col-sm-5 col-sm-offset-1 col-md-offset-1 background-text box-shadow">
                    <form class=" form-group" action="AccountControl?accountAction=checkandregister"  method="Post">
                        <h2>Register your account.<i> Connect to us!</i></h2><hr/>
                        <div  class="row">
                            <div class="col-sm-5 col-md-5">
                                <!-- put the first name and the last name -->
                                <input type="text" id="inputFirstName" name="inputFirstName" class="form-control" placeholder="First Name" required autofocus>
                            </div>
                            <div class="col-sm-5 col-md-5 col-sm-offset-0 col-md-offset-0">
                                <!-- <label for="inputLastName" class="label-primary">Last Name:</label> -->
                                <input type="text" id="inputLastName" class="form-control" name="inputLastName" placeholder="Last Name" required autofocus>
                            </div> 
                        </div><br/>
                        <div class="row">
                            <div class="col-sm-4 col-md-4 col-sm-offset-0 col-md-offset-0">
                                <!-- <label for="inputFirstName" class="label-primary">First Name:</label>    -->
                                <input type="text" id="inputUserName" class="form-control" name="inputUserName" placeholder="User Name" required autofocus>
                            </div>
                            <div class="col-sm-4 col-md-4">
                                <input type="email" id="inputEmail" class="form-control" name="inputEmail" placeholder="Email" required autofocus>
                                
                            </div>
                            <div class="col-sm-5 col-md-5 col-sm-offset-1 col-md-offset-1">
                                <p id="errorUsername" class="disabled text-center text-warning" >
                                    <c:out value="${requestScope.RegisterFailure}"></c:out>
                                </p>
                            </div>
                        </div><br />
                        <div class="row ">
                            <div class="col-sm-5 col-md-5 col-sm-offset-0 col-md-offset-0">
                                <input type="password" id="inputPassword1" class="form-control" name="inputPassword" placeholder="Password" required autofocus>
                            </div>
                            <div class="col-sm-5 col-md-5 col-sm-offset-0 col-md-offset-0">
                                <input type="password" id="inputPassword2" class="form-control" placeholder="Comfirm Password" >
                            </div>
                            <div class="col-sm-2 col-md-2">
                                <p id="errorComfirmPassword" class="disabled text-center text-warning" ></p>
                            </div>
                        </div><br />
                        
                        
                        <div class="row">
                            <button class="btn btn-block btn-success"  id="btnSubmit" type="submit">Submit</button>
                        </div>
                       <!-- something in there -->
                    </form>
                </div>
            </div>
        </div>
        
        
        <!-- Bootstrap script help dropdown button-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script src ="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/registerjs.js"></script>
    </body>
</html>
