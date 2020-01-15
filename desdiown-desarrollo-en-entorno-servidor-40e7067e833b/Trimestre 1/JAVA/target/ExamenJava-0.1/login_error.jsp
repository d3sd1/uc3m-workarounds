<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN_Java - Error de conexión</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Error de conexión<c:if test="${not empty errorMessage}">: <c:out value="${errorMessage}"></c:out></c:if></h1>
        <div><a href="/login">Pulsa aquí para volver al formulario</a></div>
    </body>
</html>
