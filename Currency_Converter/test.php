<!DOCTYPE html>
<html>
<body>
<h2>Exchange Rate</h2>
<form method="post">
  <input type="number" name="currency" id="currency" value="">
  <input type="submit" name="submit" value="submit" onclick="MyAjaxFunc()">
  
</form>
<script>
function MyAjaxFunc() {
  var amnt = document.getElementById("currency").value;

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {

    if (this.readyState == 4 && this.status == 200) {
      var json =JSON.parse(xhttp.responseText) 
      
      var amount=json.rate;
      alert("Converted Amount: " +(amount*amnt));
    }

        };
    xhttp.open("POST", "http://localhost:8080/spring_webmvc_war_exploded/hello/currency/rate", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
  };

</script>

</body>
</html>
