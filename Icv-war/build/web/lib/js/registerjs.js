    $(document).ready(function(){
        $("#inputPassword1").change(function (){
            var pattern = new RegExp('^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{6,}$');
            if(pattern.test(document.getElementById("inputPassword1").value.toString())){
                $('#btnSubmit').prop('disable',true);
            }else{                
                alert("Error Password: \nPassword must have lower case, upper case and digit and more than 6 character!");
                document.getElementById("inputPassword1").focus();
            }
            
        });
        
        $("#inputPassword2").focusout(function(){
            var pass1 = document.getElementById("inputPassword1").value.toString();
          var pass2 = document.getElementById("inputPassword2").value.toString();
          if(pass1!== pass2){
          
              document.getElementById("errorComfirmPassword").innerHTML="Error!";
              document.getElementById("errorComfirmPassword").focus();
              $('#btnSubmit').prop('disable',true);
          }
          else{
              
              $('#btnSubmit').prop('disable',false);
              document.getElementById("errorComfirmPassword").innerHTML="Ok";
          }
        }); 
        
        
        
        $("#btnSubmit").click(function (){
            var xhttp;
            xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function (){
                if(this.readyState==4 && this.status==200){
                    //document.getElementById("errorUsername").innerHTML = this.responseText;
                    
                }
            };
           // xhttp.open('POST','AccountControl?action=checkandregister&username=' + document.getElementById('inputUserName').value.toString() + "&password=" + $('#inputPassword1').val().toString()+'&firstName='+$('#inputFirstName').val().toString()+'&lastName='+$('#inputLastName').val().toString(),
          //  true);
            xhttp.send();
        });
                      
    });
    
