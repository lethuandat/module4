<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 14/07/2022
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Spices</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form method="post">
    <label>
        <input type="checkbox" name="condiment" value="Lettuce">
    </label>Lettuce
    <label>
        <input type="checkbox" name="condiment" value="Tomato">
    </label>Tomato
    <label>
        <input type="checkbox" name="condiment" value="Mustard">
    </label>Mustard
    <label>
        <input type="checkbox" name="condiment" value="Sprouts">
    </label>Sprouts
    <div>
        <input type="submit" value="Save">
    </div>
    <div>
        <h3>Bánh sandwich của bạn có vị: ${spice}</h3>
    </div>
</form>

</body>
</html>
