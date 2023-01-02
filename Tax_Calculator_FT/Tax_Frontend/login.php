
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">
    <title>Login</title>
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
                       <button type="button" style="text-align:center; background-color:Black; color:white; padding:8px">Add User</button>                                           
                        
                       <a class="nav-link" href="AdminDash.php" title="Back" role="button" style="text-align:center; background-color:Black; color:white; padding:8px">Back</a>
                    <p></p>
                                                      
                <form  method='POST' style="text-align:center; border:1 ; background-color:darkgrey; margin: 0 auto;" id="signUp_Form">
                    

                    <label>* User Name : </label><br>
                    <input type='text' name='userName' id='user' placeholder='User name' required>
                    <p id='userNameValidation' class='errorMsg'></p>

                    <label>* Password : </label><br>
                    <input type="text" name="password" id="password" placeholder="Enter a new password" required>
                    <p id="passwordValidation" class="errorMsg"></p>
                    <div class="signUpFooter">                
                        <p>By clicking SignUp, you agree to our <a href='#'>terms and policies</a> and <a href='#'> cookies policies</a>.</p>
                        <input type="submit" class="button submitButton" name="SignUp" value="SignUp" onclick ="signUpValidation()">
                    </div> 
                </form></form>
            </div>
        </div>
    </div>
</section>
</body>
<script>    

    /*function userList(){
        var userName = document.getElementById("user").value.toLowerCase();
        var userPass = document.getElementById("password").value; 
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
                myObj = JSON.parse(this.responseText);
                for (x in myObj) {
                    if (myObj[x].user_name == userName && myObj[x].password == userPass )
                    {
                            window.location.href = "test.php";

                    }
                    
                }

        };

        xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send();

  }*/

    function login() {
      var username = document.getElementById('user').value;
      uname = username;
      var password = document.getElementById('password').value;
      var apiUrl = `http://localhost:8080/spring_webmvc_war_exploded/user/usr/`;
      hash = (username + ':' + password) // `Basic ${hash}`
      $.ajax({
        url: apiUrl,
        type: "GET",
        headers: {
          'Authorization': `Basic ${hash}`
        },
        data: {},
        dataType: 'text',
        success: function(result) {
          document.getElementById('usernamelogin').value = result;

          console.log(result)
        },
        error: function(err) {
          console.log("err-", err.responseText);
        }
      })
    }
</script>
</html>