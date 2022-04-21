<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Введите 10 сообщений:</h2>
<center>
<form action="Servlet" method="post">
    <label> Сообщения:
        <textarea name="messages" cols="50" rows="10"></textarea>
    </label>
    <input name="button" type="submit" value="Отправить">
</form>
</center>
</body>
</html>
