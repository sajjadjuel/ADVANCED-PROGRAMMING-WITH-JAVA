<?php
include('header.php');
if (isset($_POST['edit'])){
    $id=$_REQUEST['edit'];  
}
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">
    <title>Update User</title>
    <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>
<body>
<section class="banner">
    <div id="popUp" class="popUp">
        <div class="container "> 
            <div class="popUp-content">
                    <h1 style="text-align:center; background-color:Black; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>
                    
                <form   method="POST" action="AdminDash.php" id="edtUsr"style="text-align:center; border:1 ; background-color:darkgrey; margin: 0 auto;" hidden>
                    <p id="demo"></p>
                       <button type="button" style="text-align:center; background-color:Black; color:white; padding:8px">Update User</button>                                           
                        
                       <a  href="AdminDash.php" title="Back" role="button" style="text-align:center; background-color:Black; color:white; padding:8px">Back</a>
                    <p></p>
                                                     
                <form action='AdminDash.php' method='POST' class='form_style signUpForm signUpForm_new' id="signUp_Form">
                    <label>* First Name : </label><br>
                    <input type='text' name='firstName' id='firstName'  placeholder='First name' required="required" >
                    <p id='firstNameValidation' class='errorMsg'></p>
         
                    <label>* Sur Name : </label><br>
                    <input type='text' name='surName' id='surName' placeholder='Sur name' required="required" >
                    <p id='surNameValidation' class='errorMsg'></p>

                    <label>* User Name : </label><br>
                    <input type='text' name='userName' id='user' placeholder='User name' required="required">
                    <p id='userNameValidation' class='errorMsg'></p>

                    <label>* Password : </label><br>
                    <input type="text" name="password" id="password" placeholder="Enter a new password" required="required">
                    <p id="passwordValidation" class="errorMsg"></p>

                    <label>* Gender : </label><br>
                    <select name="gender" id="gender" cssStyle="background-color: black; color: aliceblue; padding: 5px">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                      </select>
                    <p id="genderValidation" class="errorMsg"></p>
                        <input type="submit" name="update" value="Update" onclick ="signUpValidation()">
                    </div> 
                </form>
            </form>
            </div>
        </div>
    </div>
</section>
</body>
<script >
    const dbParam = JSON.stringify({table:"User"});
    const id = "<?php echo $id; ?>";
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
      const myObj = JSON.parse(xhttp.responseText);
      userName=myObj.user_name;
            text = "<table border='1' ><thead><tr>"
            text+= "<th>ID</th><th>Name</th><th>User Name</th><th>Gender</th>"
            text+= "</tr></thead>"
                text +="<td>" + myObj.id + "</td>"
                text +="<td>" + myObj.name + "</td>"
                text +="<td>" + myObj.user_name + "</td>"
                text +="<td>" + myObj.gender + "</td>"
                text += "</tr>";
            text += "</table>"  
            //alert(myObj.status);
            if(myObj.status != "NOT_FOUND"){
                document.getElementById("edtUsr").hidden = false;
                document.getElementById("demo").innerHTML = text;
                document.getElementById("user").placeholder = user_name;

            }
            else
            {
                alert("User Not Found!");
                window.location.replace("AdminDash.php")
            }
      
      
    }
        xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/"+id, true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();

    function signUpValidation(){    
    var firstName = document.getElementById("firstName").value;
    var surName = document.getElementById("surName").value;
    var name = firstName+" "+surName;
    var user = document.getElementById("user").value.toLowerCase();
    var userPass = document.getElementById("password").value;
    var gender = document.getElementById("gender").value; 

    let  json = {
                  "user_name": user,
                  "password": userPass, 
                  "name": name,
                  "gender": gender
                };
    let data = JSON.stringify(json);
    var xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/"+userName, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(data);

}
</script>
</html>