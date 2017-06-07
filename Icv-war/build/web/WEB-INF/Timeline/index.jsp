
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>I-CV Manager Your CV</title>
       
        <link rel="shortcut icon" href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/icon.png">
        <title><c:out value="${sessionScope.Profile.getFirstName()}"></c:out> <c:out value="${sessionScope.Profile.getLastName()}"></c:out></title>
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/icv.createCv.css" rel="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/border.css" rel="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/star-rating.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/bootstrap.min.js"></script>
        
        <style type="text/css">
            body{
                
                background: url(image/bgpro3.jpg) no-repeat center center fixed; 
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
            <%@include file="../fragment/header_Logged.html"%>
        </div>
        <div class="container" style="padding-top: 50px;">
            <div class="col-md-8 col-sm-8">
                <div class=" container-fluid  color-background box-shadow" id="resultbyName">
                    <h4 class="badge">Short by Name</h4>
                    <%= 
                        request.getSession().getAttribute("resultbyName")
                    %>
                </div><hr/>
                <div class="container-fluid  color-background box-shadow" id="resultbyCareer">
                    <h3 class="badge">Short by Career</h3>
                    <%= 
                        request.getSession().getAttribute("resultbyCareer")
                    %>
                </div><hr/>
                <div class="container-fluid  color-background box-shadow" id="resultbyOther">
                    <h3 class="badge">Short by Other</h3>
                    
                </div><hr/>
                
                
            </div>
            <div class="col-md-3 col-sm-3">
                
                
            </div>
            
        </div>
        
        
        
        
        <!-- Comment of user -->
        
        <div class="clearfix">
            <%@include file="../../fragment/footer.html" %>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        
        <script type="text/javascript">
                
        </script>
        
        
    </body>
</html>
