<?php
    include('header.php');
    $id=$_REQUEST['user_id'];
?>
<html>
<head>
  <title>Income Tax Calculator Bangladesh</title>
  <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>
<body>

<h1 style="text-align:center; background-color:Black; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>

<form method="post" align="center">
    <P align="right">
    <a class="nav-link" href="userHistory.php?id=<?php echo $id; ?>" title="Back" role="button" style="text-align:center; background-color:Black; color:white; padding:8px;" >Previous calculation History</a>
    <a class="nav-link" href="logout.php" title="Logout" role="button" style="text-align:center; background-color: darkblue; color:white; padding:8px;" >Logout</a>
</P>
  <label for ="category"><b style="padding: 0.25%;">Choose Tax Payer Category</b></label><br>
    <select id='tax_payer_category' name='tax_payer_category' >                    
    </select>
    <br>

  <label for ="zone"><b style="padding: 0.25%;">Choose Zone</b></label><br>
  <select name="zone" id="zone"  cssStyle="background-color: black; color: aliceblue; padding: 5px">
    <option value="Dhaka/Chattagram City">Dhaka/Chattagram City</option>
    <option value="Other City">Other City</option>
    <option value="Rest of the Country">Rest of the Country</option>
  </select>

  <br><br>

  <b style="padding: 0.25%;">Salary Breakdown<sup>*</sup></b>
  <table width="50%" border="2" style="background-color: darkslategrey; color: aliceblue" align="center">
    <tr>
      <th><b>Area</b>  </th>
      <th><b>Amount</b>  </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><label for ="basic">Basic Salary</label></b><br></b>  </th>
      <th><input type="number" name="basic" value="0" id="basic" required="required"/>
      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><label for ="rent">House Rent</label></b><br></b>  </th>
      <th><input type="number" name="rent" value="0" id="rent" required="required"/>
        <errors name="rent"/>
      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><label for ="medical">Medical Allowance</label></b><br></b>  </th>
      <th><input type="number" name="medical" value="0" id="medical" required="required"/>

      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><label for ="conveyance">Conveyance</label></b><br></b>  </th>
      <th><input type="number" name="conveyance" value="0" id="conveyance" required="required"/>

      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><label for ="ot">Incentive/OT</label></b><br></b>  </th>
      <th><input type="number" name="ot" value="0" id="ot" required="required"/>
      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><label for ="bonus">Festival Bonus</label></b><br></b>  </th>
      <th><input type="number" name="bonus" value="0" id="bonus" required="required"/>

      </th>
    </tr>
  </table><br>

  <b style="padding: 0.25%;">Investment</b>
  <table width="50%" border="2" style="background-color: darkslategrey; color: aliceblue" align="center">
    <tr>
      <th><b><b style="padding: 0.25%;"><label for ="investment">Investment Amount</label></b><br></b>  </th>
      <th><input type="number"  name="investment" value="0" id="investment" required="required"/>
        
      </th>
    </tr>
  </table>

  <br><br>

  <input type="submit" name="submit" value="submit" onclick="MyAjaxFunc()">
  <input type="reset" style="background-color: cornflowerblue; padding: 6px; color: white">

</form>


  

