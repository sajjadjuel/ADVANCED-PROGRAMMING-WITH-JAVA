<html style="background-color: darkgray;">
<head>
  <title>Income Tax Calculator Bangladesh</title>
  <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>
<body>
  <h1 style="text-align:center; background-color:Black; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>

<h2 align="center" style="font-family: cursive;">Category List</h2>

<p id="demo" align="center"></p>
<p id="delete"></p>
<form method="DELETE" action="#" align="center">
    <b style="padding: 0.25%;"><label for ="dlt">Delete Category</label></b>
  <input type="number" name="dlt" id="dlt" placeholder="Delete by  Id" value="">
  <input type="submit" name="submit" value="Delete" onclick="MyDeleteFunc()">
  
</form>
<form method="POST" action="editCategory.php" id="edt" align="center">
  <b style="padding: 0.25%;"><label for ="edit">Edit Category</label></b>
  <input type="number" name="edit" id="edit" placeholder="Edit by  Id" value="">
  <input type="submit" name="submit" value="Edit">
</form>


<script>
const dbParam = JSON.stringify({table:"History"});
const xhttp = new XMLHttpRequest();
xhttp.onload = function() {
  const myObj = JSON.parse(xhttp.responseText);
  let text = "<table border='1'>"
  text += "<thead><tr><th>" + "ID" + "</th><th>" + "Category" + "</th><th>" + "Base Amount" + "</th></tr></thead>";
  for (let x in myObj) {
    text += "<tr><td>" + myObj[x].id + "</td><td>" + myObj[x].category + "</td><td>" + myObj[x].base  + "</td></tr>";
  }
  text += "</table>"    
  document.getElementById("demo").innerHTML = text;
}
    xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/category/cat/", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();
      
</script>
<script>
function MyDeleteFunc() {
  var id = document.getElementById("dlt").value;

  var xhttp = new XMLHttpRequest();
 
    xhttp.open("DELETE", "http://localhost:8080/spring_webmvc_war_exploded/category/cat/"+id, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();   
  };
</script>

</body>
</html>