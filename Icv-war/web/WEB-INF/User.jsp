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
        <title>I-CV Manager Your CV</title>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/icon.png">
        
        <link href="lib/css/bootstrap.min.css" rel ="stylesheet">
        <link href="lib/css/justified-nav.css" rel="stylesheet">
        <link href="lib/css/border.css" ref="stylesheet">
        <link href="lib/css/carousel.css" ref="stylesheet">
    </head>
    <body>
        <%
            if(request.getSession().getAttribute("User")==null){
                response.sendRedirect("./index.jsp");
            }
        %>
        <div>
            <%@include file = "./fragment/header_Logged.html"%>;
        </div>

        
        <div class= "container" > <!-- main introduce -->
            <div class="jumbotron" style="background-color: #DDD;">
                <h1> Wellcome to I-CV</h1>
                <p class="lead">Thank you for visiting our website. Here we will help you create and manage your CV profile</p>
                <p class="lead">All of things, we want to give you a new introduction method for the employee.</p>
                <p class="btn btn-lg btn-success" role="button" ><a href="ProfileControl?profileAction=managerProfile" style="color: white;">Get Started Today</a></p>                
            </div>            
        </div> <hr/>
        <div class="row" style="padding-right: 80px; padding-left: 80px;"> <!-- Some format for user-->
            <div class="col-md-4 col-sm-4 border_all" id="CVTemplate"> <!-- add modal for this-->
                <h2> CV Classic 1</h2>
                <p data-toggle="tooltip" data-placement="top" title="Select this template! Click here."><a href=""><img src="image/cv_1.JPG" alt="Mẫu CV Classic 1" class="img-thumbnail" width="300px" height="420px"/></a></p>
                <p></p>
            </div>
            <div class="col-md-4 col-sm-4 border_all" id="CVTemplate">
                <h2> CV Classic 2</h2>
                <p data-toggle="tooltip" data-placement="top" title="Select this template! Click here."><a href="#"><img src="image/cv_2.JPG" alt="Mẫu CV Classic 2" class="img-thumbnail" width="300px" height="420px"/></a></p>
                <p></p>
            </div>
            <div class="col-md-4 col-sm-4 border_all" id="CVTemplate">
                <h2> CV Classic 3</h2>
                <p data-toggle="tooltip" data-placement="top" title="Select this template! Click here."><a href="#" > <img src="image/templeteCv2.JPG" alt="Mẫu CV Classic 3" class="img-thumbnail" width="300px" height="420px"/></a></p>
                <p></p>
            </div>
        </div><hr>
        <!-- Comment of user -->
        <div class="row center-block">
            
            <div id="myCarousel " class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
                  <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" id="comment">
                   
                 
              </div><!-- /.carousel -->
            
            </div>
        </div>
            
            <div class="modal fade" style="" id="ModalSavePDF" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Choose your format </h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_chooseFormat">
                                            <div class="row">
                                                <div class="col-md-3 col-md-offset-1  col-sm-offset-1 center-block">
                                                    <a target="_blank" href="cvtoPdf?pdfAction=getPDF&idKindCv=1" >
                                                        <img src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/cv_1.JPG" width="100" height="120"/>
                                                    </a>
                                                </div>
                                                    <div  class="col-md-3 col-sm-3 col-md-offset-1  col-sm-offset-1 center-block" >
                                                    <a target="_blank" href="cvtoPdf?pdfAction=getPDF&idKindCv=2" >
                                                        <img src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/cv_2.JPG" width="100" height="120"/>
                                                    </a>
                                                </div>
                                                    <div class="col-md-3 col-sm-3 col-md-offset-1  col-sm-offset-1 center-block">
                                                    <a target="_blank" href="cvtoPdf?pdfAction=getPDF&idKindCv=3" >
                                                        <img src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/templeteCv2.JPG" width="100" height="120"/>
                                                    </a>
                                                </div>
                                                
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
            
        <div class="clearfix">
            <%@include file="fragment/footer.html" %>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="lib/js/bootstrap.min.js"></script>
        <script src="lib/js/homejs.js" ></script>  
        <script type="text/javascript">
            
        </script>
    </body>
</html>
