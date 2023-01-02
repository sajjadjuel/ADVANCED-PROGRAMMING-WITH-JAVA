
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">
    <title>Add User</title>
    <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>
<body>
<section class="banner">
    <div id="popUp" class="popUp">
        <div class="container "> 
            <div class="popUp-content">
                <div class='top-logo justify-content-center text-center'>
                    <h1 style="text-align:center; background-color:Black; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>
                    <br>
                </div>
                <form   method="POST" style="text-align:center; border:1 ; background-color:darkgrey; margin: 0 auto;">
                       <button type="button" style="text-align:center; background-color:Black; color:white; padding:8px">Add User</button>                                           
                        
                       <a class="nav-link" href="AdminDash.php" title="Back" role="button" style="text-align:center; background-color:Black; color:white; padding:8px">Back</a>
                    <p></p>
                                                      
                <form action='AdminDash.php' method='POST' class='form_style signUpForm signUpForm_new' id="signUp_Form">
                    <label>* First Name : </label><br>
                    <input type='text' name='firstName' id='firstName'  placeholder='First name' required >
                    <p id='firstNameValidation' class='errorMsg'></p>
         
                    <label>* Sur Name : </label><br>
                    <input type='text' name='surName' id='surName' placeholder='Sur name' required >
                    <p id='surNameValidation' class='errorMsg'></p>

                    <label>* User Name : </label><br>
                    <input type='text' name='userName' id='user' placeholder='User name' required>
                    <p id='userNameValidation' class='errorMsg'></p>

                    <label>* Password : </label><br>
                    <input type="text" name="password" id="password" placeholder="Enter a new password" required>
                    <p id="passwordValidation" class="errorMsg"></p>

                    <label>* Gender : </label><br>
                    <select name="gender" id="gender" cssStyle="background-color: black; color: aliceblue; padding: 5px">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                      </select>
                    <p id="genderValidation" class="errorMsg"></p>


                    <div class="signUpFooter">                
                        <p>By clicking SignUp, you agree to our <a href='#'>terms and policies</a> and <a href='#'> cookies policies</a>.</p>
                        <input type="submit" class="button submitButton" name="SignUp" value="Add User" onclick ="signUpValidation()">
                    </div> 
                </form></form>
            </div>
        </div>
    </div>
</section>
</body>
<script>
    function signUpValidation(){    
    var firstName = document.getElementById("firstName").value;
    var surName = document.getElementById("surName").value;
    var name = firstName+" "+surName;
    var userName = document.getElementById("user").value.toLowerCase();
    var userPass = document.getElementById("password").value;
    var gender = document.getElementById("gender").value; 

    let  json = {
                  "user_name": userName,
                  "password": userPass, 
                  "name": name,
                  "gender": gender
                };
    let data = JSON.stringify(json);
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(data);

}
</script>
</html>