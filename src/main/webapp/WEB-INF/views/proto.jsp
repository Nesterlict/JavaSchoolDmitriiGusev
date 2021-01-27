<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Options</title>
    <style type="text/css">
        TABLE {
            border-collapse: collapse
        }
        TD {
            text-align: center;
        }
        TH, TD {
            border: 1px solid black;
            padding: 4px;
        }
    </style>
</head>
<body>

<h2>Options</h2>
<table>
    <tr>
        <th>optionId</th>
        <th>name</th>
        <th>description</th>
        <th>price</th>
        <th>connectionPrice</th>
    </tr>
    <c:forEach var="option" items="${optionList}">
        <tr>
            <td>${option.optionID}</td>
            <td>${option.name}</td>
            <td>${option.description}</td>
            <td>${option.price}</td>
            <td>${option.connectionPrice}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>