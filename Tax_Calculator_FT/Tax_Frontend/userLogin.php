<html lang="en">

<head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">
    <title>User Login</title>
    <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>

<body>
    <h1 style="text-align:center; background-color:Black; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>
  <main id="main-holder" align="center">
    <p align="center">
    <button type="button" style="text-align:center; background-color:Black; color:white; padding:8px">User Login</button>                                           
                        
        <a class="nav-link" href="index.php" title="Back" role="button" style="text-align:center; background-color:Black; color:white; padding:8px">Home Page</a>
        <p align="center"><a class="nav-link" href="Registration.php" title="Back" role="button" style="text-align:center; background-color:Black; color:white; padding:8px">Registration</a>
    </p>
    
    
    <form id="login-form" align="center" style="text-align:center; border:1 ; background-color:darkgrey; margin: 0 auto;">
    <label>* User Name : </label><br>
      <input type="text" name="username" id="username-field" class="login-form-field" placeholder="Username">
      <br>
      <label>* Password : </label><br>
      <input type="password" name="password" id="password-field" class="login-form-field" placeholder="Password">
      <br>
      <div id="login-error-msg-holder" style="color: darkred;" hidden>
      <p id="login-error-msg">Invalid username <span id="error-msg-second-line">and/or password</span></p>
    </div>
      <input type="submit" value="Login" id="login-form-submit">
    </form>
  
  </main>
</body>
<script >
    const loginForm = document.getElementById("login-form");
    const loginButton = document.getElementById("login-form-submit");
    const loginErrorMsg = document.getElementById("login-error-msg");

    loginButton.addEventListener("click", (e) => {
        e.preventDefault();
        const username = loginForm.username.value;
        const password = loginForm.password.value;

        
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
                myObj = JSON.parse(this.responseText);
                for (x in myObj) {
                    if (username === myObj[x].user_name && password === myObj[x].password )
                    {
                        <?php $_SESSION['status'] = true;
                            setcookie('status', 'true', time()+3600, '/');
                            ?>
                            window.location = "test.php?user_id="+myObj[x].id;

                    }
                    else {
            //loginErrorMsg.style.opacity = 1;
            document.getElementById("login-error-msg-holder").hidden=false
        }                    
                }
        };

        xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send();
    })
</script>

</html>