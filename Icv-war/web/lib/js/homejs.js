$(window).ready(function(){
        var xhttp;
        xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function (){
            if(this.readyState == 4 && this.status ==200){
                document.getElementById("comment").innerHTML = this.responseText;                
            }
        };
        xhttp.open('GET', 'getComment?action=getComment',true);
        xhttp.send();
    });
    