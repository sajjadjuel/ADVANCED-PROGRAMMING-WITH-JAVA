
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">
    <title>Add Category</title>
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
                       <button type="button" style="text-align:center; background-color:Black; color:white; padding:8px">Add Category</button>                                           
                        
                       <a class="nav-link" href="AdminDash.php" title="Back" role="button" style="text-align:center; background-color:Black; color:white; padding:8px">Back</a>
                    <p></p>
                                                      
                <form action='AdminDash.php' method='POST' class='form_style signUpForm signUpForm_new' id="signUp_Form">
                    <label for ="category"><b style="padding: 0.25%;">Choose A Category</b></label><br>
                      <select name="category" id="category" style="margin-top: 10px; margin-bottom: 10px;font-family: cursive, sans-serif; outline: 0;   border: 1px solid crimson; padding: 4px; border-radius: 9px;">
                        <option value="General">General</option>
                        <option value="Female/Senior Citizen">Female/Senior Citizen</option>
                        <option value="Disabled">Disabled</option>
                        <option value="Gazetted Freedom Fighters">Gazetted Freedom Fighters</option>
                      </select>
                      <br>
                    <b><b style="padding: 0.25%;"><label for ="base">Base Amount</label></b><br></b>
                    <input type="number" style="margin-top: 10px; margin-bottom: 10px;font-family: cursive, sans-serif; outline: 0;   border: 1px solid crimson; padding: 4px; border-radius: 9px;" name="base" value="0" id="base" required="required"/>
                    <br>

                        <input type="submit" style="margin-top: 10px; margin-bottom: 10px;font-family: cursive, sans-serif; outline: 0;   border: 1px solid crimson; padding: 4px; border-style: ridge;"  name="add" value="Add Category" onclick ="addCategory()">
                    </div> 
                </form></form>
            </div>
        </div>
    </div>
</section>
</body>
<script>
    function addCategory(){    
    var category = document.getElementById("category").value;
    var base = document.getElementById("base").valueAsNumber;

    let  json = {
                  "category": category,
                  "base": base, 
                };
    let data = JSON.stringify(json);
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/spring_webmvc_war_exploded/category/cat/", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(data);

}
</script>
</html>