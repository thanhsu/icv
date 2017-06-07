

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>I-CV Manager Your CV</title>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/icon.png">
        
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/bootstrap.min.css" rel ="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/justified-nav.css" rel="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/border.css" ref="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/carousel.css" ref="stylesheet">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/bootstrap.min.js"></script>
        <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/homejs.js" ></script>
        
        <style type="text/css">
            body{
                
                background: url(image/bg1.jpg) no-repeat center center fixed; 
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
            <%@include file = "../fragment/header.html"%>;
        </div>
        
        <div class="container" style="padding-top: 50px;">
            <div class="row">
                <div class="col-md-8 col-sm-8 background-text box-shadow" style="padding-left: 10px; padding-right: 10px; margin-right: 10px;">
                    <h2><c:out value="${sessionScope.Stories.getTitle()}"></c:out></h2>
                    <p style="font-size: 70%"><c:out value="${sessionScope.Stories.getDatepost()}"></c:out></p>
                    <div>${sessionScope.Stories.getContent()}</div>
                    <p style="font-size: 75%"><strong><c:out value="${sessionScope.Stories.getSignment()}"></c:out></strong></p>
                </div>
                <div class="col-md-3 col-sm-3 col-md-offset-0 col-sm-offset-0 color-background box-danger" style="" id="moreStories">
                  
                    
                    
                </div>
                
            </div>
        </div>
        
        <div class="clearfix">
            <%@include file="../fragment/footer.html" %>
        </div>
    </body>
</html>
