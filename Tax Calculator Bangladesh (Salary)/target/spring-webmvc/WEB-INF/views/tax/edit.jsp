<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/5/2022
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Record</title>
</head>
<body>

<h1>Edit Record</h1>

<form:form action="update" modelAttribute="tax">

    <label for="variableId">Id:</label>
    <form:input path="variableId" id="for" readonly="true"/>
    <form:errors path="variableId"/>

    <table width="50%" border="2" style="background-color: darkslategrey; color: aliceblue">
        <tr>
            <th><b>Area</b>  </th>
            <th><b>Amount/Percentage</b> </th>
        </tr>
        <tr>
            <th><b><b style="padding: 0.25%;"><lebel for ="rentExemptionRate">House Rent Exemption Rate</lebel></b><br></b>  </th>
            <th><form:input type="number" step="0.01" path="rentExemptionRate" id="rentExemptionRate" required="required"/>
                <form:errors path="rentExemptionRate"/>
            </th>
        </tr>
        <tr>
            <th><b><b style="padding: 0.25%;"><lebel for ="rentExemptionSet">House Rent Exemption</lebel></b><br></b>  </th>
            <th><form:input type="number" path="rentExemptionSet"  id="rentExemptionSet" required="required"/>
                <form:errors path="rentExemptionSet"/>
            </th>
        </tr>
        <tr>
            <th><b><b style="padding: 0.25%;"><lebel for ="medicalExemptionRate">Medical Allowance Rate</lebel></b><br></b>  </th>
            <th><form:input type="number" step="0.01" path="medicalExemptionRate" id="medicalExemptionRate" required="required"/>
                <form:errors path="medicalExemptionRate"/>
            </th>
        </tr>
        <tr>
            <th><b><b style="padding: 0.25%;"><lebel for ="medicalExemptionSet">Medical Allowance Value</lebel></b><br></b>  </th>
            <th><form:input type="number" path="medicalExemptionSet" id="medicalExemptionSet" required="required"/>
                <form:errors path="medicalExemptionSet"/>
            </th>
        </tr>
        <tr>
            <th><b><b style="padding: 0.25%;"><lebel for ="conveyanceSet">Conveyance</lebel></b><br></b>  </th>
            <th><form:input type="number" path="conveyanceSet" id="conveyanceSet" required="required"/>
                <form:errors path="conveyance"/>
            </th>
        </tr>

    </table><br>


    <br><br>

    <input type="submit">

</form:form>

</body>
</html>
