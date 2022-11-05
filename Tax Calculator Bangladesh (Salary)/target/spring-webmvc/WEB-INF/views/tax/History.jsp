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
        <th>Category</th>
        <th>Zone</th>
        <th>Basic Salary</th>
        <th>House Rent</th>
        <th>Medical Allowance</th>
        <th>Conveyance</th>
        <th>Incentive/OT</th>
        <th>Festival Bonus</th>
        <th>Invest</th>
        <th>Tax</th>
        <th>Calculate Date</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${taxs}" var="taxs">
        <tr>
            <td align="center">${taxs.id}</td>
            <td align="center">${taxs.category}</td>
            <td align="center">${taxs.zone}</td>
            <td align="center">${taxs.basic}</td>
            <td align="center">${taxs.rent}</td>
            <td align="center">${taxs.medical}</td>
            <td align="center">${taxs.conveyance}</td>
            <td align="center">${taxs.ot}</td>
            <td align="center">${taxs.bonus}</td>
            <td align="center">${taxs.investment}</td>
            <td align="center">${taxs.taxes}</td>
            <td align="center">${taxs.createdOn}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>