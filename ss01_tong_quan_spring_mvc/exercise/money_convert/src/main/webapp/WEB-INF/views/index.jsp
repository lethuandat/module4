<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/07/2022
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>Currency Converter</h2>
<form method="post">
    <label>Rate: </label><br/>
    <input type="number" name="rate" required placeholder="RATE" value="${rate}"/><br/>
    <label>USD: </label><br/>
    <input type="number" name="usd" required placeholder="USD" value="${usd}"/><br/>
    <input type="submit" id="submit" value="Converter"/>
    <h3>Result: ${result} VNĐ</h3>
</form>
</body>
</html>
