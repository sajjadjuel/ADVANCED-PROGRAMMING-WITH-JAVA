<?php 
  include('header.php');
?>
<html style="background-color: blanchedalmond;">
<head>
  <title>Income Tax Calculator Bangladesh</title>
  <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>
<body>

<h1 style="text-align:center; background-color:Black; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>

<table border="0" >
  <tr><td>
<form method="post" action="History.php" >

  <input type="submit" name="history" value="View Calculation History" style="background-color: cornflowerblue; padding: 6px; color: black;" >

</form>
<form method="post" action="addUser.php" >

  <input type="submit" name="addUser" value="Add New User" style="background-color: cornflowerblue; padding: 6px; color: black;" >

</form>

<form method="post" action="viewCategory.php" >

  <input type="submit" name="category" value="View Category" style="background-color: cornflowerblue;font-family: cursive; padding: 6px; color: black;" >

</form>

<form method="post" action="addCategory.php" >

  <input type="submit" name="category" value="Add New Category" style="background-color: cornflowerblue; padding: 6px; color: black;">

</form>
<form method="post" action="logout.php" >

  <input type="submit" name="logout" value="Logout" style="background-color: cornflowerblue;font-family: cursive; padding: 6px; color: black;" >

</form>




  <input type="submit" name="UserList" value="View User List" style="background-color: cornflowerblue; padding: 6px; color: black;" onclick="userList()" >

</td><td></td><td>
  <fieldset align="center" id="usr" hidden>
  <p id="userHistory" align="center" ></p>

  <form method="DELETE" id="del" align="center" hidden>
  <b style="padding: 0.25%;"><label for ="edit">Delete User</label></b>
  <input type="number" name="delete" id="delete" placeholder="Delete by  Id" value="">
  <input type="submit" name="submit" value="Delete" onclick="MyDeleteFunc()">
</form>

  <form method="POST" action="editUser.php" id="edt" align="center" hidden>
  <b style="padding: 0.25%;"><label for ="edit">Edit User</label></b>
  <input type="number" name="edit" id="edit" placeholder="Edit by  Id" value="">
  <input type="submit" name="submit" value="Edit">
</form></fieldset>

</td></tr></table>





  

<script>
function userList(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            text = "<table border='1' ><thead><tr>"
            text+= "<th>ID</th><th>User Name</th><th>Name</th>"
            text+= "</tr></thead>"
            for (x in myObj) {
                text += "<tr class='mr-1'>"
                text +="<td>" + myObj[x].id + "</td>"
                text +="<td>" + myObj[x].user_name + "</td>"
                text +="<td>" + myObj[x].name + "</td>"
                text += "</tr>";
            }
            text += "</table>"   
            document.getElementById("userHistory").innerHTML = text;
            document.getElementById("del").hidden = false;
            document.getElementById("edt").hidden = false;
            document.getElementById("usr").hidden = false;
        }
    };

    xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();

  }

function MyDeleteFunc() {
  var id = document.getElementById("delete").value;

  var xhttp = new XMLHttpRequest();
 
    xhttp.open("DELETE", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/"+id, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(); 
    userList();  
  };

  function MyEditFunc() {
  var id = document.getElementById("edit").value;

  var xhttp = new XMLHttpRequest();
 
    xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/"+id, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(); 

      
  };



</script>

</body>
</html>
