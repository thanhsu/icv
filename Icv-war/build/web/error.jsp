
<%@page contentType="text/html" isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Icv</title>
        <link rel="shortcut icon" href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/icon.png">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/icv.createCv.css" rel="stylesheet">
        
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="nav navbar-fixed-top">
                    <h1 style=" margin-top: 20px; margin-left: 20px; color: #28a4c9"><a href="index.jsp">Icv</a></h1>
                </div>
            </div>
            <div class="row center-block text-center">
                <h2 class="text-warning" > Sorry </h2>
                <p class="text-info">Page not found or you don't have permission to acces this page! </p>
                <label class="text-muted">Try going back to the previous page or see our <a href="#">Help</a> for more information</label>
            </div>
            
        </div>
        <div style="padding-top: 300px;">
        <%@include file="fragment/footer.html"  %>
        </div>
    </body>
</html>
