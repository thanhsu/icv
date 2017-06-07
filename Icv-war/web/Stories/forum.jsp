

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
        
        
        <style type="text/css">
            body{
                
                background: white no-repeat center center fixed; 
			background-size:cover;
			-webkit-background-size: cover;
			-o-background-size: cover;
			-ms-background-size: cover;
			-moz-background-size: cover;
                
            }
            .color-background{
                background-color: #DDD;
                color: #000;
                
            }
            
        </style>
        <script>
            $(document).ready(function(){
                var xhttp;
                xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function(){
                  if(this.readyState==4){
                      document.getElementById('mainforum').innerHTML=this.responseText; 
                  }  
                };
                xhttp.open('GET','http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/StoriesControl?storiesAction=getMenu',true);
                xhttp.send();
            });
            
        </script>
        
    </head>
    <body>
        <div>
            <%@include file = "../fragment/header.html"%>;
        </div>
        
        <div class="container" style="padding-top: 50px;">
            <div class="row">
                <div class="col-md-8 col-sm-8 background-text box-shadow" style="padding-left: 10px; padding-right: 10px; margin-right: 10px;"id="mainforum">
                    
                    
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
