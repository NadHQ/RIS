<%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 19.03.2021
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>Результат: </h1>
<% String result = (String) request.getAttribute("result");

    if (result == "OK") {
        out.println("<p>Сообщения отправлены!  </p>");
    } else {
        out.println("<p>Заполните поля!  </p>");
    }
%>
<div>
    <button onclick="location.href='/RIS_4_war'">Вернуться</button>
</div>
</center>
</body>
</html>
