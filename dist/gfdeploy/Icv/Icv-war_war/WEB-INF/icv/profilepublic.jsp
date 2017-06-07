
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/icon.png">
        <title><c:out value="${sessionScope.Profile.getFirstName()}"></c:out> <c:out value="${sessionScope.Profile.getLastName()}"></c:out></title>
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/icv.createCv.css" rel="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/border.css" rel="stylesheet">
        <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/css/star-rating.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/bootstrap.min.js"></script>
        <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/star-rating.js"></script>
        
        
        <meta property="og:url"           content="http://icvpro.xyz:53172/Icv-war/view.jsp?id=<c:out value="${sessionScope.profileview.getIdUser().getIdUser()}"></c:out>" />
        <meta property="og:type"          content="website" />
        <meta property="og:title"         content="I-Cv Manager your CV" />
        <meta property="og:description"   content="Create your profile and create CV" />
        <meta property="og:image"         content="http://icvpro.xyz:53172/Icv-war/ProfileControl?profileAction=getAvatar&id=${sessionScope.profileview.getIdUser().getIdUser()}" />
        
        
        <style type="text/css">
            body{
                background: url(image/bgpro2.jpg) no-repeat center center fixed; 
			background-size:cover;
			-webkit-background-size: cover;
			-o-background-size: cover;
			-ms-background-size: cover;
			-moz-background-size: cover;
                
            }
        </style>
        
    </head>
    <body>
        <div id="fb-root"></div>
            <script>(function(d, s, id) {
              var js, fjs = d.getElementsByTagName(s)[0];
              if (d.getElementById(id)) return;
              js = d.createElement(s); js.id = id;
              js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.9";
              fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>
        <%@include file="../../fragment/profile_header.html"%>
        <div class="container">
        <div class="row" style="padding-top: 25px;">
            <div class="col-md-9 col-sm-9" >
                
                <!--Profile -->
                
                <div class="row background-text box-shadow" id="info_profile">
                    <div class="row">
                        <div class="col-md-3 col-sm-3 col-md-offset-5 col-sm-offset-5" >
                            <p class="center-block" id="Avatar"><img src="ProfileControl?profileAction=getAvatar&id=<c:out value="${sessionScope.profileview.getIdUser().getIdUser()}"></c:out>" class="img-circle" alt="Profile"  width="128" height="128"></p>
                        </div>
                        <div class="col-md-2 col-sm-2 col-md-offset-2 col-sm-offset-2 text-right">
                            
                            
                        </div>
                        <br/>
                        <p class="center-block"><h2><strong><c:out value="${sessionScope.profileview.getFirstName()}"></c:out> <c:out value="${sessionScope.profileview.getLastName()}"></c:out></strong></h2></p>
                        <p class="center-block"><strong><em><c:out value="${sessionScope.cvview.getMore()}"></c:out></em></strong></p>
                        <p class="center-block">Gender: <em><c:out value="${sessionScope.profileview.getSex()}"></c:out><em></p>
                    </div>
                    <hr/>
                    <div class="center-block row" id="information">
                         <p class="col-md-2 col-sm-2 center-block">Birthday: <em><c:out value="${sessionScope.profileview.getBirthday()}"></c:out><em></p>
                        
                        <div class="col-md-4 col-sm-4 col-md-offset-0 col-sm-offset-0 ">
                            <p><strong>Address:</strong><c:out value="${sessionScope.profileview.getIdAddress().getAddress()}"></c:out></p>
                        </div>
                       
                        <div class="col-md-3 col-sm-3 ">
                            <p id="phoneNumber"><strong>Phone:</strong><c:out value="${sessionScope.profileview.getPhone()}"></c:out></p>
                        </div>
                        <div class="col-md-3 col-sm-3">
                            <p id="email"><strong>Email:</strong><c:out value="${sessionScope.profileview.getEmail()}"></c:out></p>
                        </div>
                    </div>
                
                </div>
                        
                 <!--Education -->
                <div class="row background-text box-shadow" >
                    
                    <div class="row">
                        <div class="col-md-4" style="margin-left: 20px;">
                            <h3>Introduce</h3>
                        </div>
                        <div class="col-md-2 col-sm-2 col-md-offset-5 col-sm-offset-5 text-right" style="margin-top: 10px;">
                           
                            <!--Modal new Education-->

                        </div>
                    </div> <hr/>
                    
                    <div class="row" id ="info_Introduce">
                        <div class="col-md-10 col-sm-10 col-md-offset-1 col-sm-offset-1">
                            <div class="row">
                                <p class="col-md-3 col-sm-3"><span class="badge">Description:</span></p>
                                <p class="col-md-8 col-sm-8"><label id="lbDescription"><em> <c:out value="${sessionScope.profileview.getDescription()}"></c:out></em></label></p>
                                
                                <p class="col-md-3 col-sm-3"><span class="badge">Target Job: </span></p>
                                <p class="col-md-8 col-sm-8"><label id="lbTargetJob"><em> <c:out value="${sessionScope.cvview.getTargetJob()}"></c:out></em></label></p>
                            
                                <p class="col-md-3 col-sm-3"><span class="badge">Hope: </span></p>
                                <p class="col-md-8 col-sm-8"><label id="lbHope"><em> <c:out value="${sessionScope.profileview.getHope()}"></c:out></em></label></p>
                                
                                <p class="col-md-3 col-sm-3"><span class="badge">Hobbit: </span></p>
                                <p class="col-md-8 col-sm-8"><label id="lbHobbit"><em> <c:out value="${sessionScope.cvview.getHobbit()}"></c:out></em></label></p>
                            </div>
                        </div>
                    </div>
 
                </div>
                        
                <br/>
                
                <!--Education -->
                <div class="row background-text box-shadow" >
                    
                    <div class="row">
                        <div class="col-md-4" style="margin-left: 20px;">
                            <h3>Education</h3>
                        </div>
                        <div class="col-md-2 col-sm-2 col-md-offset-5 col-sm-offset-5 text-right" style="margin-top:10px;" >
                           
                            
                        </div>
                    </div> <hr/>
                    
                    <div class="row" id ="info_Education">
                        
                    </div>
 
                </div>
                <br/>
                
                <!--Skill -->
                <div class="row background-text box-shadow" >
                    <div class="row">
                        <div class="col-md-4" style="margin-left: 20px;">
                            <h3>Skill</h3>
                        </div>
                        <div class="col-md-2 col-sm-2 col-md-offset-5 col-sm-offset-5 text-right" style="margin-top: 10px;">
                        </div>
                    </div> <hr/>
                    <div class="row" id ="info_Key_Skill">
                        <!--Key Skill Language Programing or English-->
                    </div>
                    <div class="row" id="info_Another_Skill">
                        <!-- Ex: Teamwork Leader or anything -->
                    </div><hr/>
                    <div class = "row text-center" >
                        <button class=" btn" style="background-color: white;" id="btnShowAnotherSkill" value="true" onclick="ShowAnotherSkill();">Show More</button>
                    </div>
                </div>
                <br/>
                
                <!--Experiences -->
                <div class="row background-text box-shadow" >
                    
                    <div class="row">
                        <div class="col-md-4" style="margin-left: 20px;">
                            <h3>Experiences Work</h3>
                        </div>
                        <div class="col-md-2 col-sm-2 col-md-offset-5 col-sm-offset-5 text-right" style="margin-top: 10px;">
                        </div>
                    </div> <hr/>
                    
                    <div class="row" id ="info_Experiences">
                        
                    </div>
 
                </div>
                <br/>
                
                <!-- new Activity -->
                
                <div class="row background-text box-shadow" >
                    
                    <div class="row">
                        <div class="col-md-4" style="margin-left: 20px;">
                            <h3>Activity</h3>
                        </div>
                        <div class="col-md-2 col-sm-2 col-md-offset-5 col-sm-offset-5 text-right" style="margin-top: 10px;">
                           
                        </div>
                    </div> <hr/>
                    
                    <div class="row" id ="info_Activity">
                        
                    </div>
                </div>
            </div> <!--Main content-->
            
            <div class=" col-md-3 col-sm-3" > 
                 <div class="container-fluid">
                    <div class="row">
                        <p><label class="text-left"><a href="#">People Also Viewed</a></p>
                        <div id="peopleViewed">
                            
                        </div>
                                
                    </div></br><hr>
                    <div class="row">
                        <p><label class="text-left">CV Rating:</label></p>
                       
                        <div id="info-rating">
                            <input onclick="setRating();" id="ratingProfile" name="input-5" value="<%= request.getSession().getAttribute("ratingProfilepublic")%>" class="rating rating-container">
                            
                        </div>
                            
                    </div>
                 <div class="row">
                     <div class="col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2">
                         <button class="btn btn-block btn-primary" data-toggle="modal" data-target="#modalSendRating"  >Send your Rating</button>
                     </div>
                     <div class="row">
                        <p>Share your profile: <label class="text-left"><input class="form-control" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/ProfileControl?profileAction=view&id=<c:out value="${sessionScope.profileview.getIdUser().getIdUser()}" ></c:out>" ><label></p>
                            <div class="fb-share-button" 
                                data-href="http://icvpro.xyz:53172/Icv-war/view.jsp?id=<c:out value="${sessionScope.profileview.getIdUser().getIdUser()}"></c:out>" 
                                data-layout="button_count">
                            </div>      
                    </div>
                    <div class="modal fade" id="modalSendRating" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Send Your Rating</h4>
                                        </div>
                                        <div class="modal-body" id="">
                                            <form action="ProfileControl?profileAction=setRating" method="Post">
                                                <div class="row">
                                                    <div class="col-md-3 col-sm-3">
                                                        <p>Your Rating</p>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6">
                                                        <input  name="inputRating" value="<%= request.getSession().getAttribute("ratingProfilepublic")%>" class="rating rating-container">
                                                    </div>
                                                    <button class="btn btn-block btn-primary" type="submit">Submit</button>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
                                        </div>
                                    </div>
                                </div> 
                    </div>
                     
                 </div>
                    <div class="row box-shadow" id="videoIntroduce">
                       
                    </div>
                </div>
            </div>
            </div>
        </div>
                        
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src ="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/profilepublic.js"></script>  
        
    </body>
</html>
