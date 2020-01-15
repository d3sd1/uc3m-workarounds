<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Funcionalidad de usuarios</title>
        <script src="assets/js/funcionalidad.js"></script>
    </head>

    <body>
        <h1>Cajas</h1>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                </tr>
            </thead>

            <tbody>
                <c:if test = "${cajas != null}">
                    <c:forEach items="${cajas}" var="caja">
                        <tr>
                            <td><c:out value="${caja.nombre}"/></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
        <h1>Cosas</h1>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Cantidad</th>
                </tr>
            </thead>

            <tbody>
                <c:if test = "${cosas != null}">
                    <c:forEach items="${cosas}" var="cosa">
                        <tr>
                            <td><c:out value="${cosa.nombre}"/></td>
                            <td><c:out value="${cosa.cantidad}"/></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
        <button onclick="addCaja()">Añadir caja</button>
        <button onclick="listarcosas()">Listar cosas caja</button>
        <button onclick="addcantidad()">Añadir cantidad</button>
        <button onclick="addCosa()">Añadir cosa</button>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/websockets.js"></script>
        <script src="assets/js/usuario.js"></script>
    </body>
</html>