<script>
   var tax;
    var taxable= 0;
    var taxableAmount= 0;
  
   function Calculation( Category,  Zone,  Basic,  Rent,  Medical,  Conveyance,  Ot,  Bonus)
    {
        var cal_tax = 0;

        if (Rent!=0) {
            var rentExemption=0;
            rentExemption=Basic*.5;
            if(rentExemption>300000)
                rentExemption=300000;

            if (Rent > rentExemption) {
                Rent = Rent - rentExemption;
            } else {
                Rent = 0;
            }
        }
        if(Medical!=0) {
            var medicalExemption=0;
            medicalExemption=Basic*.1;
            if(medicalExemption>300000)
                medicalExemption=300000;
            if (Medical > medicalExemption) {
                Medical = Medical - medicalExemption;
            } else {
                Medical = 0;
            }
        }

        if(Conveyance!=0) {
            if (Conveyance > 30000) {
                Conveyance = Conveyance - 30000;
            } else {
                Conveyance = 0;
            }
        }

        taxable= Basic+Rent+Medical+Conveyance+Bonus+Ot;
        taxableAmount=taxable;
        
            //cal_tax=generalCal(Category);
        /*Cate= categoryValue(Category);
        alert(Cate);*/

        if(Category=="General"){
            cal_tax=generalCal(300000);
        }
        else if (Category=="Female/Senior Citizen"){
            cal_tax=generalCal(350000);
        }
        else if (Category=="Disabled") {
            cal_tax=generalCal(450000);
        }
        else if (Category=="Gazetted Freedom Fighters") {
            cal_tax=generalCal(475000);
        }
        return cal_tax;
    }

    function generalCal(variable) {
        var cal_tax=0;
        if (taxable >variable) {
            taxable=taxable-variable;

            if (taxable > 100000) {
                taxable=taxable-100000;

                var calculated=100000*0.05;
                cal_tax = cal_tax + calculated;
            }
            else if (taxable < 100000) {

                var calculated=taxable*0.05;
                cal_tax=cal_tax + calculated;
                return cal_tax;
            }
            if (taxable > 300000) {
                taxable=taxable-300000;

                var calculated=300000*0.1;
                cal_tax=cal_tax + calculated;
            }
            else if (taxable < 300000) {

                var calculated=taxable*0.1;
                cal_tax = cal_tax + calculated;
                return cal_tax;
            }
            if (taxable > 400000) {
                taxable=taxable-400000;

                var calculated=400000*0.15;
                cal_tax = cal_tax + calculated;
            }
            else if (taxable < 400000) {

                var calculated=taxable*0.15;
                cal_tax = cal_tax + calculated;
                return cal_tax;
            }
            if (taxable > 500000) {
                taxable=taxable-500000;

                var calculated=500000*0.20;
                cal_tax = cal_tax + calculated;
            }
            else if (taxable < 500000) {

                var calculated=taxable*0.20;
                cal_tax=cal_tax + calculated;
                return cal_tax;
            }
            var calculated=taxable*0.25;
            cal_tax=cal_tax + calculated;
            return cal_tax;

        }
        else {cal_tax=0;}
        return cal_tax;
    }

    function rebate( calculate_tax, investment) {
        var finalTax=0;
        finalTax = calculate_tax-investment*.15;
        if(taxableAmount>=300000)
        {
            if(finalTax<=5000) {

                return 5000;
            }
        }
        if(finalTax<=0)
            return 0;
        return finalTax;
    }

    function categoryValue( Category_C )
    {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() 
        {
                    myObject = JSON.parse(this.responseText);
                    for (x in myObject) 
                    {
                       if(myObject[x].category == Category_C)
                       {
                            //alert(myObject[x].base);
                            return myObject[x].base;
                            /*alert(text);
                            return text;*/
                        }
                    }
        };
        xhttp.open("GET", "http://localhost:8080/spring_webmvc_war_exploded/category/cat/", true);
        xhttp.setRequestHeader("Content-type", "application/json");
        xhttp.send();
    }

function MyAjaxFunc() {

  var Category_C = document.getElementById("tax_payer_category").value;
  var Zone = document.getElementById("zone").value;
  var Basic = document.getElementById("basic").valueAsNumber;
  var Rent = document.getElementById("rent").valueAsNumber;
  var Medical = document.getElementById("medical").valueAsNumber;
  var Conveyance = document.getElementById("conveyance").valueAsNumber;
  var Ot = document.getElementById("ot").valueAsNumber;
  var Bonus = document.getElementById("bonus").valueAsNumber;
  var invest = document.getElementById("investment").valueAsNumber;
  const user_id = "<?php echo $id; ?>"; 

 /* Cate= categoryValue(Category_C);
  alert(Cate);*/

  tax_t= Calculation(Category_C, Zone, Basic, Rent, Medical, Conveyance, Ot, Bonus)
  payable_tax = rebate(tax_t,invest);
  alert("Your Tax is " +payable_tax)
   let json = {
                  "user_id":user_id,
                  "category":Category_C,
                  "zone":Zone,
                  "salary":Basic,
                  "rent":Rent,
                  "medical":Medical,
                  "conveyance":Conveyance,
                  "ot":Ot,
                  "bonus":Bonus,
                  "invest":invest,
                  "tax":payable_tax 
                };
    let data = JSON.stringify(json);

  var xhttp = new XMLHttpRequest();
  
    xhttp.open("POST", "http://localhost:8080/spring_webmvc_war_exploded/tax/calc/", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(data);
      
  
  };
const dbParam = JSON.stringify({table:"Category"});
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
    xhttp.send();

/*  function getCategories()
  {
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
    
</script>

</body>
</html>
