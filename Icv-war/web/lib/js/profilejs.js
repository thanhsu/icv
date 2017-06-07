
$(window).ready(function (){
   var xhttp;
   xhttp =new XMLHttpRequest();
   xhttp.onreadystatechange = function (){
     if(this.readyState ==4 && this.status ==200){
         document.getElementById('info_Education').innerHTML = this.responseText;
     }  
   };
   xhttp.open('GET','EducationControl?educationAction=getView',true);
   xhttp.send();
});


$(window).ready(function (){
   var xhttp;
   var url = window.location.pathname;  
   xhttp =new XMLHttpRequest();
   xhttp.onreadystatechange = function (){
     if(this.readyState ==4 && this.status ==200){
         document.getElementById('info_Key_Skill').innerHTML = this.responseText;
     }  
   };
   xhttp.open('GET','SkillControl?skillAction=getKeySkillView',true);
   xhttp.send();
});

$(window).ready(function(){
    var xhttp;
    xhttp= new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if(this.readyState==4 && this.status ==200){
            document.getElementById('modal_body_editActivity').innerHTML = this.responseText;   
        }  
    };
    xhttp.open('GET','ActivityControl?activityAction=getActivityModal',true);
    xhttp.send();
});

$(window).ready(function(){
    var xhttp;
    xhttp= new XMLHttpRequest();
    xhttp.onreadystatechange = function (){
        if(this.readyState==4 && this.status ==200){
            document.getElementById('modal_body_editPrize').innerHTML = this.responseText;   
        }  
    };
    xhttp.open('GET','ActivityControl?activityAction=getPrizeModal',true);
    xhttp.send();
});

$(window).ready(function(){
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState==4 && this.status ==200){
            document.getElementById('videoIntroduce').innerHTML= this.responseText;
        }  
    };
    xhttp.open('GET','ProfileControl?profileAction=getVideoIntroduce',true);
    xhttp.send();
});


//$(window).ready(function (){
//   var xhttp;
//   var url = window.location.pathname;  
//  xhttp =new XMLHttpRequest();
//   xhttp.onreadystatechange = function (){
//     if(this.readyState ==4 && this.status ==200){
//         document.getElementById('info_Another_Skill').innerHTML = this.responseText;
//     }  
//   };
//   xhttp.open('GET','http://localhost:53172/Icv-war/SkillControl?skillAction=getAnotherSkillView',true);
//   xhttp.send();
//});

$(window).ready(function (){
   var xhttp;
   xhttp =new XMLHttpRequest();
   xhttp.onreadystatechange = function (){
     if(this.readyState ==4 && this.status ==200){
         document.getElementById('info_Experiences').innerHTML = this.responseText;
     }  
   };
   xhttp.open('GET','ExperiencesControl?experiencesAction=getView',true);
   xhttp.send();
});

$(window).ready(function (){
   var xhttp;
   xhttp =new XMLHttpRequest();
   xhttp.onreadystatechange = function (){
     if(this.readyState ==4 && this.status ==200){
         document.getElementById('info_Activity').innerHTML = this.responseText;
     }  
   };
   xhttp.open('GET','ActivityControl?activityAction=getView',true);
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
    xhttp.open('GET','getComment?commentAction=getPeopleView',true);
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
function getAnotherSkill(){
            var xhttp;
            //var url = window.location.pathname;  
            xhttp =new XMLHttpRequest();
            xhttp.onreadystatechange = function (){
              if(this.readyState ==4 && this.status ==200){
                  document.getElementById('info_Another_Skill').innerHTML = this.responseText;
              }  
            };
            xhttp.open('GET','SkillControl?skillAction=getAnotherSkillView',true);
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
