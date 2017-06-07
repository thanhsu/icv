$(window).ready(function(){
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function (){
        if(this.readyState ==4 && this.status==200){
            document.getElementById('listCareer').innerHTML= this.responseText;
        }
    };
    xhttp.open('GET','EducationControl?educationAction=getListCareer',true);
    xhttp.send();
});

$(window).ready(function(){
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState ==4 && this.status==200){
            document.getElementById('listSchool').innerHTML= this.responseText;
        }
    };
    xhttp.open('GET','EducationControl?educationAction=getListSchool',true);
    xhttp.send();
});

$(window).ready(function(){
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange= function(){
        if(this.readyState ==4 && this.status ==200){
            document.getElementById('listSkill').innerHTML =this.responseText;
        }
    };
    xhttp.open('GET','SkillControl?skillAction=getListSkill',true);
    xhttp.send(); 
});


$(window).ready(function(){
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange= function(){
        if(this.readyState ==4 && this.status ==200){
            document.getElementById('listCompany').innerHTML = this.responseText;
        }   
    };
    xhttp.open('GET','ExperiencesControl?experiencesAction=getListCompany',true);
    xhttp.send(); 
});




