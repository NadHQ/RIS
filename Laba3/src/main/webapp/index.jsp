<%@ page contentType="text/html; charset=UTF-8" %>

<html>

<body>

<h3>Номер:</h3>

<form action="MainServlet" method="post">
    <input type="text" name="search">
    <button type="submit">Поиск</button>
</form>

<div>
    <%
        Object id = request.getAttribute("id");
        Object name = request.getAttribute("name");
        Object phnumber = request.getAttribute("phnumber");
        Object fnumber = request.getAttribute("fnumber");
        if (name == null || id == null || phnumber == null || fnumber == null) {
            out.println("<p>Введите номер</p>");
        } else {
            out.print("<p>Порядковый номер:\t" + id + "</p>");
            out.print("<p>ФИО:\t" + name + "</p>");
            out.print("<p>Номер телефона:\t" + phnumber + "</p>");
            out.print("<p>Номер факса:\t" + fnumber + "</p>");
        }
    %>
</div>

</body>

</html>
