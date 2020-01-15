<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<a href="/panel">VOLVER AL INICIO</a></br>
<c:if test = "${agregado != null && agregado}">
    Cliente agregado correctamente.</br>
</c:if>
<c:if test = "${agregado != null && !agregado}">
    Cliente NO agregado.</br>
</c:if>
<form>
    <input type="hidden" name="op" value="add" />
    <input type="text" name="nombre" placeholder="Nombre" />
    <input type="password" name="contrasena" placeholder="Contraseña" />
    <input type="number" name="saldo" placeholder="Saldo" />
    <input type="submit" value="Agregar">
</form>