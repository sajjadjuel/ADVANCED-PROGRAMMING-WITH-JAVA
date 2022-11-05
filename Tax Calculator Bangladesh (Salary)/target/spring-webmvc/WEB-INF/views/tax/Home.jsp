<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/2/2022
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Income Tax Calculator Bangladesh</title>
  <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>
<body>

<h1 style="text-align:center; background-color:Black; color:white; padding:8px">Income Tax Calculator Bangladesh (Salary)</h1>

<form:form action="calculate" modelAttribute="tax">
  <lebel for ="category"><b style="padding: 0.25%;">Choose Tax Payer Category</b></lebel><br>
  <form:select path="category" id="category" cssStyle="background-color: black; color: aliceblue; padding: 5px">
    <form:option value="General">General</form:option>
    <form:option value="Female/Senior Citizen">Female/Senior Citizen</form:option>
    <form:option value="Disabled">Disabled</form:option>
    <form:option value="Gazetted Freedom Fighters">Gazetted Freedom Fighters</form:option>
  </form:select>
  <form:errors path="category"/>
  <br><br>

  <lebel for ="zone"><b style="padding: 0.25%;">Choose Zone</b></lebel><br>
  <form:select path="zone" id="zone"  cssStyle="background-color: black; color: aliceblue; padding: 5px">
    <form:option value="Dhaka/Chattagram City">Dhaka/Chattagram City</form:option>
    <form:option value="Other City">Other City</form:option>
    <form:option value="Rest of the Country">Rest of the Country</form:option>
  </form:select>
  <form:errors path="zone"/>
  <br><br>

  <b style="padding: 0.25%;">Salary Breakdown<sup>*</sup></b>
  <table width="50%" border="2" style="background-color: darkslategrey; color: aliceblue">
    <tr>
      <th><b>Area</b>  </th>
      <th><b>Amount</b>  </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><lebel for ="basic">Basic Salary</lebel></b><br></b>  </th>
      <th><form:input type="number" path="basic" value="0" id="basic" required="required"/>
        <form:errors path="basic"/>
      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><lebel for ="rent">House Rent</lebel></b><br></b>  </th>
      <th><form:input type="number" path="rent" value="0" id="rent" required="required"/>
        <form:errors path="rent"/>
      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><lebel for ="medical">Medical Allowance</lebel></b><br></b>  </th>
      <th><form:input type="number" path="medical" value="0" id="medical" required="required"/>
        <form:errors path="medical"/>
      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><lebel for ="conveyance">Conveyance</lebel></b><br></b>  </th>
      <th><form:input type="number" path="conveyance" value="0" id="conveyance" required="required"/>
        <form:errors path="conveyance"/>
      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><lebel for ="ot">Incentive/OT</lebel></b><br></b>  </th>
      <th><form:input type="number" path="ot" value="0" id="ot" required="required"/>
        <form:errors path="ot"/>
      </th>
    </tr>
    <tr>
      <th><b><b style="padding: 0.25%;"><lebel for ="bonus">Festival Bonus</lebel></b><br></b>  </th>
      <th><form:input type="number" path="bonus" value="0" id="bonus" required="required"/>
        <form:errors path="bonus"/>
      </th>
    </tr>
  </table><br>

  <b style="padding: 0.25%;">Investment</b>
  <table width="50%" border="2" style="background-color: darkslategrey; color: aliceblue">
    <tr>
      <th><b><b style="padding: 0.25%;"><lebel for ="investment">Investment Amount</lebel></b><br></b>  </th>
      <th><form:input type="number"  path="investment" value="0" id="investment" required="required"/>
        <form:errors path="investment"/>
      </th>
    </tr>
  </table>

  <br><br>

  <input type="submit" value="Calculate" style="background-color: cornflowerblue; color: white; padding: 6px">
  <input type="reset" style="background-color: cornflowerblue; padding: 6px; color: white">

</form:form>

</body>
</html>
