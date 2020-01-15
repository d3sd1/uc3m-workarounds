<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error</title>
    </head>

    <body>
        <h1>¡Ha ocurrido un error!</h1>
        <p>

            <c:choose>
                <c:when test="${cod_error == 500}">Ha ocurrido un error en el servidor.</c:when>
                <c:when test="${cod_error == 400}">La llamada a la api fue incorrecta.</c:when>
                <c:when test="${cod_error == 401}">La clave API no está autorizada.</c:when>
                <c:when test="${cod_error == 406}">Error de integridad referencial. Prueba a forzar el borrado del usuario.</c:when>
            </c:choose>
        </p>
        <a class="waves-effect waves-light btn" href="/cliente/"><i class="material-icons left">arrow_back</i>Volver al inicio</a>

    </body>
</html>