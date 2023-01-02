<html style="background-color: darkgray;">
<head>
  <title>Income Tax Calculator Bangladesh</title>
  <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>
<body>
  <h1 style="text-align:center; background-color:Black; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>

<h2>Tax History</h2>

<p id="demo"></p>
<p id="delete"></p>
<form method="DELETE">
  <b style="padding: 0.25%;"><label for ="edit">Delete User</label></b>
  <input type="number" name="delete" id="delete" placeholder="Delete by  Id" value="">
  <input type="submit" name="submit" value="Delete" onclick="MyDeleteFunc()">
</form>
<form method="GET">
  <b style="padding: 0.25%;"><label for ="edit">Edit User</label></b>
  <input type="number" name="edit" id="edit" placeholder="Edit by  Id" value=""/>
  <input type="submit" name="edit" value="Edit" onclick="MyEditFunc()">
</form>
  

  
</form>


<script>
const dbParam = JSON.stringify({table:"History"});
const xhttp = new XMLHttpRequest();
xhttp.onload = function() {
  const myObj = JSON.parse(xhttp.responseText);
  let text = "<table border='1'>"
  text += "<tr><td>" + "ID" + "</td><td>" + "User Name" + "</td><td>" + "Name" + "</td></tr>";
  for (let x in myObj) {
    text += "<tr><td>" + myObj[x].id + "</td><td>" + myObj[x].user_name + "</td><td>" + myObj[x].name + "</td></tr>";
  }
  text += "</table>"    
  document.getElementById("demo").innerHTML = text;
}
    xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("x=" + dbParam);
      
</script>
<script>
function MyDeleteFunc() {
  var id = document.getElementById("delete").value;

  var xhttp = new XMLHttpRequest();
 
    xhttp.open("DELETE", "http://localhost:8080/spring_webmvc_war_exploded/user/usr/"+id, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();   
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