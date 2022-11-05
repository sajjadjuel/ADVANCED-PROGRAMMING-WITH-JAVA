<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/2/2022
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Salary Income Tax Calculator</title>
    <link rel = "icon" href ="https://cdn2.vectorstock.com/i/1000x1000/43/16/flat-design-tax-calculation-vector-7724316.jpg" type = "image/x-icon">
</head>
<body>

<h1>Calculation History</h1>

<table border="1" style="background-color: black; color: cornsilk">
    <thead>
    <tr>
        <th>Id</th>
        <th>Rent Exemption Rate</th>
        <th>Rent Exemption Value</th>
        <th>Medical Exemption Rate</th>
        <th>Medical Exemption Value</th>
        <th>Conveyance Value</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${taxs}" var="taxs">
        <tr>
            <c:url var="updateLink" value="/taxs/edit">
                <c:param name="variableId" value="1" />
            </c:url>
            <td align="center">${taxs.rentExemptionRate}</td>
            <td align="center">${taxs.rentExemptionSet}</td>
            <td align="center">${taxs.medicalExemptionRate}</td>
            <td align="center">${taxs.medicalExemptionSet}</td>
            <td align="center">${taxs.conveyanceSet}</td>
            <td><a href="${updateLink}">Update</a>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>