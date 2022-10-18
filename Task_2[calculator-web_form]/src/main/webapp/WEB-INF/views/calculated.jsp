<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 10/11/2022
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
  <title>Welcome</title>
</head>
<body>
<form method="post" action="v2">
  <label for="firstvalue">First Value:</label>
  <input type="number" name="firstvalue" id="firstvalue"/>
  <label for="operator">operator:</label>
  <input type="text" name="operator" id="operator"/>
  <label for="secondvalue">Second Value:</label>
  <input type="number" name="secondvalue" id="secondvalue"/>

  <br><br>

  <input type="submit" value="Calculate">
</form>
<p>Result : <% out.println(request.getAttribute("result")); %>

</p>

</h1>
</body>
</html>
