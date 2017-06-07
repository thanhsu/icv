
$(window).ready(function (){
   var xhttp;
   xhttp =new XMLHttpRequest();
   xhttp.onreadystatechange = function (){
     if(this.readyState ==4){
         document.getElementById('info_Education').innerHTML = this.responseText;
     }  
   };
   xhttp.open('GET','EducationControl?educationAction=getViewpublic',true);
   xhttp.send();
});


$(window).ready(function (){
   var xhttp;
   var url = window.location.pathname;  
   xhttp =new XMLHttpRequest();
   xhttp.onreadystatechange = function (){
     if(this.readyState ==4 ){
         document.getElementById('info_Key_Skill').innerHTML = this.responseText;
     }  
   };
   xhttp.open('GET','SkillControl?skillAction=getKeySkillViewpublic',true);
   xhttp.send();
});

$(window).ready(function(){
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState==4 ){
            document.getElementById('videoIntroduce').innerHTML= this.responseText;
        }  
    };
    xhttp.open('GET','ProfileControl?profileAction=getVideoIntroducepublic',true);
    xhttp.send();
});



$(window).ready(function (){
   var xhttp;
   xhttp =new XMLHttpRequest();
   xhttp.onreadystatechange = function (){
     if(this.readyState ==4 ){
         document.getElementById('info_Experiences').innerHTML = this.responseText;
     }  
   };
   xhttp.open('GET','ExperiencesControl?experiencesAction=getViewpublic',true);
   xhttp.send();
});

$(window).ready(function (){
   var xhttp;
   xhttp =new XMLHttpRequest();
   xhttp.onreadystatechange = function (){
     if(this.readyState ==4 ){
         document.getElementById('info_Activity').innerHTML = this.responseText;
     }  
   };
   xhttp.open('GET','ActivityControl?activityAction=getViewpublic',true);
   xhttp.send();
});

$(window).ready(function(){
    var xhttp ;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if(this.readyState == 4){
            document.getElementById('peopleViewed').innerHTML = this.responseText;
        }  
    };
    xhttp.open('GET','getComment?commentAction=getPeopleViewpublic',true);
    xhttp.send();
    
});

function ShowAnotherSkill(){
    
   var valuebtn = $('#btnShowAnotherSkill').val();
   if(valuebtn.toString() == "true"){
        getAnotherSkill();
        $('#btnShowAnotherSkill').val("false");
        $('#btnShowAnotherSkill').html("Hide");
    }
    else{
        document.getElementById('info_Another_Skill').innerHTML = "";
        $('#btnShowAnotherSkill').html("Show More");
        $('#btnShowAnotherSkill').val("true");
    }
    
}

$('window').ready(function (){
    $('#ratingProfile').click(setRating());
    
    
});

function setRating(){
    var valueRating = $('#ratingProfile').val();
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if(this.readyState==4 ){
            $('#ratingProfile').val(this.response);
        }
    };
    xhttp.open('POST','AccountControl?accountAction=rating&rating='+ valueRating.toString(),true);
    xhttp.send();
}

function getAnotherSkill(){
            var xhttp;
            //var url = window.location.pathname;  
            xhttp =new XMLHttpRequest();
            xhttp.onreadystatechange = function (){
              if(this.readyState ==4 && this.status ==200){
                  document.getElementById('info_Another_Skill').innerHTML = this.responseText;
              }  
            };
            xhttp.open('GET','SkillControl?skillAction=getAnotherSkillViewpublic',true);
            xhttp.send();
}

function showDegreeofSkill(str){
    if(str == ""){
        $('#degreetypeSkill').html("");
        $('#valueofdegree').html("");
    }else{
        if(str =="KeySkill"){
            $('#degreetypeSkill').html("<select class='form-control' name='namedegreetype' onchange='showValueofDegree(this.value);'><option value=''>Select Type Value</option><option value='Degree'>Degree</option><option value='Point'>Point</option></select>");
        }else{
            $('#valueofdegree').html("");
    }
    }   
}
function showValueofDegree(str){
    if(str ==""){
        $('#valueofdegree').html("");
         $('#periodSkill').html("");
    }else {
        if(str == "Degree"){
            $('#valueofdegree').html("<select class='form-control' name='degreeSkill'><option value='1'>1*</option><option value='2'>2*</option><option value='3'>3*</option><option value='4'>4*</option><option value='5'>5*</option></select>");
            $('#periodSkill').html("<div class='col-md-3 col-sm-3'><p>Since Year</p></div><div class='col-md-2 col-sm-2'><input class='form-control' type='text' autofocus name='yearSkill'></div>");
        }else{
            $('#valueofdegree').html("<input class='form-control' type='text' placeholder='Point of Skill' name='pointSkill' autofocus placeholder='Ex: 900/990'>")
             $('#periodSkill').html("");
        }
    }
    
}
