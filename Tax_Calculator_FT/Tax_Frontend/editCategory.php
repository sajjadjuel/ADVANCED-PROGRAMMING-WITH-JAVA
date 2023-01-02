<?php
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
                    
                <form   method="POST" action="AdminDash.php" id="edtCat"style="text-align:center; border:1 ; background-color:darkgrey; margin: 0 auto;" hidden>
                    <p id="demo"></p>
                       <button type="button" style="text-align:center; background-color:Black; color:white; padding:8px; font-family: cursive;">Update Category</button>                                           
                        
                       <a  href="AdminDash.php" title="Back" role="button" style="text-align:center; background-color:Black; color:white; font-family: cursive ; padding:8px">Back</a>
                    <p></p>
                                                     
                <form action='AdminDash.php' method='POST'  id="editForm">
         
                    <label>* Updated Category : </label><br>
                    <input type='text' name='category' id='category' readonly ><br>

                    <label>* Base Amount : </label><br>
                    <input type='number' name='base' id='base' placeholder='New base amount' required="required">
                    <p id='userNameValidation' class='errorMsg'></p>

                        <input type="submit" name="update" value="Update" onclick ="Update()">
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
      baseCategory=myObj.category;
      document.getElementById("category").value=baseCategory;
            text = "<table border='1' ><thead><tr>"
            text+= "<th>ID</th><th>Category</th><th>Base Amount</th>"
            text+= "</tr></thead>"
                text +="<td>" + myObj.id + "</td>"
                text +="<td>" + myObj.category + "</td>"
                text +="<td>" + myObj.base + "</td>"
                text += "</tr>";
            text += "</table>"  
            //alert(myObj.status);
            if(myObj.status != "NOT_FOUND"){
                document.getElementById("edtCat").hidden = false;
                document.getElementById("demo").innerHTML = text;
                document.getElementById("user").placeholder = user_name;

            }
            else
            {
                alert("Category Not Found!");
                window.location.replace("AdminDash.php")
            }
      
      
    }
        xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/category/cat/"+id, true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();

    function Update(){    
    var category = document.getElementById("category").value;
    var base = document.getElementById("base").value;

    let  json = {
                  "category": baseCategory,
                  "base": base
                };
    let data = JSON.stringify(json);
    var xhttp = new XMLHttpRequest();
    xhttp.open("PUT", "http://localhost:8080/spring_webmvc_war_exploded/category/cat/"+baseCategory, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(data);

}
/*function getCategories(){ 
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
          if (this.readyState == 4 && this.status == 200) {
                myObj = JSON.parse(this.responseText);
                text = "";
                
                for (x in myObj) {
                   text+= "<option value='" + myObj[x].category + "'>"+myObj[x].category+"</option>"
                }
                document.getElementById("tax_payer_category").innerHTML = text;
          }
    };
    xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/category/cat/", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
}*/

/*const dbParam = JSON.stringify({table:"Category"});
const xhttp = new XMLHttpRequest();
xhttp.onload = function() {
  if (this.readyState == 4 && this.status == 200) {
                myObj = JSON.parse(this.responseText);
                text = "";
                
                for (x in myObj) {
                   text+= "<option value='" + myObj[x].category + "'>"+myObj[x].category+"</option>"
                }
                document.getElementById("tax_payer_category").innerHTML = text;
          }
      }
    xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/category/cat/", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();*/
</script>
</html>