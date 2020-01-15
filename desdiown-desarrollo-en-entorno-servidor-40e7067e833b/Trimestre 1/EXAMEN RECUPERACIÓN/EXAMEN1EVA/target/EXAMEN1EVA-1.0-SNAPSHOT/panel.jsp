<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="utils.AdminUser" %>
Conectado como: <c:out value="${usuarioNombre}"/> </br>
Permisos de administrador: <c:out value="${adminSession}"/> </br>
<c:if test = "${adminSession}">
    <a href="/admin/alta_producto">Alta/Actualización producto</a>
    <a href="/admin/alta_clientes">Alta clientes</a>
</c:if>
<c:if test = "${!adminSession}">
    <a href="/cliente/addproductos">Añadir productos al carrito</a>
    <a href="/cliente/carrito">Ver carrito / Finalizar compra</a>
</c:if>
<a href="/logout">DESCONECTAR</a>