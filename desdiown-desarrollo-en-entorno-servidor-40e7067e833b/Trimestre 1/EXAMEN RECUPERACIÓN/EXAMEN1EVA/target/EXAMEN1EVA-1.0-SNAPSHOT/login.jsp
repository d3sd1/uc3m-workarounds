<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test = "${estadoLogin != null}">
    Error al conectar.</br>
</c:if>
<form>
    <input type="hidden" name="op" value="dologin" />
    <input type="text" name="nombre" placeholder="Nombre" />
    <input type="password" name="contrasena" placeholder="Contraseña" />
    <input type="submit" value="Enviar">
</form>