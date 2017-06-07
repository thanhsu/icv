
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
        
        <meta property="og:url"           content="http://icvpro.xyz:53172/Icv-war/view.jsp?id=<c:out value="${sessionScope.User.getIdUser()}"></c:out>" />
        <meta property="og:type"          content="website" />
        <meta property="og:title"         content="I-Cv Manager your CV" />
        <meta property="og:description"   content="Create your profile and create CV" />
        <meta property="og:image"         content="http://icvpro.xyz:53172/Icv-war/ProfileControl?profileAction=getAvatar&id=${sessionScope.User.getIdUser()}" />
        
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
        <div id="fb-root"></div>
            <script>(function(d, s, id) {
              var js, fjs = d.getElementsByTagName(s)[0];
              if (d.getElementById(id)) return;
              js = d.createElement(s); js.id = id;
              js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.9";
              fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>
        <div>
            <%@include file="../fragment/header_Logged.html"%>
        </div>
            
        <div class="container">
        <div class="row" style="padding-top: 20px;">
            <div class="col-md-9 col-sm-9" >
                
                <!--Profile -->
                
                <div class="row background-text box-shadow" id="info_profile">
                    <div class="row" >
                        <div class="col-md-3 col-sm-3 col-md-offset-5 col-sm-offset-5" >
                            <p class="center-block" id="Avatar"><img src="${pageContext.request.contextPath}/ProfileControl?profileAction=getAvatar&id=${sessionScope.User.getIdUser()}" class="img-circle" alt="Profile"  width="128" height="128"></p>
                        </div>
                        <div class="col-md-2 col-sm-2 col-md-offset-2 col-sm-offset-2 text-right">
                            
                            <span class="dropdown">
                     
                                <a id = "editProfilemenu" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" data-target="#" href="#">
                                    <svg viewBox="0 0 24 24" width="24px" height="24px" x="0" y="0" preserveAspectRatio="xMinYMin meet" class="artdeco-icon"><g class="large-icon" style="fill: currentColor">
                                        <path d="M2,10H6v4H2V10Zm8,4h4V10H10v4Zm8-4v4h4V10H18Z"></path>
                                        </g>
                                    </svg>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a type="button" id="EditAvatar" data-toggle="modal" data-target="#ModaleditAvatar">Change Avatar</a></li>
                                    
                                        
                                    <li><a type="button" id="EditProfile" data-toggle="modal" data-target="#ModaleditProfile" >Edit Profile</a></li>
                                    
                                    <li><a type="button" id="SavePdf" data-toggle="modal" data-target="#ModalSavePDF" >Save PDF</a></li>
                                    
                                </ul>
                            </span>
                        </div>
                        <br/>
                        <p class="center-block"><h2><strong><c:out value="${sessionScope.Profile.getFirstName()}"></c:out> <c:out value="${sessionScope.Profile.getLastName()}"></c:out></strong></h2></p>
                        <p class="center-block"><strong><em><c:out value="${sessionScope.cv.getMore()}"></c:out></em></strong></p>
                        <p class="center-block">Gender: <em><c:out value="${sessionScope.Profile.getSex()}"></c:out><em></p>
                        <p class="center-block">Birthday: <em><c:out value="${sessionScope.Profile.getBirthday()}"></c:out><em></p>
                        
                    </div>
                    <hr/>
                    <div class="center-block row" id="information">
                        <div class="col-md-5 col-sm-5 col-md-offset-1 col-sm-offset-1">
                            <p>Address: <em><c:out value="${sessionScope.Profile.getIdAddress().getAddress()}"></c:out><em></p>       
                        </div>
                        <div class="col-md-3 col-sm-3  ">
                            <p id="phoneNumber"><strong>Phone:</strong><c:out value="${sessionScope.Profile.getPhone()}"></c:out></p>
                        </div>
                        <div class="col-md-3 col-sm-3">
                            <p id="email"><strong>Email:</strong><c:out value="${sessionScope.Profile.getEmail()}"></c:out></p>
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
                            <a  data-toggle="modal" data-target="#ModaleditIntroduce" id="editIntroduce" href="#">
                                <svg viewBox="0 0 24 24" width="24px" height="24px" x="0" y="0" preserveAspectRatio="xMinYMin meet" class="artdeco-icon"><g class="large-icon" style="fill: blue;">
                                    <path d="M21.71,5L19,2.29a1,1,0,0,0-1.41,0L4,15.85,2,22l6.15-2L21.71,6.45A1,1,0,0,0,22,5.71,1,1,0,0,0,21.71,5ZM6.87,18.64l-1.5-1.5L15.92,6.57l1.5,1.5ZM18.09,7.41l-1.5-1.5,1.67-1.67,1.5,1.5Z"></path>
                                    </g>
                                </svg>  
                            </a>
                            <!--Modal new Education-->

                        </div>
                    </div> <hr/>
                    
                    <div class="row" id ="info_Introduce">
                        <div class="col-md-10 col-sm-10 col-md-offset-1 col-sm-offset-1">
                            <div class="row">
                                <p class="col-md-3 col-sm-3"><span class="badge">Description:</span></p>
                                <p class="col-md-8 col-sm-8"><label id="lbDescription"><em> <c:out value="${sessionScope.Profile.getDescription()}"></c:out></em></label></p>
                                
                                <p class="col-md-3 col-sm-3"><span class="badge">Target Job: </span></p>
                                <p class="col-md-8 col-sm-8"><label id="lbTargetJob"><em> <c:out value="${sessionScope.cv.getTargetJob()}"></c:out></em></label></p>
                            
                                <p class="col-md-3 col-sm-3"><span class="badge">Hope: </span></p>
                                <p class="col-md-8 col-sm-8"><label id="lbHope"><em> <c:out value="${sessionScope.Profile.getHope()}"></c:out></em></label></p>
                                
                                <p class="col-md-3 col-sm-3"><span class="badge">Hobby: </span></p>
                                <p class="col-md-8 col-sm-8"><label id="lbHobbit"><em> <c:out value="${sessionScope.cv.getHobbit()}"></c:out></em></label></p>
                            </div>
                        </div>
                    </div>
 
                </div>
                        
                <hr/>
                
                <!--Education -->
                <div class="row background-text box-shadow" >
                    
                    <div class="row">
                        <div class="col-md-4" style="margin-left: 20px;">
                            <h3>Education</h3>
                        </div>
                        <div class="col-md-2 col-sm-2 col-md-offset-5 col-sm-offset-5 text-right" style="margin-top:10px;" >
                            <a type="button" data-toggle="modal" data-toggle="tooltip"  data-placement="top" title="Add New Education"  data-target="#ModalnewEducation" id="addnewEducation" href="#">
                                <svg    viewBox="0 0 24 24" width="24px" height="24px" x="0" y="0" preserveAspectRatio="xMinYMin meet" class="artdeco-icon"><g class="large-icon" style="fill: red;">
                                <path d="M21,13H13v8H11V13H3V11h8V3h2v8h8v2Z"></path>
                                </g></svg>
                            </a>
                            
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
                            <a href="#" type="button" data-toggle="modal" data-toggle="tooltip"  data-placement="top" title="Add New Skill"  data-target="#ModalnewSkill" id="addnewEducation">
                                <svg    viewBox="0 0 24 24" width="24px" height="24px" x="0" y="0" preserveAspectRatio="xMinYMin meet" class="artdeco-icon"><g class="large-icon" style="fill: red;">
                                <path d="M21,13H13v8H11V13H3V11h8V3h2v8h8v2Z"></path>
                                </g></svg>
                            </a>
                            
                            
                            
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
                            <a href="#" type="button" data-toggle="modal" data-toggle="tooltip"  data-placement="top" title="Add New Experiences Work" data-target="#ModalnewExperiences" id="addnewExperiences">
                                <svg    viewBox="0 0 24 24" width="24px" height="24px" x="0" y="0" preserveAspectRatio="xMinYMin meet" class="artdeco-icon"><g class="large-icon" style="fill: red;">
                                <path d="M21,13H13v8H11V13H3V11h8V3h2v8h8v2Z"></path>
                                </g></svg>
                            </a>
                            
                            
                            
                        </div>
                    </div> <hr/>
                    
                    <div class="row" id ="info_Experiences">
                        
                    </div>
 
                </div>
                
                <!-- new Activity -->
                <br/>
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
                    <div class="row text-center dropdown " style="position: static;">
                        <button class=" btn btn-block btn-info dropdown-toggle" type="button" id="menuNewprofile" data-toggle="dropdown">Add new profile section &nbsp;
                            <span class="caret"></span>
                        </button>

                        <ul class="text-center dropdown-menu list-group" style="position: static;" role="menu" aria-labelledby="menuNewprofile">
                            <div class="row">
                            <div class = "col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-1"><img  src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/youtube.png" >
                            </div>
                            <div class="col-md-9 col-sm-9"><li role="presentation"><a type="button" role="menuitem" tabindex="-1"  href="#" data-toggle="modal" data-target="#ModalUpdateVideo">Add new Video Introduce</a></li></div></div>
                            <hr/><div class="row"><div class="col-md-2 col-sm-2 col-sm-1 col-md-1"><img style="-webkit-user-select: none; " src="http://icons.iconarchive.com/icons/icons8/windows-8/24/Science-University-icon.png"></div>
                            <div class="col-md-9 col-sm-9"><li role="presentation"><a type="button" role="menuitem" tabindex="-1" href="#" data-toggle="modal" data-target="#ModalnewEducation">Add new your Education</a></li></div></div>
                            <a href="Profile.jsp"></a>
                            <hr/><div class="row"><div class="col-md-2 col-sm-2 col-md-1 col-sm-1"><img src="http://static-images.talentegg.ca/briefcase.png" alt="" style=" width:40px; height: 40px;"></div>
                            <div class="col-md-9 col-sm-9"><li role="presentation"><a type="button" role="menuitem" tabindex="-1" href="#" data-toggle="modal" data-target="#ModalnewExperiences">Add new your Experiences</a></li></div></div>
                        </ul>
                    </div><br/>
                    <div class="row ">
                        <p> <label class="text-left"><a href="${pageContext.request.contextPath}/ProfileControl?profileAction=view&id=<c:out value="${sessionScope.User.getIdUser()}"></c:out>">View your public profile</a><label></p>
                    </div><br/>
                    <div class="row">
                        <p>Share your profile: <label class="text-left"><input class="form-control" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/ProfileControl?profileAction=view&id=<c:out value="${sessionScope.User.getIdUser()}" ></c:out>" ><label></p>
                            <div class="fb-share-button" 
                                data-href="http://icvpro.xyz:53172/Icv-war/view.jsp?id=<c:out value="${sessionScope.User.getIdUser()}"></c:out>" 
                                data-layout="button_count">
                            </div>      
                    </div>
                    <div class="row">
                        <p><label class="text-left"><a href="#">People Also Viewed</a></p>
                        <div id="peopleViewed" class="row">
                            
                        </div>
                                
                    </div></br><hr>
                    <div class="row">
                        <p><label class="text-left">Rating:</label></p>
                       
                        <div id="info-rating">
                            <input id="ratingProfile" disabled name="input-5" value="<%= request.getSession().getAttribute("ratingProfile")%>" class="rating rating-container">
                            <p>Follow by: <%= request.getSession().getAttribute("totalFollow") %>( User)</p>
                        </div>
                            
                    </div>
                    <div class="row box-shadow" id="videoIntroduce">
                       
                    </div>
                </div>
            </div>
            </div>
        </div>
                            
                            
                            <!--         Modal and list        -->
        <div class="modal fade" id="ModalUpdateVideo" name="ModalUpdateVideo" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">             
                    <div class="modal-header">                         
                        <button type="button" class="close" data-dismiss="modal">&times;</button>                     
                        <h4 class="modal-title">Update Video Introduce</h4>
                    </div>
                    <div class="modal-body" id="modal_body_changeVideo">                                         
                        <form action="${pageContext.request.contextPath}/ProfileControl?profileAction=updateVideo" method="post" >
                            <div class="row">
                                <div class="col-md-3 col-sm-3">                                                            
                                    Link to Video:                               
                                </div>                            
                                <div class ="col-md-8 col-sm-8">                                          
                                    <input type="text"  class="form-control" name="inputVideoLink" autofocus placeholder="Youtube link" />            
                                </div>
                            </div><hr/>                                  
                            <input class="btn btn-block btn-primary"  type="submit" value="Update Video Introduce"/>                                  
                        </form>
                    </div>                                 
                    <div class="modal-footer">                                         
                        <button type="button" class="close" data-dismiss="modal">Cancel</button>                 
                    </div>
                </div>                              
            </div>                              
        </div>                    
                            
                            
        <div class="modal fade" id="ModaleditAvatar" name="ModaleditAvatar" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">             
                    <div class="modal-header">                         
                        <button type="button" class="close" data-dismiss="modal">&times;</button>                     
                        <h4 class="modal-title">Change Avatar</h4>
                    </div>
                    <div class="modal-body" id="modal_body_changeAvatar">                                         
                        <form action="${pageContext.request.contextPath}/ProfileControl?profileAction=changeAvatar" method="post" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col-md-3 col-sm-3">                                                            
                                    Your Avatar:                               
                                </div>                            
                                <div class ="col-md-5 col-sm-5">                                          
                                    <input type="file" name="inputAvatar" />            
                                </div>
                            </div>                                  
                            <input type="submit" value="Change Avatar"/>                                  
                        </form>
                    </div>                                 
                    <div class="modal-footer">                                         
                        <button type="button" class="close" data-dismiss="modal">Cancel</button>                 
                    </div>
                </div>                              
            </div>                              
        </div>

            <div class="modal fade" id="ModaleditProfile" role="dialog">
                <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                 
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Edit Profile</h4>
                                                </div>
                                                <div class="modal-body" id="modal_body_editProfile">
                                                   
                                                   <form action="${pageContext.request.contextPath}/ProfileControl?profileAction=updateProfile" method="post" > 
                                                    <div class="row">
                                                        <div class="col-md-3 col-sm-3">
                                                            <p>First Name</p>
                                                        </div>
                                                        <div class="col-md-8 col-sm-8">
                                                            <input type="text" class="form-control" name="FirstName" id="inputFirstName" placeholder="Description" value="${sessionScope.Profile.getFirstName()}"/>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 col-sm-3">
                                                            <p>Last Name</p>
                                                        </div>
                                                        <div class="col-md-8 col-sm-8">
                                                            <input type="text" class="form-control" name="LastName" id="inputLastName" placeholder="Target Job" value="${sessionScope.Profile.getLastName()}"/>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class = col-md-3 col-sm-3>
                                                            <p>Career</p>
                                                        </div>
                                                        <div class="col-md-8 col-sm-8">
                                                            <input type="text" class="form-control" name="Career" id="inputCareer" list="listCareer" placeholder="Career" value="${sessionScope.cv.getMore()}"/>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 col-sm-3">
                                                            <p>Birthday</p>
                                                        </div>
                                                        <div class="col-md-8 col-sm-8">
                                                            <input type="date" class="form-control" name="Birthday" id="inputBirthday" placeholder="Birthday" />
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 col-sm-3">
                                                            <p>Address</p>
                                                        </div>
                                                        <div class="col-md-8 col-sm-8">
                                                            <input type="text" class="form-control" name="Address" id="inputAddress" placeholder="Address" value="${sessionScope.Profile.getIdAddress().getAddress()}" />
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 col-sm-3">
                                                            <p>Gender</p>
                                                        </div>
                                                        <div class="col-md-8 col-sm-8">
                                                            <select name="Sex" class="form-control">
                                                                <option value="true" selected>Male</option>
                                                                <option value="false">Female</option>
                                                            </select>
                                                        </div>
                                                        
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 col-sm-3">
                                                            <p>Email</p>
                                                        </div>
                                                        <div class="col-md-8 col-sm-8">
                                                            <input type="text" class="form-control" name="Email" id="inputEmail" placeholder="Email" value="${sessionScope.Profile.getEmail()}"/>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 col-sm-3">
                                                            <p>Phone Number</p>
                                                        </div>
                                                        <div class="col-md-8 col-sm-8">
                                                            <input type="text" class="form-control" name="Phone" id="inputPhoneNumber" placeholder="Phone number" value="${sessionScope.Profile.getPhone()}"/>
                                                        </div>
                                                    </div><hr/>
                                                        <input class=" btn btn-block btn-primary" type="submit" value="Save"/>
                                                        </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <input  class="btn btn-default" data-dismiss="modal" id="Save_Profile" value="Close">
                                                </div>
                                                
                                                 
                                            </div>
                                        </div> 
                                    </div>         
                                                        
                            <!-- Edit introduce -->
                            <div class="modal fade" id="ModaleditIntroduce" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Edit Introduce</h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_newIntroduce">
                                            <form action="${pageContext.request.contextPath}/ProfileControl?profileAction=updateIntroduce" method="Post">
                                            <div class="row">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>Description</p>
                                                </div>
                                                <div class="col-md-8 col-sm-8">
                                                    <input type="text" class="form-control" name="Description" id="inputDescription" placeholder="Description" value="${sessionScope.Profile.getDescription()}">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>Target Job</p>
                                                </div>
                                                <div class="col-md-8 col-sm-8">
                                                    <input type="text" class="form-control" name="TargetJob" id="inputTargetJob" placeholder="Target Job" value="${sessionScope.cv.getTargetJob()}">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>Hope</p>
                                                </div>
                                                <div class="col-md-8 col-sm-8">
                                                    <input type="text" class="form-control" name="Hope" id="inputHope" placeholder="Hope" value="${sessionScope.Profile.getHope()}">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>Hobby</p>
                                                </div>
                                                <div class="col-md-8 col-sm-8">
                                                    <input type="text" class="form-control" name="Hobbit" id="inputHobbit" placeholder="Hobbit" value="${sessionScope.cv.getHobbit()}">
                                                </div>
                                            </div><hr/>
                                                <input class=" btn btn-block btn-primary" type="submit" value="Save"/>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" id="Save_introduce">Close</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                        <!--Modal new Education-->
                            <div class="modal fade" id="ModalnewEducation" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">New Education</h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_newEducation">
                                            <form action ="${pageContext.request.contextPath}/EducationControl?educationAction=newEducation" method="Post">
                                            <div class="row" id="newSchool">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>School<p>
                                                </div>
                                                <div class="col-md-6 col-sm-6">
                                                    <input type="text" name="school" class="form-control" list="listSchool" placeholder="School Name" autofocus>
                                                </div>
                                            </div>
                                            <div class="row" id="newFieldStudy">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>Field of study<p>
                                                </div>
                                                <div class="col-md-6 col-sm-6">
                                                    <input type="text" class="form-control" list="listCareer" name="FieldofStudy" placeholder="Field of study" autofocus>
                                                </div>
                                            </div>
                                            <div class="row" id="newTimePeriod">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>Time Period<p>
                                                </div>
                                                <div class="col-md-2 col-sm-2">
                                                    <input type="number" class="form-control" name="FromYear" placeholder="Year" value="" size="4" autofocus>
                                                </div>
                                                <div class="col-md-1 col-sm-1 text-center">
                                                    <p>To</p>
                                                </div>
                                                <div class="col-md-2 col-sm-2">
                                                    <input type="number" class="form-control" name="ToYear" placeholder="Year" value="" size="4" autofocus>
                                                </div>
                                            </div><hr/>
                                            
                                            <input class=" btn btn-block btn-primary " type="submit" value="Save"/>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" id="Save_education">Close</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            <!--Modal new Skill-->
                            <div class="modal fade" id="ModalnewSkill" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">New Skill</h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_newSkill">
                                            <form action="${pageContext.request.contextPath}/SkillControl?skillAction=newSkill" method="Post">
                                            <div class="row">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>Skill Name</p>
                                                </div>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" type="text" list="listSkill" placeholder="Skill Name" autofocus name="nameSkill">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>Detail Skill</p>
                                                </div>
                                                <div class="col-md-3 col-sm-3 text-center">
                                                    <select class="form-control" name="nameKindSkill" onchange="showDegreeofSkill(this.value);">
                                                        <option value="">Select Kind Skill</option>
                                                        <option value="KeySkill">Key Skill</option>
                                                        <option value="Another Skill">Another Skill</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-3 col-sm-3" id="degreetypeSkill">
                                                    
                                                </div>
                                                <div class="col-md-3 col-sm-3" id="valueofdegree">
                                                
                                                </div>
                                            </div>
                                            <div class ="row" id="periodSkill">
                                                
                                            </div><hr/>
                                            <input type="submit" class="btn btn-block btn-primary" value="Create">
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" id="Save_skill">Close</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>                                                
                            <!--Modal new Experience-->
                            <div class="modal fade" id="ModalnewExperiences" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">New Experiences Work</h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_newExperiences">
                                            <form action="${pageContext.request.contextPath}/ExperiencesControl?experiencesAction=newExperiences" method="Post">
                                            
                                            <div class="row">
                                                <div class="col-md-3 col-sm-3">
                                                    <p>Company/ Your Project</p>
                                                </div>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" type="text" name="companyExperiences" list="listCompany" autofocus placeholder="Company/ Project">
                                                    
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 col-sm3">
                                                    <p>Description</p>
                                                </div>
                                                <div class="col-md-6 col-sm-6">
                                                    <input class="form-control" placeholder="Description( regency, project,...)" autofocus name="descriptionExperiences">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 col-sm3">
                                                    <p>Working Period</p>
                                                </div>
                                                <div class="col-md-6 col-sm-6">
                                                    <input type="number" class="form-control" name="periodExperiences" placeholder="Working Period" autofocus>
                                                </div>
                                            </div><hr/>
                                                <input class="btn btn-block btn-primary" type="submit" value="Create">
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" id="Save_experiences">Close</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            
                            <!--Modal new Experience-->
                            <div class="modal fade" id="ModalnewActivity" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">New Activity </h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_newActivity">
                                            <form action ="${pageContext.request.contextPath}/ActivityControl?activityAction=newActivity" method="Post">
                                                <div class="row">
                                                    <div class="col-md-3 col-sm-3">
                                                        <p>Activity Name</p>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6">
                                                        <input type="text" class="form-control" name="activityName" placeholder="Activity Name (Enter multiple values separated by ';')" autofocus />
                                                    </div>
                                                </div><hr/>
                                                <input type="submit" class="btn btn-block btn-primary" value="Save">
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" id="Save_activity">Close</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            <!-- New Prize-->
                            <div class="modal fade" id="ModalnewPrize" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">New Prize </h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_newActivity">
                                            <form action ="${pageContext.request.contextPath}/ActivityControl?activityAction=newPrize" method="Post">
                                                <div class="row">
                                                    <div class="col-md-3 col-sm-3">
                                                        <p>Prize Name</p>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6">
                                                        <input type="text" class="form-control" name="prizeName" placeholder="Prize Name (Enter multiple values separated by ';')" autofocus />
                                                    </div>
                                                </div><hr/>
                                                <input type="submit" class="btn btn-block btn-primary" value="Save">
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            <div class="modal fade" id="ModaleditPrize" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Edit Prize </h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_editPrize">
                                            
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            <div class="modal fade" id="ModaleditActivity" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Edit Activity </h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_editActivity">
                                            
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" >Close</button>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                                                
                                                
                            <div class="modal fade" id="ModalSavePDF" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Choose your format </h4>
                                        </div>
                                        <div class="modal-body" id="modal_body_chooseFormat">
                                            <div class="row">
                                                <div class="col-md-3 col-sm-3 col-md-offset-1  col-sm-offset-1 center-block">
                                                    <a target="_blank" href="${pageContext.request.contextPath}/cvtoPdf?pdfAction=getPDF&idKindCv=1" >
                                                        <img src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/cv_picture.png" width="80" height="100"/>
                                                    </a>
                                                </div>
                                                    <div target="_blank" class="col-md-3 col-sm-3 col-md-offset-1  col-sm-offset-1 center-block" >
                                                    <a href="${pageContext.request.contextPath}/cvtoPdf?pdfAction=getPDF&idKindCv=2" >
                                                        <img src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/templeteCv1.JPG" width="80" height="100"/>
                                                    </a>
                                                </div>
                                                    <div class="col-md-3 col-sm-3 col-md-offset-1  col-sm-offset-1 center-block">
                                                    <a target="_blank" href="${pageContext.request.contextPath}/cvtoPdf?pdfAction=getPDF&idKindCv=3" >
                                                        <img src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/image/templeteCv2.JPG" width="80" height="100"/>
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
                                                
                                                <!-- List-->
                                                
                                                    <div>
                                                    <!--List Career-->
                                                    <datalist id="listCareer"> </datalist>
                                                    </div>
                                                    <!--List School -->
                                                    <div>
                                                    <datalist id="listSchool"> </datalist>
                                                    </div>
                                                    
                                                    <!--List Skill-->
                                                    <div>
                                                    <datalist id="listSkill"> </datalist>
                                                    </div>
                                                    <!--List Company-->
                                                    <div>
                                                    <datalist id="listCompany"> </datalist>
                                                    <!--List anything-->
                                                    </div>                                
                
                                                    
        <div class="modal fade" style="width: 700px;" id="ModalSavePDF" role="dialog">
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
            <%@include file="../fragment/footer.html" %>
        </div>
        
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script src ="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/profilejs.js"></script> 
        <script src ="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/Icv-war/lib/js/listChoose.js"></script> 
    </body>
</html>
