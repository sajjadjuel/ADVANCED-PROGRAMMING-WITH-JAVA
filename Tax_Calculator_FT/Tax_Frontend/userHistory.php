<?php
    include('header.php');
    $id= $_REQUEST['id'];
?>
<html style="background-color: darkgray;">
<head>
  <title>Income Tax Calculator Bangladesh</title>
  <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>
<body>
  <h1 style="text-align:center; background-color:Black; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>

  <a class="nav-link" href="test.php?user_id=<?php echo $id; ?>" title="Back" role="button" style="text-align:center; background-color:Black; color:white; padding:8px">Back</a>

<h2>Your Calculate History</h2>

<p id="demo"></p>

<script>
const dbParam = JSON.stringify({table:"History"});
const id = "<?php echo $id; ?>";
//alert(id);
const xhttp = new XMLHttpRequest();
xhttp.onload = function() {
  const myObj = JSON.parse(xhttp.responseText);
  let text = "<table border='1'>"
  text += "<thead><tr><td>" + "Tax_ID" + "</td><td>" + "User Id" + "</td><td>" + "Category" + "</td><td>" + "Zone" + "</td><td>" + "Salary" + "</td><td>" + "Rent" + "</td><td>" + "Medical Expense" + "</td><td>" + "Conveyance" + "</td><td>" + "OT" + "</td><td>" + "Bonus" + "</td><td>" + "Invest" + "</td><td>" + "Tax" + "</td></tr></thead>";
  for (let x in myObj) {
    text += "<tr><td>" + myObj[x].id + "</td><td>" + myObj[x].user_id + "</td><td>" + myObj[x].category + "</td><td>" + myObj[x].zone + "</td><td>" + myObj[x].salary + "</td><td>" + myObj[x].rent + "</td><td>" + myObj[x].medical + "</td><td>" + myObj[x].conveyance + "</td><td>" + myObj[x].ot + "</td><td>" + myObj[x].bonus + "</td><td>" + myObj[x].invest + "</td><td>" + myObj[x].tax + "</td></tr>";
  }
  text += "</table>"    
  document.getElementById("demo").innerHTML = text;
}
    xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/tax/tax_history/"+id, true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send();
      
</script>

</body>
</html>